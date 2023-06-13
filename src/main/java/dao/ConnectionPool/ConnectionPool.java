package dao.ConnectionPool;
import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionPool {

    private static BasicDataSource dataSource;

    static {
        dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/Farm");
        dataSource.setUsername("root");
        dataSource.setPassword("33Shadow16");

        dataSource.setMinIdle(5);
        dataSource.setMaxIdle(20);
        dataSource.setMaxTotal(50);
        dataSource.setMaxWaitMillis(30000);
    }

    public static BasicDataSource getDataSource() {
        return dataSource;
    }

    public static Connection getConnection() {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException("Error getting database connection", e);
        }
    }
    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println("Error closing database connection");
                e.printStackTrace();
            }
        }
    }

    public static void shutdown() {
        try {
            dataSource.close();
        } catch (SQLException e) {
            System.out.println("Error shutting down connection pool");
            e.printStackTrace();
        }
    }
}
