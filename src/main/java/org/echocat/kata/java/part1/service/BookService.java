package org.echocat.kata.java.part1.service;

import org.echocat.kata.java.part1.ParseCSVFiles;
import org.echocat.kata.java.part1.model.Author;
import org.echocat.kata.java.part1.model.Book;
import org.echocat.kata.java.part1.service.parser.AuthorCSVParser;
import org.echocat.kata.java.part1.service.parser.BookCSVParser;
import org.echocat.kata.java.part1.service.parser.IKataCSVParser;

import java.io.InputStream;
import java.util.List;
import java.util.Optional;

public class BookService {
    private final String FILENAME = "org/echocat/kata/java/part1/data/books.csv";
    private final InputStream BOOKS_CSV_IS = BookService.class.getClassLoader().getResourceAsStream(FILENAME);
    private List<Book> bookRepository;
    private IKataCSVParser parser = new BookCSVParser();

    public BookService(){
        this.bookRepository = ParseCSVFiles.parse(parser, BOOKS_CSV_IS);
    }
    public List<Book> findAll() {
        return bookRepository;
    }
    public boolean addBook(Book book) {
        return bookRepository.add(book);
    }

    public Optional<Book> findByAuthorEmail(String email) {
        return bookRepository.stream()
                .filter(book -> book.getAuthors().contains(email))
                .findFirst();
    }
    public Optional<Book> findByIsbn(String isbn) {
        return bookRepository.stream()
                .filter(book -> book.getIsbn().equalsIgnoreCase(isbn))
                .findFirst();
    }
}
