package HW_4_1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainClass extends Application {
    public static Stage mainStage;
    //
    public static Parametres param = new Parametres();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.mainStage = primaryStage;
        primaryStage.setTitle("Java Chat");
        //
        primaryStage.toFront();
        primaryStage.centerOnScreen();
        //
        Parent root = FXMLLoader.load(getClass().getResource("form.fxml"));
        Scene scene = new Scene(root, 800, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
