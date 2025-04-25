package com.code;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Exercise5 {

    private List<String> lines;

    public Exercise5() {
        try (Stream<String> lineas = Files.lines(Paths.get("logs.txt"))) {
            lines = lineas.collect(Collectors.toList());
        } catch (IOException e) {
            System.err.println("Error al leer el archivo logs.txt: " + e.getMessage());
            lines = Collections.emptyList(); 
        }
    }

    public List<String> filterLinesWithError() {
        return this.lines.stream()
                .filter(linea -> linea.contains("ERROR"))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        Exercise5 exercise5 = new Exercise5();
        System.out.println(exercise5.filterLinesWithError());
    }

}
