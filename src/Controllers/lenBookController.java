package Controllers;

import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import main.Main;
import modules.Book;
import modules.Member;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * Created by behrad on 12/26/2017.
 */
public class lenBookController implements Initializable {
    @FXML
    private JFXTextField findBook_fld;
    @FXML
    private JFXListView listViewBook;
    @FXML
    private Text member_txt;
    @FXML
    private Text book_txt;

    public static Book bookLent;
    public static Member memberLent;



    public void goToSetBook(MouseEvent mouseEvent) {
         bookLent =(Book)listViewBook.getSelectionModel().getSelectedItem();
         book_txt.setText(bookLent.toString());
         book_txt.setVisible(true);
    }

    public void goToSearchBook(ActionEvent actionEvent) {
        if (findBook_fld.getText().length()==0){
            Alert alert = new Alert(Alert.AlertType.ERROR,"نام یا شناسه مد نظر خود را وارد کنید.", ButtonType.CLOSE);
            alert.show();
            return;
        }
        finding(findBook_fld.getText());
    }

    public void goToLent(ActionEvent actionEvent) {
        if (memberLent!=null && bookLent!=null) {
            if (Main.getMananger().addToGetBooks(bookLent)) {
                if (memberLent.addBook(bookLent)) {
                    AnchorPane anchorPane = homeController.anchorPane;
                    DoneController.string = "confirmed";
                    Parent root = null;
                    try {
                        root = FXMLLoader.load(getClass().getResource("../fxmls/done.fxml"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    anchorPane.getChildren().clear();
                    anchorPane.getChildren().add(root);
                } else {
                    new Alert(Alert.AlertType.ERROR, "تعداد کتاب های امانت گرفته شده تکمیل است.", ButtonType.OK).show();
                }
            }
            else {
                new Alert(Alert.AlertType.ERROR,"کتاب موجود نیست .",ButtonType.OK).show();

            }

        }
        else {
            new Alert(Alert.AlertType.ERROR,"کتاب مورد نظر خود را انتخاب کنید .",ButtonType.OK).show();
        }
    }



    private void finding(String text) {
        ArrayList<Book> books = new ArrayList<>();
        for (Book book: Main.getMananger().getBooks()          ) {
            if (book.getName().contains(text)){
                books.add(book);
            }
        }
        listViewBook.setItems(FXCollections.observableArrayList(books));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        book_txt.setVisible(false);
        member_txt.setText(memberLent.toString());
    }
}
