package com.example.Book.Dto;

public class BookDto {
    private int id;
    private String title;
    private String genre;
    private String author;


    public BookDto() {
    }

    public BookDto(int id, String title, String genre, String author) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.author = author;

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

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

}