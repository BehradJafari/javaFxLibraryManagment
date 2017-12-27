package Controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import javafx.util.Duration;
import main.Main;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by behrad on 12/24/2017.
 */
public class signInController implements Initializable {
    @FXML
    private JFXTextField user_text;
    @FXML
    private JFXPasswordField pass_text;
    @FXML
    private JFXButton signup_btn;

    public void forget(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION,"admin admin");
        alert.show();
    }

    public void signupAction(ActionEvent actionEvent) {

        if (initialize()){

            if (checkPassUserName()){

                Stage stage = Main.getPrimaryStage();
                Parent root=null;
                try {
                    root = FXMLLoader.load(getClass().getResource("../fxmls/home.fxml"));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                stage.setScene(new Scene(root));
                FadeTransition fadeTransition = new FadeTransition(Duration.seconds(2),root);


                fadeTransition.setFromValue(0.2f);
                fadeTransition.setToValue(1);
                fadeTransition.play();
            }




        }

    }


    public void initialize(URL location, ResourceBundle resources) {
        TranslateTransition transition = new TranslateTransition();
        transition.setDuration(Duration.millis(1600));
        transition.setNode(signup_btn);
//        transition.setToX(170);
        transition.setToX(-137);
        transition.play();
        transition.play();
    }

    private boolean initialize(){
        if (user_text.getText().length()==0 || pass_text.getText().length()==0){
            return false;
        }
        return true;
    }

    private boolean checkPassUserName(){
        if (Main.getMananger().getUser_name().equals(user_text.getText()) && Main.getMananger().getUser_name().equals(pass_text.getText())){
            return true;
        }
        return false;
    }
}
