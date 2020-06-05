package main.java.com.rakovets.course_java_enterprise.solution.entity;

import main.java.com.rakovets.course_java_enterprise.solution.dao.impl.DishDaoImpl;
import main.java.com.rakovets.course_java_enterprise.solution.dao.impl.RestauranDaoImpl;
import main.java.com.rakovets.course_java_enterprise.solution.dao.impl.ReviewDaoImpl;

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
            System.out.println("\n\tПожалуста выбирете что хотите сделать: " +
                    "\n\t1.--Добавить рестаран:-- \n\t" +
                    "\n\t2.--Посмотреть все ресторанны:-- \n\t" +
                    "\n\t3.--Добавить блюдо:-- \n\t" +
                    "\n\t4.--Посмотреть все блюда:-- \n\t" +
                    "\n\t5.--Добавить отзыв:-- \n\t" +
                    "\n\t6.--Посмотреть все отзывы:-- \n\t" +
                    "\n\t7.--Добавить блюдо в ресторан:-- \n\t" +
                    "\n\t8.--Выход:-- \n\t ");
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
                    Metd metd = new Metd();
                    String askContent = metd.askContent();
                    ReviewDaoImpl reviewDao = ReviewDaoImpl.getInstance();
                    reviewDao = ReviewDaoImpl.getInstance();
                    try {
                        Review addReview = reviewDao.add(new Review(askContent));
                    } catch (SQLException e) {
                        System.out.println("SQLException" + e);
                        e.printStackTrace();
                    }
                    break;

                case 6:
                    System.out.println("Все отзывы преставленны ниже: ");
                    ReviewDaoImpl reviewDao1 = new ReviewDaoImpl();
                    try {
                        reviewDao1.show(new Review(reviewDao1.toString()));
                    } catch (SQLException e) {
                        System.out.println("SQLException" + e);
                        e.printStackTrace();
                    }
                    break;

                case 7:
                    System.out.println("Введите id блюда: ");
                    Integer idDish = scanner.nextInt();
                    System.out.println("Введите id ресторана: ");
                    Integer idRestauran = scanner.nextInt();
                    RestauranDaoImpl restauranDao2 = new RestauranDaoImpl();
                    try {
                        Dish dish = restauranDao2.linkDish(idRestauran ,idDish);
                        System.out.println("Блюдо: " + dish.getName() + " Добавленно к ресторанну: " + idRestauran);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;

                case 8:
                    runMain = false;
                    System.out.println("Выходите из ресторанна!!");
                    break;
                default:
                    System.out.println("Не верно указан номер!!!");
            }
        }
    }
}
