package Controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import main.Main;
import modules.Book;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by behrad on 12/26/2017.
 */
public class showBookController implements Initializable {
    @FXML
    private Text text_area;
    public static Book book;


    public void goToDeleteBook(ActionEvent actionEvent) {

        delete(book);
        AnchorPane anchorPane = homeController.anchorPane;
        DoneController.string ="کتاب حذف شد";
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("../fxmls/done.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        anchorPane.getChildren().clear();
        anchorPane.getChildren().add(root);

    }

    private void delete(Book book) {

        Main.getMananger().getBooks().remove(book);


    }

    public void goToEditBook(ActionEvent actionEvent) {
        confirmBook.book=book;
        AnchorPane anchorPane = homeController.anchorPane;

        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("../fxmls/confirmBook.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        anchorPane.getChildren().clear();
        anchorPane.getChildren().add(root);

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        text_area.setText(book.toString());
    }
}
