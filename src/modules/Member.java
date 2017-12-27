package modules;

import java.util.ArrayList;

/**
 * Created by behrad on 12/25/2017.
 */
public class Member {
    private String name;
    private String last_name;
    private String nationalId;
    private String id;
    private ArrayList<Book> books = new ArrayList<>();

    public Member(String name, String last_name, String nationalId,String id) {
        this.name = name;
        this.last_name = last_name;
        this.nationalId = nationalId;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getNationalId() {
        return nationalId;
    }

    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }

    public String getId() {
        return id;
    }

    public boolean addBook(Book book){
        if (this.books.size()==3){
            return false;
        }
        if (this.books.contains(book)){
            return false;
        }
        this.books.add(book);
        return true;
    }

    @Override
    public String toString() {
        return
                "name='" + name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", nationalId='" + nationalId + '\'' +
                ", id='" + id + '\'' +
                ", books=" + books ;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Member)) return false;

        Member member = (Member) o;

        return getId().equals(member.getId());
    }

    public ArrayList<Book> getBooks() {
        return books;
    }
}
