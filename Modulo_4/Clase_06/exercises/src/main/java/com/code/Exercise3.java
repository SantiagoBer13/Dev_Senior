package com.code;

import java.util.List;
import java.util.stream.Stream;

public class Exercise3 {
    
    private String text;

    public Exercise3(String text) {
        this.text = text;
    }

    public List<String> findWordsUniques(){
        return Stream.of(this.text.replace(".", "").split(" ")).distinct().toList();
    }

    public Long countWordsUniques(){
        return Stream.of(this.text.replace(".", "").split(" ")).distinct().count();
    }

}
