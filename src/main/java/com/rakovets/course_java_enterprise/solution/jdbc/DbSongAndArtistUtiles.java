package main.java.com.rakovets.course_java_enterprise.solution.jdbc;

import java.sql.*;
import java.util.Scanner;

public class DbSongAndArtistUtiles {

    Connection connection = new Main().createConection();
    Scanner scanner = new Scanner(System.in);

    public void addArtist() throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement
                ("INSERT INTO artist (name) VALUES (?)");
        String name = askArtistmName();
        preparedStatement.setString(1, name);
        preparedStatement.executeUpdate();
        System.out.printf("Ваш артист под именем : %s", name + " " + "был успешно дабавлен!!");
    }

    public void addSong() throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement
                ("INSERT INTO song (title , length , artist_id) VALUES (? , ? , ?)");
        String title = askSOngTitle();
        Integer songLeng = askSongLenght();
        Integer songAutorsId = askInSongAutorsID();
        preparedStatement.setString(1, title);
        preparedStatement.setInt(2, songLeng);
        preparedStatement.setInt(3,songAutorsId);
        preparedStatement.executeUpdate();
        System.out.printf("Ваша пенся под названием : %s", title + " " + "была успешно дабавлен!!");
    }

    public void showArtist() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM artist ");
        while (resultSet.next()) {
            System.out.printf("{\n\t\"id\":%d,\n\t\"name\":\"%s\n\t\"",
                    resultSet.getInt("artist_id"), resultSet.getString("name"));
        }
    }

    public void showSong() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM song ");
        while (resultSet.next()) {
            System.out.printf("{\n\t\"id\":%d,\n\t\"title\":\"%s\"\n\t\"lenght\":%d,\n\t\"artist_id\":%d",
                    resultSet.getInt("song_id"),
                    resultSet.getString("title"),
                    resultSet.getInt("length"),
                    resultSet.getInt("artist_id"));
        }
    }

    public void deletArtist() throws SQLException {
        showArtist();
        PreparedStatement preparedStatement = connection.prepareStatement
                ("DELETE from artist where artist_id=?;");
        Integer id = askArtistID();
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
        System.out.printf("Вы успешно удалили Артиста  под id: %s ", id);
    }

    public void deletSong() throws SQLException {
        showSong();
        PreparedStatement preparedStatement = connection.prepareStatement
                ("DELETE from song where song_id=?;");
        Integer id = askSongID();
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
        System.out.printf("Вы успешно удалили Песню под id: %s ", id);
    }


    private String askArtistmName() {
        System.out.println("What Artist do you want to add: ");
        String name = scanner.nextLine();
        return name;
    }

    private String askSOngTitle() {
        System.out.println("What Song do you want to add: ");
        String name = scanner.nextLine();
        return name;
    }

    private Integer askArtistID() {
        System.out.println("What Artist do you want to delete: ");
        Integer id = scanner.nextInt();
        return id;
    }

    private Integer askSongID() {
        System.out.println("What Song do you want to delete: ");
        Integer id = scanner.nextInt();
        return id;
    }
    private Integer askSongLenght() {
        System.out.println("What leng of song on minut you want: ");
        Integer songLenght = scanner.nextInt();
        return songLenght;
    }

    private Integer askInSongAutorsID() {
        System.out.println("What id of autors you wand to add: ");
        Integer songAutorId = scanner.nextInt();
        return songAutorId;
    }

}

