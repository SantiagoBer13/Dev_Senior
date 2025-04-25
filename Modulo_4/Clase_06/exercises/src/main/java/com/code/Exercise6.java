package com.code;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Exercise6 {
    
    private final IntStream numbers;

    public Exercise6() {
        numbers = IntStream.range(1, 1000);
    }

    public List<Integer> findNumbersPrimos() {
        return numbers.parallel()
                .filter(this::esPrimo)
                .boxed() 
                .collect(Collectors.toList());
    }

    private boolean esPrimo(int number) {
        if (number < 2) return false;
        for (int i = 2; i < number; i++) { 
            if (number % i == 0) return false;
        }
        return true; 
    }
}
