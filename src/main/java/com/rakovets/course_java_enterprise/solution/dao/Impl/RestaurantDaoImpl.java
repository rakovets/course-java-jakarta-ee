package main.java.com.rakovets.course_java_enterprise.solution.dao.Impl;

import main.java.com.rakovets.course_java_enterprise.solution.connection.ConnectionManager;

import main.java.com.rakovets.course_java_enterprise.solution.dao.RestaurantDao;
import main.java.com.rakovets.course_java_enterprise.solution.entity.Dish;
import main.java.com.rakovets.course_java_enterprise.solution.entity.Restaurant;
import main.java.com.rakovets.course_java_enterprise.solution.entity.Review;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

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
                System.out.println("ID of restaurant and dish saved. Rows added in DB with dishes and restaurants: "
                        + countOfRows);

            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("This restaurant not exist");
            dish.setName("Not saved");
        }
        return dish;
    }

    @Override
    public Review saveReviewToRestaurant(Review review, long restaurantId) {
        if (checkIdOfRestaurantOnExist(restaurantId)) {
            try(Connection connection = ConnectionManager.getConnection()) {
                PreparedStatement preparedStatement =
                        connection.prepareStatement("INSERT INTO review (content, restaurant_id) VALUES (?, ?)",
                                Statement.RETURN_GENERATED_KEYS);
                preparedStatement.setString(1, review.getContent());
                preparedStatement.setLong(2, restaurantId);

                long count = preparedStatement.executeUpdate();
                System.out.println("Review saved. Rows added in DB with reviews: " + count);

                ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    review.setId(generatedKeys.getLong(1));
                }

                PreparedStatement ps = connection.
                        prepareStatement("INSERT INTO restaurant_review (restaurant_id, review_id) VALUES (?, ?)");
                ps.setLong(1, restaurantId);
                ps.setLong(2, review.getId());

                long countOfRows = ps.executeUpdate();
                System.out.println("ID of restaurant and review saved. Rows added in DB with reviews and restaurants: "
                        + countOfRows);

            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("This restaurant not exist");
            review.setContent("Not saved");
        }
        return review;
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
    public Restaurant getRestaurantById(long restaurantId) {
        Set<Dish> dishes = new HashSet<>();
        Set<Review> reviews = new HashSet<>();
        Restaurant restaurant = null;

        if (checkIdOfRestaurantOnExist(restaurantId)) {
            try(Connection connection = ConnectionManager.getConnection()) {
                Statement statement = connection.createStatement();
                ResultSet resultSetOfRestaurants =
                        statement.executeQuery(String.format("SELECT * FROM restaurant WHERE id = %d", restaurantId));
                while (resultSetOfRestaurants.next()) {
                    restaurant = new Restaurant(resultSetOfRestaurants.getString("name"));
                    restaurant.setId(resultSetOfRestaurants.getLong("id"));
                }

                ResultSet resultSetOfDishes =
                        statement.executeQuery(String.format("SELECT d.name FROM restaurant AS r\n" +
                                "JOIN restaurant_dish AS rd ON r.id = rd.restaurant_id\n" +
                                "JOIN dish AS d ON d.id = rd.dish_id\n" +
                                "WHERE r.id = %d;", restaurantId));
                while (resultSetOfDishes.next()) {
                    dishes.add(new Dish(resultSetOfDishes.getString("name")));
                }
                restaurant.setDishes(dishes);

                ResultSet resultSetOfReviews =
                        statement.executeQuery(String.format("SELECT r.id,  rev.content FROM restaurant AS r\n" +
                                "JOIN restaurant_review AS rr ON r.id = rr.restaurant_id\n" +
                                "JOIN review AS rev ON rev.id = rr.review_id\n" +
                                "WHERE r.id = %d;", restaurantId));
                while (resultSetOfReviews.next()) {
                    reviews.add(new Review(resultSetOfReviews.getString("content"),
                            resultSetOfReviews.getLong("id")));
                }
                restaurant.setReviews(reviews);

            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("This restaurant not exist");
        }
        return restaurant;
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
