package prog.javadekom;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class Main extends Application {
    Stage stage;
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("main-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1200, 800);
        Image icon = new Image(Objects.requireNonNull(getClass().getResource("/prog/javadekom/JAVA2bettericon.png")).toExternalForm());
        stage.getIcons().add(icon);
        String css = Objects.requireNonNull(this.getClass().getResource("/prog/javadekom/view.css")).toExternalForm();
        scene.getStylesheets().add(css);
        stage.setTitle("JAVAdekom");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();


    }

    public static void main(String[] args) {
        launch();
    }

    public Stage getStage() {
        return stage;
    }
}
