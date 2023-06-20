package dao.ConnectionPool;

import org.apache.commons.dbcp2.BasicDataSource;


import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import static org.farm.Main.LOGGER;

public class ConnectionPool {

    private static final String PROPERTY_FILE = "src/main/java/dao/database.properties";
    private static final BasicDataSource dataSource = new BasicDataSource();
    private static ConnectionPool instance;

    private ConnectionPool() {
        loadDatabaseProperties();
        configureDataSource();
    }

    public static ConnectionPool getInstance() {
        if (instance == null) {
            instance = new ConnectionPool();
        }
        return instance;
    }

    private void loadDatabaseProperties() {
        DriverManager.setLogWriter(new PrintWriter(System.out));

        Properties properties = new Properties();
        try (InputStream is = ConnectionPool.class.getClassLoader().getResourceAsStream("database.properties")) {
            properties.load(is);
            dataSource.setUrl(properties.getProperty("db.url"));
            dataSource.setUsername(properties.getProperty("db.username"));
            dataSource.setPassword(properties.getProperty("db.password"));
        } catch (IOException e) {
            LOGGER.info("Error loading database properties: " + e.getMessage());
        }
    }

    private void configureDataSource() {
        dataSource.setInitialSize(5); // Set the initial number of connections
        dataSource.setMaxTotal(10); // Set the maximum number of connections
        // You can set additional properties of the data source here
    }

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    public void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                LOGGER.info("Error closing database connection");
                e.printStackTrace();
            }
        }
    }

    public static void shutdown() {
        try {
            dataSource.close();
        } catch (SQLException e) {
            LOGGER.info("Error shutting down connection pool");
            e.printStackTrace();
        }
    }
}
