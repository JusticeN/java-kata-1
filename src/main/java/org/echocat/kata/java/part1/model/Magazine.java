package org.echocat.kata.java.part1.model;

import java.time.LocalDate;
import java.util.List;

public class Magazine {
    private String title;
    private String isbn;
    private List<String> authors;
    private LocalDate publishedAt;

    public Magazine(String title, String isbn, List<String> authors, LocalDate publishedAt) {
        this.title = title;
        this.isbn = isbn;
        this.authors = authors;
        this.publishedAt = publishedAt;
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

    public LocalDate getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(LocalDate publishedAt) {
        this.publishedAt = publishedAt;
    }

    @Override
    public String toString() {
        return "Magazine{" +
                "title='" + title + '\'' +
                ", isbn='" + isbn + '\'' +
                ", authors=" + authors +
                ", LocalDate='" + publishedAt + '\'' +
                '}';
    }
}
