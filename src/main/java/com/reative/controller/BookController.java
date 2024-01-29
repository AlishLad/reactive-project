package com.reative.controller;

import com.reative.entity.Book;
import com.reative.service.BookService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private BookService bookService;


    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public Mono<Book> createBook(@RequestBody Book book) {
        return bookService.crateBook(book);
    }

    @GetMapping
    public Flux<Book> getAllBooks() {
        return bookService.getAllBook().doOnNext(d->System.out.println(Thread.currentThread().getName()));
    }

    @GetMapping("/{book_id}")
    public Mono<Book> getBook(@PathVariable("book_id") int bookId) {
        return bookService.getBook(bookId);
    }

    @PutMapping("/{bookId}")
    public Mono<Book> updateBook(@RequestBody Book book, @PathVariable int bookId) {
        return bookService.updateBook(book, bookId);
    }

    @GetMapping("/search")
    public Flux<Book> searchBooksByKeyword(@RequestParam String keyword) {
        return bookService.searchBooksByKeyword(keyword);
    }

    @DeleteMapping("/{bookId}")
    public Mono<Void> deleteBook(@PathVariable int bookId) {
        return bookService.deleteBook(bookId);
    }

    @PostMapping("/save-all")
    public Flux<Book> saveBooks(@RequestBody List<Book> books) {
        return bookService.saveBooks(books);
    }

    @GetMapping("/findByName/{name}")
    public Mono<Book> findByName(@PathVariable String name) {
        return bookService.findByName(name);
    }

    @GetMapping("/findByAuthor/{author}")
    public Flux<Book> findByAuthor(@PathVariable String author) {
        return bookService.findByAuthor(author);
    }

    @GetMapping("/findByPublisher/{publisher}")
    public Flux<Book> findByPublisher(@PathVariable String publisher) {
        return bookService.findByPublisher(publisher);
    }

    @GetMapping("/findByAuthorAndName")
    public Flux<Book> findByAuthorAndName(
            @RequestParam(required = false) String author,
            @RequestParam(required = false) String name) {
        return bookService.findByAuthorAndName(author, name);
    }

    @GetMapping("/searchByName")
    public Flux<Book> searchBookByName(@RequestParam String name) {
        return bookService.searchBookByName(name);
    }
}
