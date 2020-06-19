package com.rakovets.course_java_enterprise.solution.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
    private static final String DATASOURCE_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DATASOURCE_URL = "jdbc:mysql://localhost/restaurant" +
            "?serverTimezone=Europe/Minsk&useSSL=false";
    private static final String DATASOURCE_USER = "root";
    private static final String DATASOURCE_PASSWORD = "12340987";

    static {
        try {
            Class.forName(DATASOURCE_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DATASOURCE_URL, DATASOURCE_USER, DATASOURCE_PASSWORD);
    }
}
