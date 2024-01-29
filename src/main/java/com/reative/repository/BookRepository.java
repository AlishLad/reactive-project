package com.reative.repository;

import com.reative.entity.Book;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BookRepository extends ReactiveCrudRepository<Book,Integer> {


    Flux<Book> findByBookIdOrAuthorOrName(Long bookId, String author, String name);

    Mono<Book> findByName(String name);

    Flux<Book> findByAuthor(String author);

    Flux<Book> findByPublisher(String publisher);

    Flux<Book> findByAuthorAndName(String author,String name);
    @Query("select * from book_details where name like :name")
    Flux<Book> searchBookByName(String name);
}
