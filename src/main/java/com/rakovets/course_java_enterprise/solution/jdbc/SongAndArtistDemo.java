package main.java.com.rakovets.course_java_enterprise.solution.jdbc;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class SongAndArtistDemo {

    Scanner scanner = new Scanner(System.in);

    public void MusicStoreMinu() {
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("Сегодня: EEEE HH:mm:ss");
        System.out.println(dateTime.format(formatter));
        dateTime.format(DateTimeFormatter.ofPattern("EEEE"));
        System.out.println("(Добро пожаловать в Музыкальный магазин!!!!)");
        boolean runMain = true;
        while (runMain) {
            System.out.println("");
            System.out.println("\n\tПожалуста выбирете что хотите сделать: \n\t 1.Добавить Артиста \n\t " +
                    "2.Добавить Песню  \n\t " +
                    "3.Посмотреть Песни \n\t " +
                    "4.Посмотреть Артистов \n\t " +
                    "5.Удалить Артиста \n\t " +
                    "6.Удалить Песню \n\t " +
                    "7.Выйти \n\t");
            int scanmain = scanner.nextInt();
            switch (scanmain) {
                case 1:
                    DbSongAndArtistUtiles dbSongAndArtistUtiles = new DbSongAndArtistUtiles();
                    try {
                        dbSongAndArtistUtiles.addArtist();
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                    break;

                case 2:
                    DbSongAndArtistUtiles dbSongAndArtistUtiles1 = new DbSongAndArtistUtiles();
                    try {
                        dbSongAndArtistUtiles1.addSong();
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                    break;

                case 3:
                    System.out.println("Все песни можете увидеть снизу: ");
                    DbSongAndArtistUtiles dbSongAndArtistUtiles2 = new DbSongAndArtistUtiles();
                    try {
                        dbSongAndArtistUtiles2.showSong();
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                    break;

                case 4:
                    System.out.println("Всех артистов можете увидеть снизу: ");
                    DbSongAndArtistUtiles dbSongAndArtistUtiles3 = new DbSongAndArtistUtiles();
                    try {
                        dbSongAndArtistUtiles3.showArtist();
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                    break;

                case 5:
                    DbSongAndArtistUtiles dbSongAndArtistUtiles4 = new DbSongAndArtistUtiles();
                    try {
                        dbSongAndArtistUtiles4.deletArtist();
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                    break;

                case 6:
                    DbSongAndArtistUtiles dbSongAndArtistUtiles5 = new DbSongAndArtistUtiles();
                    try {
                        dbSongAndArtistUtiles5.deletSong();
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                    break;

                case 7:
                    runMain = false;
                    System.out.println("Уходите из-нашего Музыкального магазина !!!!");
                    break;
                default:
                    System.out.println("Не верно указан номер!!!");
            }
        }
    }

}
