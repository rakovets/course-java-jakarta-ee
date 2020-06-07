package main.java.com.rakovets.course_java_enterprise.solution.dao.inst;

import main.java.com.rakovets.course_java_enterprise.solution.connection.ConnectionManager;
import main.java.com.rakovets.course_java_enterprise.solution.dao.ReviewDao;
import main.java.com.rakovets.course_java_enterprise.solution.entity.Review;

import java.sql.*;

public class ReviewDaoInst implements ReviewDao<Review> {
	@Override
	public Review save(Review review) {
		try {
			Connection connection = ConnectionManager.getConnection();
			System.out.println("\nJDBC connected!");
			try (PreparedStatement preparedStatement = connection.prepareStatement(
					"INSERT INTO review (content, restaurant_id) VALUE (?, ?)", Statement.RETURN_GENERATED_KEYS)) {
				preparedStatement.setString(1, review.getContent());
				preparedStatement.setInt(2, review.getRestaurantID());
				preparedStatement.executeUpdate();
				ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
				if (generatedKeys.next()) {
					review.setId(generatedKeys.getInt(1));
				}
				preparedStatement.addBatch(String.format("INSERT INTO restaurant_review (restaurant_id, review_id)" +
								" VALUE (%d, %d)", review.getRestaurantID(), review.getId()));
				preparedStatement.executeBatch();
				System.out.print("Added new ");
			}
		} catch (SQLException e) {
			System.out.println("SQLException: " + e);
		}
		return review;
	}
}