package org.echocat.kata.java.part1.service.parser;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class MagazineCSVParserTest {

    @Test
    void parseDate() {
        LocalDate localDate = MagazineCSVParser.parseDate("23.02.2012");
        Assertions.assertEquals(localDate.getDayOfMonth(), 23);
        Assertions.assertEquals(localDate.getMonthValue(), 2);
        Assertions.assertEquals(localDate.getYear(), 2012);
    }
}