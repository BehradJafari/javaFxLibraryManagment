package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import main.Main;
import modules.Book;
import modules.Member;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by behrad on 12/26/2017.
 */
public class showMemberController  implements Initializable{
    @FXML
    private Text text_area;
    public static Member member;


    public void goToDeleteMember(ActionEvent actionEvent) {

        delete(member);
        AnchorPane anchorPane = homeController.anchorPane;
        DoneController.string ="عضو حذف شد. ";
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("../fxmls/done.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        anchorPane.getChildren().clear();
        anchorPane.getChildren().add(root);
    }

    private void delete(Member member) {
        Main.getMananger().getMembers().remove(member);
    }

    public void goToEditMember(ActionEvent actionEvent) {
        confirmMember.member=member;
        Parent root = null;
        AnchorPane anchorPane = homeController.anchorPane;
        try {
            root = FXMLLoader.load(getClass().getResource("../fxmls/confirmMember.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        anchorPane.getChildren().clear();
        anchorPane.getChildren().add(root);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        text_area.setText(member.toString());
    }
}
