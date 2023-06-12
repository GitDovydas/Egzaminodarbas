package model;

import java.sql.*;

public class FilmDAO {

    private static final String URL = "jdbc:mysql://localhost/Egzaminodb";
    private static final String[] prisijungimas = new String[]{"root", ""} ;

    public static void createFilmTableIfNotExists() throws SQLException {
        Connection connection = DriverManager.getConnection(URL, prisijungimas[0], prisijungimas[1]);
        Statement statement = connection.createStatement();
        String sql = "CREATE TABLE IF NOT EXISTS films (" +
                "id INT PRIMARY KEY AUTO_INCREMENT, " +
                "name VARCHAR(255), " +
                "description VARCHAR(255), " +
                "rating DECIMAL(2,1), " +
                "category VARCHAR(255)" +
                ")";
        statement.executeUpdate(sql);
    }

}
