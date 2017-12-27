package modules;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by behrad on 12/24/2017.
 */
public class Mananger implements Serializable {
    private String user_name;
    private String pass;
    private ArrayList<Book> notAvbBooks = new ArrayList<>();


    private ArrayList<Book> books = new ArrayList<>();
    private ArrayList<Member> members = new ArrayList<>();

    public ArrayList<Book> getBooks() {
        return books;
    }

    public ArrayList<Member> getMembers() {
        return members;
    }

    public Mananger(String user_name, String pass) {
        this.user_name = user_name;
        this.pass = pass;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void addBook(Book book){
        books.add(book);
    }
    public void addMember(Member member){
        members.add(member);
    }

    public boolean addToGetBooks(Book book){
        if (notAvbBooks.contains(book)){
            return false;
        }
        notAvbBooks.add(book);
        return true;
    }

}
