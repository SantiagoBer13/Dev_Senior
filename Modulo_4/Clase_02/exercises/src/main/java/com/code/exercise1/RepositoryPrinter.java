package com.code.exercise1;

import java.util.LinkedList;
import java.util.Queue;

public class RepositoryPrinter {

    private static RepositoryPrinter repositoryPrinter;
    private static int numberSheets = 30;
    private static Queue<Document> queueDocuments = new LinkedList<>();
    
    private RepositoryPrinter(){};
    
    public static RepositoryPrinter getInstance(){
        if(repositoryPrinter == null){
            repositoryPrinter = new RepositoryPrinter();
        }
        return repositoryPrinter;
    }

    public void addDocument(Document doc){
        if(doc == null){
            throw new IllegalArgumentException("Document cannot be null");
        }
        queueDocuments.offer(doc);
    }
    
    public String printDocument(){
        Document document = queueDocuments.poll();
        if(document == null) {
            return "No documents in queue";
        }
        if(document.getNumberSheets() > numberSheets){
            throw new IllegalStateException("Not enough sheets available for printing");
        }
        numberSheets -= document.getNumberSheets();
        return "Imprimiendo el documento: " + document.getContent();
    }

    public void loadSheets(int sheets){
        if(sheets < 1){
            throw new IllegalArgumentException("Number of sheets must be positive");
        }
        RepositoryPrinter.numberSheets += sheets;
    }

    public void showDocuments(){
        int counter = 1;
        for (Document document : queueDocuments) {
            System.out.println(counter + ") " + document.getContent());
            counter++;
        }
    }

    public int getAvailableSheets() {
        return numberSheets;
    }
    
    public int getQueueSize() {
        return queueDocuments.size();
    }

}
