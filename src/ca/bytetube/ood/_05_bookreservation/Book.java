package ca.bytetube.ood._05_bookreservation;

public class Book extends Resource {
    private String author;
    private String ISBN;

    public Book(String id, String name, int quantity, String author, String ISBN) {
        super(id, name, quantity);
        this.author = author;
        this.ISBN = ISBN;

    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }
}
