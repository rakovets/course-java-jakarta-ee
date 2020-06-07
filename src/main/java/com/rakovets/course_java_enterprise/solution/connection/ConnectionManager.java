package main.java.com.rakovets.course_java_enterprise.solution.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
	private static final String DATASOURCE_DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String DATASOURCE_URL = "jdbc:mysql://localhost:3306/restaurant?serverTimezone=Europe/Moscow";
	private static final String DATASOURCE_USER = "root";
	private static final String DATASOURCE_PASSWORD = "1234";

	public static Connection getConnection() throws SQLException {
		try {
			Class.forName(DATASOURCE_DRIVER);
		} catch (ClassNotFoundException e) {
			System.out.println("Didn't found JDBC Driver: " + DATASOURCE_DRIVER);
		}
		return DriverManager.getConnection(DATASOURCE_URL, DATASOURCE_USER, DATASOURCE_PASSWORD);
	}
}