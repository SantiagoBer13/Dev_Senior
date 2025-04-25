package com.code;

public class Libro implements Comparable<Libro> {
    
    private String title;
    private String author;
    private Integer pages;
    
    public Libro(String title, String author, Integer pages) {
        this.title = title;
        this.author = author;
        this.pages = pages;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public Integer getPages() {
        return pages;
    }

    @Override
    public int compareTo(Libro o) {
        return this.author.compareTo(o.getAuthor());
    }

}
