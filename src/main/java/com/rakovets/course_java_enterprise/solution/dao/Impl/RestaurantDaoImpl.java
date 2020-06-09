package main.java.com.rakovets.course_java_enterprise.solution.dao.Impl;

import main.java.com.rakovets.course_java_enterprise.solution.connection.ConnectionManager;

import main.java.com.rakovets.course_java_enterprise.solution.dao.RestaurantDao;
import main.java.com.rakovets.course_java_enterprise.solution.entity.Dish;
import main.java.com.rakovets.course_java_enterprise.solution.entity.Restaurant;

import java.sql.*;

public class RestaurantDaoImpl implements RestaurantDao {
    private static final Object LOCK = new Object();
    private static RestaurantDaoImpl INSTANCE = null;

    public static RestaurantDaoImpl getInstance() {
        if (INSTANCE == null) {
            synchronized (LOCK) {
                if (INSTANCE == null) {
                    INSTANCE = new RestaurantDaoImpl();
                }
            }
        }
        return INSTANCE;
    }

    @Override
    public Restaurant save(Restaurant restaurant) {
        try (Connection connection = ConnectionManager.getConnection()) {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("INSERT INTO restaurant (name) VALUES (?)",
                            Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, restaurant.getName());

            long count = preparedStatement.executeUpdate();
            System.out.println("Rows added in DB: " + count);
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                restaurant.setId(generatedKeys.getLong(1));
                return restaurant;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return restaurant;
    }

    @Override
    public Dish saveDishToRestaurant(Dish dish, long restaurantId) {
        if (checkIdOfRestaurantOnExist(restaurantId)) {
            try(Connection connection = ConnectionManager.getConnection()) {
                PreparedStatement preparedStatement =
                        connection.prepareStatement("INSERT INTO dish (name) VALUES (?)",
                                Statement.RETURN_GENERATED_KEYS);
                preparedStatement.setString(1, dish.getName());

                long count = preparedStatement.executeUpdate();
                System.out.println("Dish saved. Rows added in DB with dishes: " + count);

                ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    dish.setId(generatedKeys.getLong(1));
                }

                PreparedStatement ps = connection.
                        prepareStatement("INSERT INTO restaurant_dish (restaurant_id, dish_id) VALUES (?, ?)");
                ps.setLong(1, restaurantId);
                ps.setLong(2, dish.getId());

                long countOfRows = ps.executeUpdate();
                System.out.println("ID of restaurant and dish saved. Rows added in DB with dishes: " + countOfRows);

            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("This restaurant not exist");
            dish.setName("Not saved");
        }
        return dish;
    }

    public boolean checkIdOfRestaurantOnExist(long id) {
        boolean idExist = false;
        try(Connection connection = ConnectionManager.getConnection()) {
            PreparedStatement ps = connection.prepareStatement("SELECT id FROM restaurant WHERE id = ?");
            ps.setLong(1, id);

            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                if (resultSet.getLong("id") == id) {
                    idExist = true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return idExist;
    }

    @Override
    public Restaurant find(long id) throws SQLException {
        return null;
    }

    @Override
    public Restaurant update(Restaurant restaurant) throws SQLException {
        return null;
    }

    @Override
    public boolean delete(Restaurant restaurant) throws SQLException {
        return false;
    }
}
