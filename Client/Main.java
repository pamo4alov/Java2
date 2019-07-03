/**
 * 1. Написать консольный вариант клиент\серверного приложения,
 * в котором пользователь может писать сообщения, как на клиентской стороне, так и на серверной.
 * Т.е. если на клиентской стороне написать "Привет",
 * нажать Enter то сообщение должно передаться на сервер и там отпечататься в консоли.
 * Если сделать то же самое на серверной стороне,
 * сообщение соответственно передается клиенту и печатается у него в консоли.
 * Есть одна особенность, которую нужно учитывать: клиент или сервер может написать несколько сообщений подряд,
 * такую ситуацию необходимо корректно обработать
 *
 * Разобраться с кодом с занятия, он является фундаментом проекта-чата
 * ВАЖНО! Сервер общается только с одним клиентом, т.е. не нужно запускать цикл,
 * который будет ожидать второго/третьего/n-го клиентов
 */

package HW_6.Client;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Java Chat");
        Scene scene = new Scene(root, 320, 375);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
