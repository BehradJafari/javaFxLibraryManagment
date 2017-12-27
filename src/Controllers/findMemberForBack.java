package Controllers;


import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import main.Main;
import modules.Member;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by behrad on 12/25/2017.
 */
public class findMemberForBack {
    @FXML
    private JFXListView listViewMember;
    @FXML
    private JFXListView listViewMemberName;
    @FXML
    private JFXTextField searachMember;
    @FXML
    private JFXTextField searachMemberName;




    public void goToSearchId(ActionEvent actionEvent) {
        if (searachMember.getText().length()==0){
            Alert alert = new Alert(Alert.AlertType.ERROR,"نام یا شناسه مد نظر خود را وارد کنید.", ButtonType.CLOSE);
            alert.show();
            return;
        }
        findingId(searachMember.getText());
    }

    private void findingName(String text) {
        ArrayList<Member> members =new ArrayList<>();

        for (int i = 0; i < Main.getMananger().getMembers().size(); i++) {
            if (Main.getMananger().getMembers().get(i).getName().contains(text) || Main.getMananger().getMembers().get(i).getLast_name().contains(text)){

                members.add(Main.getMananger().getMembers().get(i));
            }
            System.err.println(Main.getMananger().getMembers().get(i));
        }
        listViewMemberName.setItems(FXCollections.observableList(members));
    }

    public void goToSearchName(ActionEvent actionEvent) {
        if (searachMemberName.getText().length()==0){
            Alert alert = new Alert(Alert.AlertType.ERROR,"نام یا شناسه مد نظر خود را وارد کنید.", ButtonType.CLOSE);
            alert.show();
            return;
        }
        findingName(searachMemberName.getText());
    }

    private void findingId(String text) {
        ArrayList<Member> members =new ArrayList<>();
        for (int i = 0; i <Main.getMananger().getMembers().size() ; i++) {
            if (Main.getMananger().getMembers().get(i).getId().contains(text)){
                members.add(Main.getMananger().getMembers().get(i));
            }
        }
        listViewMember.setItems(FXCollections.observableList(members));
    }


    public void goToShowMember(MouseEvent mouseEvent) {
        Member member = (Member)listViewMember.getSelectionModel().getSelectedItem();
        BackBookController.member=member;
        showMember();
    }

    public void goToShowMember1(MouseEvent mouseEvent) {
        Member member = (Member)listViewMemberName.getSelectionModel().getSelectedItem();
        BackBookController.member=member;
        showMember();
    }

    private void showMember() {
        AnchorPane anchorPane = homeController.anchorPane;
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("../fxmls/backBook.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        anchorPane.getChildren().clear();
        anchorPane.getChildren().add(root);
    }
}
