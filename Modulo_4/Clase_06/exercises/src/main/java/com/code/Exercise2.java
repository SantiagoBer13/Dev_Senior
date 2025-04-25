package com.code;

import java.util.List;

public class Exercise2 {
    private List<Integer> numbers;

    public Exercise2(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> findEvenNumbers(){
        return this.numbers.stream().filter(number -> number % 2 == 0).toList();
    }

    public Integer sumEvenNumbers(){
        return this.numbers.stream().filter(number -> number % 2 == 0).mapToInt(Integer::valueOf).sum();
    }
    
}
