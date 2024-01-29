package com.reative.service.serviceImpl;

import com.reative.entity.Book;
import com.reative.repository.BookRepository;
import com.reative.service.BookService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class ServiceImpl implements BookService {
    private BookRepository bookRepository;

    public ServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Mono<Book> crateBook(Book book) {
        Mono<Book> save = bookRepository.save(book);
        return save;
    }

    @Override
    public Flux<Book> getAllBook() {
        Flux<Book> all = bookRepository.findAll();
        return all;
    }

    @Override
    public Mono<Book> getBook(int bookId) {
        return bookRepository.findById(bookId);

    }

    @Override
    public Mono<Book> updateBook(Book book, int bookId) {
        Mono<Book> b = bookRepository.findById(bookId);
        return b.flatMap(exbook -> {
            exbook.setName(book.getName());
            exbook.setDescription(book.getDescription());
            exbook.setAuthor(book.getAuthor());
            exbook.setPublisher(book.getPublisher());
            Mono<Book> save = bookRepository.save(exbook);
            return save;
        });
    }

    @Override
    public Flux<Book> saveBooks(List<Book> books) {
        return bookRepository.saveAll(books);

    }


    @Override
    public Mono<Void> deleteBook(int bookId) {
        return bookRepository.findById(bookId).flatMap(book->{
           return bookRepository.delete(book);
        });

    }

    @Override
    public Mono<Book> findByName(String name) {
        return bookRepository.findByName(name);
    }

    @Override
    public Flux<Book> findByAuthor(String author) {
        return bookRepository.findByAuthor(author);
    }

    @Override
    public Flux<Book> findByPublisher(String publisher) {
        return bookRepository.findByPublisher(publisher);
    }

    @Override
    public Flux<Book> findByAuthorAndName(String author, String name) {
        return bookRepository.findByAuthorAndName(author, name);
    }

    @Override
    public Flux<Book> searchBooksByKeyword(String keyword) {
        try {
            Long bookId = Long.parseLong(keyword);
            return bookRepository.findByBookIdOrAuthorOrName(bookId, keyword, keyword);
        } catch (NumberFormatException e) {
            // If the keyword is not a valid Long, treat it as an author or name
            return bookRepository.findByBookIdOrAuthorOrName(null, keyword, keyword);
        }
    }

    @Override
    public Flux<Book> searchBookByName(String name) {
        return bookRepository.searchBookByName("%" + name + "%");
    }
}
