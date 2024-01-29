package com.reative.service;

import com.reative.entity.Book;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface BookService {

    public Mono<Book> crateBook(Book book);

    public Flux<Book> getAllBook();

    public Mono<Book> getBook(int bookId);

    public Mono<Book> updateBook(Book book,int bookId);

    Flux<Book> saveBooks(List<Book> books);

    public Mono<Void> deleteBook(int bookId);

    Mono<Book> findByName(String name);
    Flux<Book> findByAuthor(String author);
    Flux<Book> findByPublisher(String publisher);
    Flux<Book> findByAuthorAndName(String author, String name);


     public  Flux<Book> searchBooksByKeyword(String keyword);

    Flux<Book> searchBookByName(String name);
}
