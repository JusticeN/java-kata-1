package org.echocat.kata.java.part1.service;

import org.echocat.kata.java.part1.ParseCSVFiles;
import org.echocat.kata.java.part1.model.Book;
import org.echocat.kata.java.part1.model.Magazine;
import org.echocat.kata.java.part1.service.parser.BookCSVParser;
import org.echocat.kata.java.part1.service.parser.IKataCSVParser;
import org.echocat.kata.java.part1.service.parser.MagazineCSVParser;

import java.io.InputStream;
import java.util.List;
import java.util.Optional;

public class MagazineService {
    private final String FILENAME = "org/echocat/kata/java/part1/data/magazines.csv";
    private final InputStream MAGAZINES_CSV_IS = MagazineService.class.getClassLoader().getResourceAsStream(FILENAME);
    private List<Magazine> magazineRepository;
    private IKataCSVParser parser = new MagazineCSVParser();

    public MagazineService(){
        this.magazineRepository = ParseCSVFiles.parse(parser, MAGAZINES_CSV_IS);
    }
    public List<Magazine> findAll() {
        return magazineRepository;
    }
    public boolean addMagazine(Magazine magazine) {
        return magazineRepository.add(magazine);
    }

    public Optional<Magazine> findByAuthorEmail(String email) {
        return magazineRepository.stream()
                .filter(book -> book.getAuthors().contains(email))
                .findFirst();
    }
    public Optional<Magazine> findByIsbn(String isbn) {
        return magazineRepository.stream()
                .filter(book -> book.getIsbn().equalsIgnoreCase(isbn))
                .findFirst();
    }
}
