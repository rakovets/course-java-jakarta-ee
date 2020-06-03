package main.java.com.rakovets.course_java_enterprise.practice;

import java.sql.*;
import java.util.PropertyResourceBundle;
import java.util.Scanner;

class artistJdbc {
    private static final String DATASOURCE_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DATASOURCE_URL = "jdbc:mysql://localhost/music_store";
    private static final String DATASOURCE_USER = "root";
    private static final String DATASOURCE_PASSWORD = "12340987";

    public static void main(String[] args) {
        Boolean menuWork = true;
        Scanner scanner = new Scanner(System.in);
        try{
            Class.forName(DATASOURCE_DRIVER);
        }
        catch(ClassNotFoundException ex){
            System.out.println("Don't find JDBC driver: " + ex);
        }
        try(Connection connection = DriverManager.getConnection(DATASOURCE_URL, DATASOURCE_USER, DATASOURCE_PASSWORD)) {
            Statement statement = connection.createStatement();

            while (menuWork) {
                menu();
                String answer = scanner.nextLine();
                if (answer.equals("1")) {
                    getArtists(statement);
                } else if (answer.equals("2")) {
                    getSongs(statement);
                } else if (answer.equals("3")) {
                    getArtistById(connection);
                } else if (answer.equals("4")) {
                    getSongById(connection);
                } else if (answer.equals("5")) {
                    createArtist(connection);
                } else if (answer.equals("6")) {
                    createSong(connection);
                }
            }

        } catch (SQLException e) {
            System.out.println("SQLException: " + e);
        }
    }

    public static void menu() {
        System.out.println("\nChoose number:\n1. get all artists\n2. get all songs\n3. get Artist By Id\n" +
                "4. get song by id\n5. add new artist\n6. add new song\n");
    }

    public static void getArtists(Statement statement) throws SQLException {
        ResultSet rs = statement.executeQuery("SELECT * FROM artist");
        System.out.println("Artists:\nid" + "\t" +"name");
        while (rs.next()) {
            System.out.println(rs.getInt(1) + "\t" + rs.getString(2));
        }
    }

    public static void getSongs(Statement statement) throws SQLException {
        ResultSet rs = statement.executeQuery("SELECT * FROM song");
        System.out.println("Songs:\nid, title, length, artist_id\n" +
                "-----------------------------------");
        while (rs.next()) {
            System.out.println(rs.getInt("id") + ", " + rs.getString("title") +
                    ", " + rs.getInt("length") + ", " + rs.getInt("artist_id"));
        }
    }

    public static void getArtistById(Connection connection) throws SQLException {
        System.out.println("Enter id of artist:");
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();
        String sql = "SELECT * FROM artist WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        ResultSet rs = preparedStatement.executeQuery();
        System.out.println("\nArtist:\nid" + "\t" +"name");
        while (rs.next()) {
            System.out.println(rs.getInt(1) + "\t" + rs.getString(2));
        }
    }

    public static void getSongById(Connection connection) throws SQLException {
        System.out.println("Enter id of song:");
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();
        String sql = "SELECT * FROM song WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        ResultSet rs = preparedStatement.executeQuery();
        System.out.println("Song:\nid, title, length, artist_id\n" +
                "-----------------------------------");
        while (rs.next()) {
            System.out.println(rs.getInt("id") + ", " + rs.getString("title") +
                    ", " + rs.getInt("length") + ", " + rs.getInt("artist_id"));
        }
    }

    public static void createArtist(Connection connection) throws SQLException {
        System.out.println("Enter name of artist:");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        String sql = "INSERT INTO artist(name) VALUES (?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, name);

        int rows = preparedStatement.executeUpdate();
        System.out.println("Rows added: " + rows);
    }

    public static void createSong(Connection connection) throws SQLException {
        System.out.println("Enter title of song:");
        Scanner scanner = new Scanner(System.in);
        String title = scanner.nextLine();

        System.out.println("Enter length of song:");
        String length = scanner.nextLine();

        System.out.println("Enter artist ID of song:");
        String artistId = scanner.nextLine();

        String sql = "INSERT INTO song(title, length, artist_id) VALUES (?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, title);
        preparedStatement.setString(2, length);
        preparedStatement.setString(3, artistId);

        int rows = preparedStatement.executeUpdate();
        System.out.println("Rows added: " + rows);
    }
}