package com.hogwarts.register.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
    private static final String USERNAME = "josue";
    private static final String PASSWORD = "josue";
    private static final String MYSQL_CONN_STRING = "jdbc:mysql://localhost/hogwarts";

    private static ConnectionManager connectionManager = null;
    private static Connection conn = null;

    private ConnectionManager() {
    }

    private static ConnectionManager createConnection() {
        if (connectionManager == null) {
            connectionManager = new ConnectionManager();
        }
        return connectionManager;
    }

    public static Connection connectToDb() {
        try {
            conn = DriverManager.getConnection(MYSQL_CONN_STRING, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static void close() {
        try {
            conn.close();
            conn = null;
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


}
