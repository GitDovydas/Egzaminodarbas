
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.FilmDAO;
import model.UserDAO;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        UserDAO.createUserTableIfNotExists();
        FilmDAO.createFilmTableIfNotExists();

        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("view/login.fxml"));
        primaryStage.setTitle("Login");
        primaryStage.setScene(new Scene(root, 550, 450));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}