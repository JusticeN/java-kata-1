package org.echocat.kata.java.part1;

import org.echocat.kata.java.part1.service.parser.IKataCSVParser;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ParseCSVFiles {

    private static final String COMMA_DELIMITER = ";";

    private static List<List<String>> readCSV(InputStream is) {
        List<List<String>> records = new ArrayList<>();
        try (InputStreamReader streamReader =
                     new InputStreamReader(is, StandardCharsets.UTF_8);
             BufferedReader br = new BufferedReader(streamReader)) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(COMMA_DELIMITER);
                records.add(Arrays.asList(values));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return records;
    }

    public static <T> List<T> parse(IKataCSVParser<T> parser, InputStream is) {
        Objects.requireNonNull(is, "Input stream should not be null");
        Objects.requireNonNull(parser, "parser should not be null");
        var parsedCSVData = readCSV(is);
        return parser.parse(parsedCSVData);
    }
}
