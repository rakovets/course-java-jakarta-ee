package main.java.com.rakovets.course_java_enterprise.solution.entity;

import main.java.com.rakovets.course_java_enterprise.solution.dao.impl.DishDaoImpl;
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
                    "\n3.--Добавить блюдо:-- \t" +
                    "\n4.--Посмотреть все блюда:-- \t" +
                    "\n5.--Выход:--  \t ");
            int scanmain = scanner.nextInt();
            switch (scanmain) {
                case 1:
                    System.out.println("Введите ресторан:");
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
                    RestauranDaoImpl restauranDao1 = new RestauranDaoImpl();
                    try {
                        restauranDao1.show(new Restauran(restauranDao1.toString()));
                    } catch (SQLException e) {
                        System.out.println("SQLException" + e);
                        e.printStackTrace();
                    }
                    break;

                case 3:
                    System.out.println("Введите блюдо:");
                    String nameDish = scanner.next();
                    DishDaoImpl dishDao = DishDaoImpl.getInstance();
                    dishDao = DishDaoImpl.getInstance();
                    try {
                        Dish addDissh = dishDao.add(new Dish(nameDish));
                        System.out.println("Вы добавилли блюдо: " + addDissh.getName());
                    } catch (SQLException e) {
                        System.out.println("SQLException" + e);
                        e.printStackTrace();
                    }
                    break;

                case 4:
                    System.out.println("Все блюда преставленны ниже: ");
                    DishDaoImpl dishDao1 = new DishDaoImpl();
                    try {
                        dishDao1.show(new Dish(dishDao1.toString()));
                    } catch (SQLException e) {
                        System.out.println("SQLException" + e);
                        e.printStackTrace();
                    }
                    break;

                case 5:
                    runMain = false;
                    System.out.println("Выходите из ресторанна!!");
                    break;
                default:
                    System.out.println("Не верно указан номер!!!");
            }
        }
    }
}
