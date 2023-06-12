package model;


import java.sql.*;

public class UserDAO {
    private static final String URL = "jdbc:mysql://localhost/Egzaminodb";
    private static final String[] prisijungimas = new String[]{"root", ""};

    public static void create(User user) throws SQLException {
        Connection connection = DriverManager.getConnection(URL, prisijungimas[0], prisijungimas[1]);
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO users (username, password, email) VALUES (?, ?, ?)");
        preparedStatement.setString(1, user.getUsername());
        preparedStatement.setString(2, user.getPassword());
        preparedStatement.setString(3, user.getEmail());
        preparedStatement.executeUpdate();

        connection.close();
        System.out.println("User added succesfully");
    }

    public static void createUserTableIfNotExists() throws SQLException {
        Connection connection = DriverManager.getConnection(URL, prisijungimas[0], prisijungimas[1]);
        Statement statement = connection.createStatement();
        String sql = "CREATE TABLE IF NOT EXISTS users (" +
                "id INT PRIMARY KEY AUTO_INCREMENT, " +
                "username VARCHAR(255), " +
                "password VARCHAR(255), " +
                "email VARCHAR(255), " +
                "is_admin BOOLEAN DEFAULT FALSE)";
        statement.executeUpdate(sql);
    }
}




