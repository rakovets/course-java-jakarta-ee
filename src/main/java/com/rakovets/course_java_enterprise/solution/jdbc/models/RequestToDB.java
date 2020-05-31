package main.java.com.rakovets.course_java_enterprise.solution.jdbc.models;

import java.sql.*;

public class RequestToDB {
	private final String DATASOURCE_DRIVER = "com.mysql.cj.jdbc.Driver";
	private final String DATASOURCE_URL = "jdbc:mysql://localhost:3306/music_store?serverTimezone=Europe/Moscow";
	private final String DATASOURCE_USER = "root";
	private final String DATASOURCE_PASSWORD = "1234";

	public void returnAllArtists() {
		try {
			Class.forName(DATASOURCE_DRIVER);
		} catch (ClassNotFoundException e) {
			System.out.println("Didn't found JDBC Driver: " + DATASOURCE_DRIVER);
		}
		try(Connection connection = DriverManager.getConnection(DATASOURCE_URL, DATASOURCE_USER, DATASOURCE_PASSWORD)) {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM artist ORDER BY artist_id");
			while (resultSet.next()) {
				System.out.printf("%d.\t\"%s\"\n", resultSet.getInt("artist_id"), resultSet.getString("name"));
			}
		} catch (SQLException e) {
			System.out.println("SQLException: " + e);
		}
	}

	public void returnAllSongs() {
		try {
			Class.forName(DATASOURCE_DRIVER);
		} catch (ClassNotFoundException e) {
			System.out.println("Didn't found JDBC Driver: " + DATASOURCE_DRIVER);
		}
		try(Connection connection = DriverManager.getConnection(DATASOURCE_URL, DATASOURCE_USER, DATASOURCE_PASSWORD)) {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM song ORDER BY song_id");
			while (resultSet.next()) {
				System.out.printf("%d.\t\"%s\"\n", resultSet.getInt("song_id"), resultSet.getString("title"));
			}
		} catch (SQLException e) {
			System.out.println("SQLException: " + e);
		}
	}

	public void returnArtistById(int id) {
		boolean idNoExist = true;
		try {
			Class.forName(DATASOURCE_DRIVER);
		} catch (ClassNotFoundException e) {
			System.out.println("Didn't found JDBC Driver: " + DATASOURCE_DRIVER);
		}
		try(Connection connection = DriverManager.getConnection(DATASOURCE_URL, DATASOURCE_USER, DATASOURCE_PASSWORD)) {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM artist ORDER BY artist_id");
			while (resultSet.next()) {
				if (resultSet.getInt("artist_id") == id) {
					System.out.printf("id %d  -  \"%s\"\n", resultSet.getInt("artist_id"),
							resultSet.getString("name"));
					idNoExist = false;
				}
			}
			if (idNoExist) {
				System.out.println("ID NOT EXIST");
			}
		} catch (SQLException e) {
			System.out.println("SQLException: " + e);
		}
	}

}