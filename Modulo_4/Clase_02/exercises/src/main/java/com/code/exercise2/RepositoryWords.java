package com.code.exercise2;

import java.util.HashMap;
import java.util.Map;

public class RepositoryWords {

    public Map<String, Integer> countFrecuecyOfWords(String text){
        Map<String, Integer> frecuencys = new HashMap<>();
        if(text.length() > 0){
            String[] arrayWorsd = text.split(" ");
            System.out.println("Array: " + arrayWorsd);
            for (String word : arrayWorsd) {
                word = word.toLowerCase();
                if(frecuencys.containsKey(word)){
                    int frecuency = frecuencys.get(word);
                    frecuencys.put(word, frecuency + 1);
                } else {
                    frecuencys.put(word, 1);
                }
            }
        }
        return frecuencys;
     }

}
