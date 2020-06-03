package main.java.com.rakovets.course_java_enterprise.solution.dao.impl;

import main.java.com.rakovets.course_java_enterprise.solution.connection.ConnectionManeger;
import main.java.com.rakovets.course_java_enterprise.solution.entity.Restauran;

import java.sql.*;
import java.util.List;
import java.util.Scanner;

public class RestauranDaoImpl implements RestaurantDao<Restauran> {

    Scanner scanner = new Scanner(System.in);

    private static final Object LOCK = new Object();

    private static RestauranDaoImpl INSTANCE = null;

    public static RestauranDaoImpl getInstance() {
        if (INSTANCE == null) {
            synchronized (LOCK) {
                if (INSTANCE == null) {
                    INSTANCE = new RestauranDaoImpl();
                }
            }
        }
        return INSTANCE;
    }

    @Override
    public Restauran add(Restauran restaurant) throws SQLException {
        Connection connection = ConnectionManeger.createConnection();
        PreparedStatement preparedStatement =
                connection.prepareStatement("INSERT INTO restaurant (name) VALUE (?)", Statement.RETURN_GENERATED_KEYS);
        String name = askRestaurantName();
        preparedStatement.setString(1, name);
        long count = preparedStatement.executeUpdate();
        System.out.println("Execute row: " + count);
        ResultSet resultSet = preparedStatement.getGeneratedKeys();
        System.out.println("Exrcute row: " + count);
        if (resultSet.next()){
            restaurant.setId(resultSet.getLong(1));
        }
            return restaurant;
    }

    @Override
    public Restauran show(Restauran restauran) throws SQLException {
        return null;
    }

    @Override
    public List<Restauran> findall() throws SQLException {
        return null;
    }

    private String askRestaurantName() {
        System.out.println("What restauran do you want to add: ");
        String name = scanner.nextLine();
        return name;
    }

}
