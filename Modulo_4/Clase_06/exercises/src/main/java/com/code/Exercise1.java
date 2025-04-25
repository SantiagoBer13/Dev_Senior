package com.code;

import java.util.List;

public class Exercise1 {
    private List<String> words;

    public Exercise1(List<String> words) {
        this.words = words;
    }

    public List<String> filterStartWithA() {
        return this.words.stream().filter(word -> word.startsWith("A")).toList();
    }

    public List<String> converToUpperCase() {
        return this.words.stream().filter(word -> word.startsWith("A")).map(String::toUpperCase).toList();
    }

    public List<String> sortedAlphabetic() {
        return this.words.stream().filter(word -> word.startsWith("A")).map(String::toUpperCase).sorted().toList();
    }

}