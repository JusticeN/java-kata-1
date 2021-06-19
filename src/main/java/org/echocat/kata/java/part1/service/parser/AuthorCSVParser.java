package org.echocat.kata.java.part1.service.parser;

import org.echocat.kata.java.part1.model.Author;

import java.util.List;
import java.util.stream.Collectors;

public class AuthorCSVParser implements IKataCSVParser<Author> {
    @Override
    public List<Author> parse(List<List<String>> parsedRawCSVData) {
        List<Author> authors = parsedRawCSVData.stream()
                .skip(1) // skipp the first header line
                .takeWhile(list -> list.size()==3) // each line should have 3 elements
                .map(line -> new Author(line.get(0), line.get(1), line.get(2))).collect(Collectors.toList());
        return authors;
    }
}
