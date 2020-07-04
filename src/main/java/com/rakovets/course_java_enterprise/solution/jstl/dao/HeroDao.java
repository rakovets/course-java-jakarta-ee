package com.rakovets.course_java_enterprise.solution.jstl.dao;

import com.rakovets.course_java_enterprise.solution.jstl.connection.ConnectionManager;
import com.rakovets.course_java_enterprise.solution.jstl.entity.Ability;
import com.rakovets.course_java_enterprise.solution.jstl.entity.Gender;
import com.rakovets.course_java_enterprise.solution.jstl.entity.Hero;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public final class HeroDao {

    private static final String HEROES_TABLE_NAME = "heroes";
    private static final String ABILITIES_TABLE_NAME = "abilities";
    private static HeroDao INSTANCE = null;

    private HeroDao() {
    }

    public static HeroDao getInstance() {
        if (INSTANCE == null) {
            synchronized (HeroDao.class) {
                if (INSTANCE == null) {
                    INSTANCE = new HeroDao();
                }
            }
        }
        return INSTANCE;
    }

    public void create(Hero hero, long abilityId) {
        try (Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO heroes (name, identity, age, gender, ability_id) " +
                            "VALUES (?, ?, ?, ?, ?)")) {
                preparedStatement.setString(1, hero.getName());
                preparedStatement.setString(2, hero.getIdentity());
                preparedStatement.setInt(3, hero.getAge());
                preparedStatement.setString(4, hero.getGender().toString());
                preparedStatement.setLong(5, abilityId);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Hero> findAll() {
        List<Hero> heroes = new ArrayList<>();
        try (Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM heroes JOIN abilities ON heroes.ability_id = abilities.id;")) {
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        heroes.add(createHeroFromResultSet(resultSet));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return heroes;
    }

    public Optional<Hero> findById(long id) {
        try (Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM heroes " +
                            "JOIN abilities ON heroes.ability_id = abilities.id " +
                            "WHERE heroes.id = ?")) {
                preparedStatement.setLong(1, id);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        return Optional.of(createHeroFromResultSet(resultSet));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    private Hero createHeroFromResultSet(ResultSet resultSet) throws SQLException {
        return new Hero(
                resultSet.getLong(HEROES_TABLE_NAME + ".id"),
                resultSet.getString(HEROES_TABLE_NAME + ".name"),
                resultSet.getString(HEROES_TABLE_NAME + ".identity"),
                resultSet.getInt(HEROES_TABLE_NAME + ".age"),
                Gender.valueOf(resultSet.getString(HEROES_TABLE_NAME + ".gender")),
                new Ability(resultSet.getLong(ABILITIES_TABLE_NAME + ".id"),
                        resultSet.getString(ABILITIES_TABLE_NAME + ".name")));
    }
}
