package com.sbt.exercises.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sbt.exercises.models.Book;
import com.sbt.exercises.repositories.BookRepository;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    public List<Book> getBooks() {
        return bookRepository.getBooks();
    }

    public Book getBookById(String id) {
        return bookRepository.getBookById(id);
    }

    public Book createBook(Book book) {
        return bookRepository.createBook(book);
    }

    public Book updateBook(String id,Book book) {
        return bookRepository.updateBook(id, book);
    }

    public Integer deleteBook(String id) {
        return bookRepository.deleteBook(id);
    }

    public Book markAsRead(String id){
        return bookRepository.markAsRead(id);
    }

    public List<Book> getBookRead(){
        return bookRepository.getBookRead();
    }
}
