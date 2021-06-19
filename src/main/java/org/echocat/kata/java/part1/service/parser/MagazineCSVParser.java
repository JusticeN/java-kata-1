package org.echocat.kata.java.part1.service.parser;

import org.echocat.kata.java.part1.model.Book;
import org.echocat.kata.java.part1.model.Magazine;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

public class MagazineCSVParser implements IKataCSVParser<Magazine> {
    private static final String DATE_PATTERN = "dd.MM.yyyy";
    @Override
    public List<Magazine> parse(List<List<String>> parsedRawCSVData) {
        List<Magazine> magazines = parsedRawCSVData.stream()
                .skip(1) // skipp the first header line
        .map(line -> {
            if (line.size()==4) {
                return new Magazine(line.get(0), line.get(1), List.of(line.get(2)), parseDate(line.get(3)));
            }
            return parseMagazineWithMoreAuthors(line);
        }).collect(Collectors.toList());
        return magazines;
    }

    /**
     * Some entry in the Books have more than 1 authors. in such case it have to be parsed differently.
     * This method extract all emails and add it to the book as list of authors
     * @param line list of csv input from file or a single line
     * @return a new parsed Book
     */
    private Magazine parseMagazineWithMoreAuthors(List<String> line) {
        String title = line.get(0);
        String isbn  = line.get(1);
        int limit = line.size() - 2 - 1;
        List<String> authors  = line.stream().skip(2).limit(limit).collect(Collectors.toList());
        LocalDate publishedAt = parseDate(line.get(line.size()-1));
        return new Magazine(title, isbn, authors, publishedAt);
    }

    public static LocalDate parseDate(String dateString) {
        return LocalDate.parse(dateString, DateTimeFormatter.ofPattern(DATE_PATTERN));
    }
}
