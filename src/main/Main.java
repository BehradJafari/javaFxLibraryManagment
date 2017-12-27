package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import modules.Mananger;

import java.io.*;
import java.util.ArrayList;

public class Main extends Application {
    public static final String bookIdStart="B666";
    public static final String memberIdStart="M7777";

    public static Stage ps;

    public static Mananger getMananger() {
        return mananger;
    }

    private static Mananger mananger;




    @Override
    public void start(Stage primaryStage) throws Exception{
        ps = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("../fxmls/signIn.fxml"));
        primaryStage.setTitle("برنامه مدیریت کتابخانه");
        primaryStage.getIcons().add(new Image(Main.class.getResourceAsStream("../files/2cf7c5ba-bbc3-4a1a-b097-168476d0217f-Glamouros-logo-design-01-1.png")));

        primaryStage.setScene(new Scene(root, 389, 586));
        primaryStage.initStyle(StageStyle.DECORATED);
        primaryStage.show();

    }


    public static Stage getPrimaryStage() {
        return ps;
    }

    public static void main(String[] args) {
        if (mananger==null){

            mananger = new Mananger("admin","admin");

        }
        System.err.println(mananger.getPass() + mananger.getUser_name());
        launch(args);
    }


}
