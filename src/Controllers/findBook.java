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
import main.Main;
import modules.Book;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * Created by behrad on 12/25/2017.
 */
public class findBook {
    @FXML
    private JFXTextField findBook_fld;
    @FXML
    private JFXListView listViewBook;




    public void goToSearchBook(ActionEvent actionEvent) {
        if (findBook_fld.getText().length()==0){
            Alert alert = new Alert(Alert.AlertType.ERROR,"نام یا شناسه مد نظر خود را وارد کنید.", ButtonType.CLOSE);
            alert.show();
            return;
        }
        finding(findBook_fld.getText());
    }

    private void finding(String text) {
        ArrayList<Book>books = new ArrayList<>();
        for (Book book:Main.getMananger().getBooks()          ) {
            if (book.getName().contains(text)){
                books.add(book);
            }
        }
        if (books.size()==0)
        {
            new Alert(Alert.AlertType.ERROR,"چنین کتابی موجود نیست ",ButtonType.OK).show();
        }
        listViewBook.setItems(FXCollections.observableArrayList(books));
    }

    public void goToSetBook(MouseEvent mouseEvent) {
        Book book =(Book)listViewBook.getSelectionModel().getSelectedItem();
        showBookController.book=book;
        AnchorPane anchorPane = homeController.anchorPane;

        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("../fxmls/showBook.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        anchorPane.getChildren().clear();
        anchorPane.getChildren().add(root);

    }
}
