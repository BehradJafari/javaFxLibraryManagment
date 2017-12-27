package Controllers;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import main.Main;

/**
 * Created by behrad on 12/24/2017.
 */
public class homeController {
    @FXML
    private AnchorPane secondAnchor;
    public static AnchorPane anchorPane;

    public void goToSearchUser(ActionEvent actionEvent) {
        setSecondAnchor("../fxmls/findMember.fxml");

    }

    public void goToSearchBook(ActionEvent actionEvent) {
        setSecondAnchor("../fxmls/findBook.fxml");



    }

    public void goToNewUser(ActionEvent actionEvent) {
        setSecondAnchor("../fxmls/confirmMember.fxml");

    }

    public void gotToGetBook(ActionEvent actionEvent) {
        setSecondAnchor("../fxmls/findMemberForBook.fxml");

    }

    public void goToReturnBook(ActionEvent actionEvent) {
        setSecondAnchor("../fxmls/findMemberForBack.fxml");

    }

    public void goToNewBook(ActionEvent actionEvent) {
        setSecondAnchor("../fxmls/confirmBook.fxml");

    }

    


    public void setSecondAnchor(String url){
        Parent   root=null;
        try {
            root = FXMLLoader.load(getClass().getResource(url));
        } catch (Exception e) {
            e.printStackTrace();
        }
        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1),root);
        secondAnchor.getChildren().clear();
        secondAnchor.getChildren().add(root);

        fadeTransition.setFromValue(0);
        fadeTransition.setToValue(1);
        fadeTransition.play();
        anchorPane=secondAnchor;
    }
}
