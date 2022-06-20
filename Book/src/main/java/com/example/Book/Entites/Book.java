package com.example.Book.Entites;
import javax.persistence.*;



@Entity  //Entity representing data that can be persisted to the database.
        //An Entity represents a table stored in a database.
@Table(name = "My_Books") //we can specify the table name in database using the @Table annotation
public class Book {
    @Id // Id annotation defines the primary key.
    private Long id;
    @Column( //The @Column annotation has many elements such as  length, updatable, and unique
            unique = true,
            length=30,
            updatable = false
    )
    private String title;
    private String genre;

    @Column(
            name = "AUTHOR_NAME",
            length= 20
    )
    private String author;

    public Books() {
    }

    public Books(Long id, String title, String genre, String author) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.author = author;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String gener) {
        this.genre = gener;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
