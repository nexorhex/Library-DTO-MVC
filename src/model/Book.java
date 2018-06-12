package model;

public class Book {

    private int id;
    private String title;
    private String author;
    private String year;
    private String ISBN;
    private String info;

    public Book() {}

    public Book(String title, String author, String year, String ISBN) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.year = year;
        this.ISBN = ISBN;
    }

    public Book(String info) {
        this.info = info;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", year='" + year + '\'' +
                ", ISBN='" + ISBN + '\'' +
                '}';
    }

}
