package com.code;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Exercise1 {

    private List<String> uids;

    public Exercise1(List<String> uids) {
        this.uids = uids;
    }

    public List<String> generateUids(){
        return this.uids.stream()
               .map(uid -> verifyRules(uid) ? uid + " - Válido" : uid + " - Inválido")
               .toList();
    }

    public boolean verifyRules(String uid) {
        // Regla 1: Longitud exacta de 10 caracteres
        if (uid.length() != 10)
            return false;

        // Regla 2: Solo caracteres alfanuméricos
        if (!uid.matches("[A-Za-z0-9]+"))
            return false;

        // Regla 3: Al menos 2 letras mayúsculas
        int upperCount = 0;
        for (char c : uid.toCharArray()) {
            if (Character.isUpperCase(c))
                upperCount++;
        }
        if (upperCount < 2)
            return false;

        // Regla 4: Al menos 3 dígitos
        int digitCount = 0;
        for (char c : uid.toCharArray()) {
            if (Character.isDigit(c))
                digitCount++;
        }
        if (digitCount < 3)
            return false;

        // Regla 5: No debe haber caracteres repetidos
        Set<Character> uniqueChars = new HashSet<>();
        for (char c : uid.toCharArray()) {
            if (!uniqueChars.add(c))
                return false;
        }

        return true;
    }

}