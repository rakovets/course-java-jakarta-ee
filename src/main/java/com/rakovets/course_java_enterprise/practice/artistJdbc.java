package main.java.com.rakovets.course_java_enterprise.practice;

import java.sql.*;
import java.util.Scanner;

class artistJdbc {
    private static final String DATASOURCE_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DATASOURCE_URL = "jdbc:mysql://localhost/music_store";
    private static final String DATASOURCE_USER = "root";
    private static final String DATASOURCE_PASSWORD = "12340987";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try{
            Class.forName(DATASOURCE_DRIVER);
        }
        catch(ClassNotFoundException ex){
            System.out.println("Don't find JDBC driver: " + ex);
        }
        try(Connection connection = DriverManager.getConnection(DATASOURCE_URL, DATASOURCE_USER, DATASOURCE_PASSWORD)) {
            Statement statement = connection.createStatement();
            String answer = scanner.nextLine();
            menu();
            if (answer.equals("1")) {
                getArtists(statement);
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e);
        }
    }

    public static void menu() {
        System.out.println("Choose:\n1. Get all artists\n");
    }

    public static void getArtists(Statement statement) throws SQLException {
        ResultSet rs = statement.executeQuery("SELECT * FROM artist");
        while (rs.next()) {
            System.out.println(rs.getInt(1) + "\t" + rs.getString(2));
        }
    }
}