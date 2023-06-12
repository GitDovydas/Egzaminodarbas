package controller;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import model.Film;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class UserDashboardController implements Initializable {
    @FXML
    private TableView<Film> table;
    @FXML
    private TableColumn<Film, String> filmNameColumn;
    @FXML
    private TableColumn<Film, Double> filmRatingColumn;
    @FXML
    private TableColumn<Film, String> filmCategoryColumn;

    private ObservableList<Film> films = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        table.setItems(films);

        filmNameColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getName()));
        filmRatingColumn.setCellValueFactory(data -> new SimpleDoubleProperty(data.getValue().getRating()).asObject());
        filmCategoryColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getCategory()));

        retrieveFilmsFromDatabase();
    }

    private void retrieveFilmsFromDatabase() {

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/Egzaminodb", "root", "");
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM films")) {

            while (resultSet.next()) {
                String filmName = resultSet.getString("name");
                double filmRating = resultSet.getDouble("rating");
                String filmCategory = resultSet.getString("category");

                Film film = new Film(filmName, filmRating, filmCategory);
                films.add(film);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void filterFilmsByName(String name) {
        ObservableList<Film> filteredList = FXCollections.observableArrayList();
        for (Film film : films) {
            if (film.getName().toLowerCase().contains(name.toLowerCase())) {
                filteredList.add(film);
            }
        }
        table.setItems(filteredList);
    }

}