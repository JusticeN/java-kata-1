package org.echocat.kata.java.part1.service;

import org.echocat.kata.java.part1.ParseCSVFiles;
import org.echocat.kata.java.part1.model.Author;
import org.echocat.kata.java.part1.service.parser.AuthorCSVParser;
import org.echocat.kata.java.part1.service.parser.IKataCSVParser;

import java.io.InputStream;
import java.util.List;
import java.util.Optional;

public class AuthorService {
    private final String FILENAME = "org/echocat/kata/java/part1/data/authors.csv";
    private final InputStream AUTHORS_CSV_IS = AuthorService.class.getClassLoader().getResourceAsStream(FILENAME);
    private List<Author> authorRepository;
    private IKataCSVParser parser = new AuthorCSVParser();

    public AuthorService(){
        this.authorRepository = ParseCSVFiles.parse(parser, AUTHORS_CSV_IS);
    }
    public List<Author> findAll() {
        return authorRepository;
    }
    public boolean addAuthor(Author author) {
        return authorRepository.add(author);
    }

    public Optional<Author> findByEmail(String email) {
        return authorRepository.stream()
                .filter(author -> author.getEmail().equalsIgnoreCase(email))
                .findFirst();
    }
}
