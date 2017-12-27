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
import modules.Book;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by behrad on 12/25/2017.
 */
public class confirmBook implements Initializable{
    @FXML
    private JFXTextField bookName_fld;
    @FXML
    private JFXTextField pubName_fld;
    @FXML
    private JFXTextField authorName_fld;
    @FXML
    private JFXButton editBook_btn;
    @FXML
    private JFXButton confirmBook_btn;


    public static Book book=null;



    public void goToConfirm(ActionEvent actionEvent) {
        if (initialize()){
            String id = Main.bookIdStart+(Main.getMananger().getBooks().size()+1);

            Main.getMananger().addBook(new Book(bookName_fld.getText(),id,pubName_fld.getText(),authorName_fld.getText()));

            DoneController.string = id+" :  شناسه کتاب ثبت شده ";
            showDone();


        }
        else {
            Alert alert = new Alert(Alert.AlertType.ERROR,"لطفا فیلد های خود را چک کنید .", ButtonType.OK);
            alert.show();
        }
    }

    private boolean initialize() {
        if ( bookName_fld.getText().length()==0 || authorName_fld.getText().length()==0
                || pubName_fld.getText().length()==0){

            return false;

        }
        return true;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if (this.book!=null){
            confirmBook_btn.setVisible(false);
            editBook_btn.setVisible(true);
            set(book);
        }
        else {
            confirmBook_btn.setVisible(true);
            editBook_btn.setVisible(false);
        }
    }

    private void set(Book book) {
        pubName_fld.setText(book.getPublisher());
        authorName_fld.setText(book.getAuthor());
        bookName_fld.setText(book.getName());

    }

    public void goToEdit(ActionEvent actionEvent) {
        if (initialize()){
            for (int i = 0; i <Main.getMananger().getBooks().size() ; i++) {
                if (Main.getMananger().getBooks().get(i).equals(book)){
                    System.err.println(Main.getMananger().getBooks().get(i));
                    Main.getMananger().getBooks().get(i).setAuthor(authorName_fld.getText());
                    Main.getMananger().getBooks().get(i).setName(bookName_fld.getText());
                    Main.getMananger().getBooks().get(i).setPublisher(pubName_fld.getText());
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
            e.printStackTrace();
        }
        anchorPane.getChildren().clear();
        anchorPane.getChildren().add(root);
        book=null;
    }
}
