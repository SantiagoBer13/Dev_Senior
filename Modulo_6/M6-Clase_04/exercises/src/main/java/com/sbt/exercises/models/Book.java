package com.sbt.exercises.models;

public class Book {
    private String title;
    private String author;
    private String description;
    private boolean isRead;
    private String id;
    private static int idCounter = 1;

    public Book(String title, String author, String description, boolean isRead) {
        this.id = "book-" + String.valueOf(idCounter++);
        this.title = title;
        this.author = author;
        this.description = description;
        this.isRead = isRead;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getDescription() {   
        return description;
    }

    public boolean isRead() {
        return isRead;
    }

    public void setRead(boolean isRead) {      
        this.isRead = isRead;
    }   

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", description='" + description + '\'' +
                ", isRead=" + isRead +
                '}';
    }
}
