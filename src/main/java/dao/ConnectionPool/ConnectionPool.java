package dao.ConnectionPool;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ConnectionPool {

    private static final String PROPERTIES_FILE = "db.properties";
    private static final String PROPERTY_URL = "db.url";
    private static final String PROPERTY_USERNAME = "db.username";
    private static final String PROPERTY_PASSWORD = "db.password";

    private static boolean initialized = false;
    private static List<Connection> connectionPool = new ArrayList<>();
    private static int initialConnections = 5;

    public static void initialize() {
        if (!initialized) {
            try (InputStream inputStream = ConnectionPool.class.getClassLoader().getResourceAsStream(PROPERTIES_FILE)) {
                Properties properties = new Properties();
                properties.load(inputStream);

                String url = properties.getProperty(PROPERTY_URL);
                String username = properties.getProperty(PROPERTY_USERNAME);
                String password = properties.getProperty(PROPERTY_PASSWORD);


                DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());

                for (int i = 0; i < initialConnections; i++) {
                    Connection connection = DriverManager.getConnection(url, username, password);
                    connectionPool.add(connection);
                }

                initialized = true;
            } catch (IOException | SQLException e) {
                throw new RuntimeException("Failed to initialize connection pool", e);
            }
        }
    }

    public static Connection getConnection() throws SQLException {
        if (!initialized) {
            throw new IllegalStateException("Connection pool has not been initialized");
        }

        Connection conn = null;

        synchronized (connectionPool) {
            if (!connectionPool.isEmpty()) {
                conn = connectionPool.remove(0);
            }
        }

        if (conn == null) {
            throw new SQLException("Failed to get a connection from the pool");
        }

        return conn;
    }

    public static void shutdown() throws SQLException {
        for (Connection conn : connectionPool) {
            conn.close();
        }

        connectionPool.clear();
    }

}

