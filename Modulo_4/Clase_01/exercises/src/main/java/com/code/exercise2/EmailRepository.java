package com.code.exercise2;

import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class EmailRepository {

    private List<String> emails = new ArrayList<>();
    
    public EmailRepository(List<String> emails) {
        if (emails != null) {
            this.emails = new ArrayList<>(emails);
        }
    }

    public List<String> removeEmailsRepeated() {
        Set<String> uniqueEmails = new HashSet<>(emails);
        
        emails = new ArrayList<>(uniqueEmails);
        
        return emails;
    }
}