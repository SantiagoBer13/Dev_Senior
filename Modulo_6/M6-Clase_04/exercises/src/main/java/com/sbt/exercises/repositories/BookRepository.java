package com.sbt.exercises.repositories;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import org.springframework.stereotype.Repository;

import com.sbt.exercises.models.Book;

@Repository
public class BookRepository {

    private final List<Book> books = new ArrayList<>(Arrays.asList(
        new Book("The Great Gatsby", "F. Scott Fitzgerald", "A story of love and ambition", false),
        new Book("1984", "George Orwell", "A dystopian future", false),
        new Book("To Kill a Mockingbird", "Harper Lee", "A story of racism and injustice", false)
    ));
    
    public List<Book> getBooks(){
        return Collections.unmodifiableList(books);
    }

    public Book getBookById(String id){
        return findBookById(id);
    }

    public Book createBook(Book book){
        books.add(book);
        return book;
    }

    public Book updateBook(String id, Book book) {
        int index = findIndexById(id);
        if (index != -1) {
            books.set(index, book);
            return book;
        }
        return null;
    }

    public Integer deleteBook(String id){
        int index = findIndexById(id);
        if (index != -1){
            books.remove(index);
            return index;
        }
        return null;
    }

    public Book markAsRead(String id){
        Book book = findBookById(id);
        if (book == null) {
            return null;
        }
        book.setRead(true);
        return book;
    }

    public List<Book> getBookRead(){
        return books.stream().filter(b -> b.isRead()).toList();
    }

    private int findIndexById(String id) {
        return IntStream.range(0, books.size())
                        .filter(i -> books.get(i).getId().equalsIgnoreCase(id))
                        .findFirst()
                        .orElse(-1);
    }

    private Book findBookById(String id) {
        return books.stream()
                    .filter(b -> b.getId().equalsIgnoreCase(id))
                    .findFirst()
                    .orElse(null);
    }
}
