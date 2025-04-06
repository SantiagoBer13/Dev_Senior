package com.code.exercise4;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Numbers {

    public Set<Integer> findNumbersUniques(List<Integer> listNumbers){
        Set<Integer> numbersUniques = new HashSet<>(listNumbers);
        return numbersUniques;
    }

}
