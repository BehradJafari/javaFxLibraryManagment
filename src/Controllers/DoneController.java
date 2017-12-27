package Controllers;

import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;
import javafx.util.Duration;

import javax.swing.text.html.ImageView;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by behrad on 7/4/2017.
 */
public class DoneController implements Initializable {
    @FXML
    private javafx.scene.image.ImageView image;
    @FXML
    private Text confirm_txt;

    public static String string = "";

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        confirm_txt.setVisible(false);
        TranslateTransition transition = new TranslateTransition();
        transition.setDuration(Duration.millis(1700));
        transition.setNode(image);
        transition.setToY(-350);
        RotateTransition rotateTransition = new RotateTransition(Duration.millis(1700),image);
        rotateTransition.setFromAngle(0);
        rotateTransition.setToAngle(360);


        transition.play();
        rotateTransition.play();
        rotateTransition.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                confirm_txt.setText(string);
                confirm_txt.setVisible(true);


            }
        });

    }
}
