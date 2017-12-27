package Controllers;

import com.jfoenix.controls.JFXRadioButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import main.Main;
import modules.Member;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by behrad on 12/26/2017.
 */
public class BackBookController implements Initializable{
    @FXML
    private JFXRadioButton book1_rdi;
    @FXML
    private JFXRadioButton book2_rdi;
    @FXML
    private JFXRadioButton book3_rdi;
    @FXML
    private Text member_txt;

    public static Member member;





    public void goToConfirmBackBook(ActionEvent actionEvent) {
        int index=0;
        for (int i = 0; i < Main.getMananger().getMembers().size(); i++) {
            if (member.equals(Main.getMananger().getMembers().get(i))){
                index=i;
                break;
            }
        }
        if (Main.getMananger().getMembers().size()>0 && book1_rdi.isSelected()){
            Main.getMananger().getMembers().get(index).getBooks().remove(0);
        }
        if (Main.getMananger().getMembers().size()>1 && book2_rdi.isSelected()){
            Main.getMananger().getMembers().get(index).getBooks().remove(1);
        }
        if (Main.getMananger().getMembers().size()>2 && book3_rdi.isSelected()){
            Main.getMananger().getMembers().get(index).getBooks().remove(2);
        }
        showDone();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        member_txt.setText(member.toString());
        if (member.getBooks().size()>0)
        book1_rdi.setText(member.getBooks().get(0).getName()+" "+member.getBooks().get(0).getId());
        else
            book1_rdi.setVisible(false);
        if (member.getBooks().size()>1)
        book2_rdi.setText(member.getBooks().get(1).getName()+" "+member.getBooks().get(1).getId());
        else
            book2_rdi.setVisible(false);
        if (member.getBooks().size()>2)
        book3_rdi.setText(member.getBooks().get(2).getName()+" "+member.getBooks().get(2).getId());
        else
            book3_rdi.setVisible(false);
    }
    public void showDone(){
        AnchorPane anchorPane = homeController.anchorPane;

        Parent root = null;

        try {
            root = FXMLLoader.load(getClass().getResource("../fxmls/done.fxml"));
        } catch (IOException e) {
            e.getMessage();
        }
        anchorPane.getChildren().clear();
        anchorPane.getChildren().add(root);
        member=null;
        member_txt.setText("");
    }
}
