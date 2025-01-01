package com.vs.repository;

import java.sql.*;
import com.vs.model.User;
import io.github.cdimascio.dotenv.Dotenv;

public class UserRepository {
    private String url;
    private String username;
    private String password;

    public UserRepository(String envFile) {
        // Load environment variables from the specified .env file in the env folder
        Dotenv dotenv = Dotenv.configure()
                .directory("env")
                .filename(envFile) // Specify the filename
                .load();
        this.url = dotenv.get("DB_URL");
        this.username = dotenv.get("DB_USERNAME");
        this.password = dotenv.get("DB_PASSWORD");
    }

    // Create a new user
    public void createUser(User user) {
        String sql = "INSERT INTO users (user_name, salt, hash_password) VALUES (?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(url, username, password);
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, user.getUserName());
            pstmt.setString(2, user.getSalt());
            pstmt.setString(3, user.getHashPassword());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Get a user by userName
    public User getUser(String userName) {
        String sql = "SELECT user_name,salt,hash_password FROM users WHERE user_name = ?";
        User user = null;
        try (Connection conn = DriverManager.getConnection(url, username, password);
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, userName);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                user = new User(rs.getString("user_name"), rs.getString("salt"), rs.getString("hash_password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    // Delete a user
    public void deleteUser(String userName) {
        String sql = "DELETE FROM users WHERE user_name = ?";
        try (Connection conn = DriverManager.getConnection(url, username, password);
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, userName);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
