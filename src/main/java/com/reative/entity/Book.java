package com.reative.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Table(name = "book_details")
public class Book {

    @Id
    @Column("book_id")
    private Long bookId;

    private String name;

    @Column("book_desc")
    private String description;

    private String publisher;

    private String author;
}
