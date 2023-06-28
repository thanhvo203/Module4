package com.example.demo.service;

import com.example.demo.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBookService {
    Page<Book> findOrderByCheckStatusIsFalse(Pageable pageable);

    void addBook(Book booking);

    void updateBook(Book booking);

    void deleteBook(int id);

    Book findById(int id);
    void giveBackBook(int code);
}
