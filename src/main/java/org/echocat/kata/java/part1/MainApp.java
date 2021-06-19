package org.echocat.kata.java.part1;

import org.echocat.kata.java.part1.service.PrintService;

public class MainApp {

    public static void main(String[] args) {
        PrintService printService = new PrintService();
        printService.printBooksAndMagazines();

        printService.printBooksAndMagazinesSortedByTitle();
    }

}
