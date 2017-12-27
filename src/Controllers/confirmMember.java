package Controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import main.Main;

import modules.Member;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by behrad on 12/25/2017.
 */
public class confirmMember implements Initializable{
    @FXML
    private JFXTextField name_fld;
    @FXML
    private JFXTextField lastName_fld;
    @FXML
    private JFXTextField natId_fld;
    @FXML
    private JFXButton editMember_btn;
    @FXML
    private JFXButton confirmMember_btn;


    public static Member member;


    public void goToConfirm(ActionEvent actionEvent) {

        if (initialize()){
            String id = Main.memberIdStart+(Main.getMananger().getMembers().size()+1);

            Main.getMananger().addMember(new Member(name_fld.getText(),lastName_fld.getText(),natId_fld.getText(),id));
            DoneController.string = id+" :  شناسه عضو ثبت شده ";
            showDone();

        }
        else {
            Alert alert = new Alert(Alert.AlertType.ERROR,"لطفا فیلد های خود را چک کنید .", ButtonType.OK);
            alert.show();
        }
    }

    private boolean initialize() {
        if (name_fld.getText().length()==0 || lastName_fld.getText().length()==0 || natId_fld.getText().length()==0 ||
                !(natId_fld.getText().matches("[0-9]+") && natId_fld.getText().length() > 8)
                ){
            return false;
        }
        return true;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if (member!=null){
            confirmMember_btn.setVisible(false);
            editMember_btn.setVisible(true);
            set(member);
        }
        else {
            confirmMember_btn.setVisible(true);
            editMember_btn.setVisible(false);
        }
    }

    private void set(Member member) {
        natId_fld.setText(member.getNationalId());
        name_fld.setText(member.getName());
        lastName_fld.setText(member.getLast_name());
    }

    public void goToEdit(ActionEvent actionEvent) {
        if (initialize()){
            for (int i = 0; i <Main.getMananger().getMembers().size() ; i++) {
                if (Main.getMananger().getMembers().get(i).equals(member)){
                   Main.getMananger().getMembers().get(i).setLast_name(lastName_fld.getText());
                    Main.getMananger().getMembers().get(i).setName(name_fld.getText());
                    Main.getMananger().getMembers().get(i).setNationalId(natId_fld.getText());
                    DoneController.string = "اطلاعات جدید ثبت شد .";
                    showDone();
                    return;
                }
            }
        }
        else {
            Alert alert = new Alert(Alert.AlertType.ERROR,"لطفا فیلد های خود را چک کنید .", ButtonType.OK);
            alert.show();
        }
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
    }
}
