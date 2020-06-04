package main.java.com.rakovets.course_java_enterprise.solution.entity;

import main.java.com.rakovets.course_java_enterprise.solution.dao.impl.RestauranDaoImpl;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class RestauranDemo {

    Scanner scanner = new Scanner(System.in);

    public void Meniu() {
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("Сегодня: EEEE HH:mm:ss");
        System.out.println(dateTime.format(formatter));
        dateTime.format(DateTimeFormatter.ofPattern("EEEE"));
        System.out.println("(Добро пожаловать в наш ресторан!!!!)");
        boolean runMain = true;
        while (runMain) {
            System.out.println("\n1.--Добавить рестаран:-- \t" +
                    "\n2.--Посмотреть все ресторанны:-- \t" +
                    "\n3.--Выход:--  \t ");
            int scanmain = scanner.nextInt();
            switch (scanmain) {
                case 1:
                    System.out.println("Введите ресторвн :");
                    String nameRestauran = scanner.next();
                    RestauranDaoImpl restauranDao = RestauranDaoImpl.getInstance();
                    restauranDao = RestauranDaoImpl.getInstance();
                    try {
                        Restauran addResatauran = restauranDao.add(new Restauran(nameRestauran));
                        System.out.println("Вы добавилли ресторан: " + addResatauran.getName());
                    } catch (SQLException e) {
                        System.out.println("SQLException" + e);
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    System.out.println("Все ресторанны преставленны ниже: ");
                    RestauranDaoImpl restauranDao1 = RestauranDaoImpl.getInstance();
                    restauranDao1 = RestauranDaoImpl.getInstance();
                    try {
                        restauranDao1.show(new Restauran(restauranDao1.toString()));
                    } catch (SQLException e) {
                        System.out.println("SQLException" + e);
                        e.printStackTrace();
                    }
                    break;
                case 3:
                    runMain = false;
                    System.out.println("Выходите из ресторанна!!");
                    break;
                default:
                    System.out.println("Не верно указан номер!!!");
            }
        }
    }
}
