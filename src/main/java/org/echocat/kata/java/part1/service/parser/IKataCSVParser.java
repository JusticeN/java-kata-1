package org.echocat.kata.java.part1.service.parser;

import java.util.List;

@FunctionalInterface
public interface IKataCSVParser<T> {

    List<T> parse(List<List<String>> parsedCSVData);
}
