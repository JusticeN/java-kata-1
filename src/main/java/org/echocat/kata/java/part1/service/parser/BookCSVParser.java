package org.echocat.kata.java.part1.service.parser;

import org.echocat.kata.java.part1.model.Book;

import java.util.List;
import java.util.stream.Collectors;

public class BookCSVParser implements IKataCSVParser<Book> {
    @Override
    public List<Book> parse(List<List<String>> parsedRawCSVData) {
        List<Book> books = parsedRawCSVData.stream()
                .skip(1) // skipp the first header line
        .map(line -> {
            if (line.size()==4) {
                return new Book(line.get(0), line.get(1), List.of(line.get(2)), line.get(3));
            }
            return parseBookWithMoreAuthors(line);
        }).collect(Collectors.toList());
        return books;
    }

    /**
     * Some entry in the Books have more than 1 authors. in such case it have to be parsed differently.
     * This method extract all emails and add it to the book as list of authors
     * @param line list of csv input from file or a single line
     * @return a new parsed Book
     */
    private Book parseBookWithMoreAuthors(List<String> line) {
        String title = line.get(0);
        String isbn  = line.get(1);
        int limit = line.size() - 2 - 1;
        List<String> authors  = line.stream().skip(2).limit(limit).collect(Collectors.toList());
        String description = line.get(line.size()-1);;
        return new Book(title, isbn, authors, description);
    }
}
