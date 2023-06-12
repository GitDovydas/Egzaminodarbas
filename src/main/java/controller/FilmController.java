package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import model.Film;

public class FilmController {
    @FXML
    private Label filmTitleLabel;
    @FXML
    private Label filmDescriptionLabel;

    public void setFilm(Film film) {
        filmTitleLabel.setText(film.getName());
        filmDescriptionLabel.setText(film.getDescription());
    }
}