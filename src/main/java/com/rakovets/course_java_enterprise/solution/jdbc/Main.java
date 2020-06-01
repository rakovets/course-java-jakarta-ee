package main.java.com.rakovets.course_java_enterprise.solution.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    private static final String DATASOURSE_URL = "jdbc:mysql://localhost:3306/music_store?useUnicode=true&serverTimezone=UTC";
    private static final String DATASOURSE_USER = "root";
    private static final String DATASOURSE_PASSWORD = "root";

    public static void main(String[] args) {

        MusickStoreDemo songAndArtistDemo = new MusickStoreDemo();
        songAndArtistDemo.MusicStoreMinu();
    }

    public static Connection createConection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DATASOURSE_URL, DATASOURSE_USER, DATASOURSE_PASSWORD);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return connection;
    }
}

