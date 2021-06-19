package org.echocat.kata.java.part1.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PrintService {

    private final AuthorService authorService;
    private final BookService bookService;
    private final MagazineService magazineService;


    public PrintService() {
        this.bookService = new BookService();
        this.magazineService = new MagazineService();
        this.authorService = new AuthorService();
    }

    public void printBooksAndMagazines() {
        magazineService.findAll().forEach(mag -> {
            System.out.println("------------ISBN: "+mag.getIsbn()+"-------------");
            System.out.println("title: "+mag.getTitle());
            mag.getAuthors().forEach(email -> authorService.findByEmail(email).ifPresent(author -> {
                System.out.println("authors.lastname "+author.getLastname());
                System.out.println("authors.firstname "+author.getFirstname());
            }));
            bookService.findByIsbn(mag.getIsbn()).ifPresent(book -> {
                System.out.println("description: "+book.getDescription());
            });
            System.out.println("--------------------------------------------------");
        });
    }
    public void printBooksAndMagazinesSortedByTitle() {
        List<BookAndTitle> allBooks = new ArrayList<>();
        bookService.findAll().stream()
                .map(book -> new BookAndTitle(book.getTitle(), book.getIsbn(), book.getAuthors())).forEach(allBooks::add);
        magazineService.findAll().stream()
                .map(mag -> new BookAndTitle(mag.getTitle(), mag.getIsbn(), mag.getAuthors())).forEach(allBooks::add);
        Collections.sort(allBooks, Comparator.comparing(bookAndTitle -> bookAndTitle.getTitle()));
        System.out.println("##########################################");
        System.out.println(">>>> all books and magazines with all their details sorted by title");
        allBooks.forEach(book-> System.out.println(book.getTitle()));
    }

    class BookAndTitle {
        private String title;
        private String isbn;
        private List<String> authors;

        public BookAndTitle(String title, String isbn, List<String> authors) {
            this.title = title;
            this.isbn = isbn;
            this.authors = authors;
        }

        public String getTitle() {
            return title;
        }

        public String getIsbn() {
            return isbn;
        }

        public List<String> getAuthors() {
            return authors;
        }
    }
}
