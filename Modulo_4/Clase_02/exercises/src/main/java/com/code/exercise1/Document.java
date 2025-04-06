package com.code.exercise1;

public class Document {

    private static int idGeneral = 0;
    private String idInstance;
    private int numberSheets;
    private String content;

    public Document(String content, int numberSheets){
        Document.idGeneral++;
        this.numberSheets = numberSheets;
        this.idInstance = "DOC" + Document.idGeneral;
        this.content = content;
    }

    public String getIdInstance() {
        return idInstance;
    }

    public int getNumberSheets() {
        return numberSheets;
    }

    public String getContent(){
        return content;
    }

}
