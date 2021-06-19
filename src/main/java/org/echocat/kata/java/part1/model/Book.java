package org.echocat.kata.java.part1.model;

import java.util.List;

public class Book {
    private String title;
    private String isbn;
    private List<String> authors;
    private String description;

    public Book(String title, String isbn, List<String> authors, String description) {
        this.title = title;
        this.isbn = isbn;
        this.authors = authors;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", isbn='" + isbn + '\'' +
                ", authors=" + authors +
                ", description='" + description + '\'' +
                '}';
    }
}
