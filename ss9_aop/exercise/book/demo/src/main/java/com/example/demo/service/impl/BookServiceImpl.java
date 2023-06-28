package com.example.demo.service.impl;

import com.example.demo.model.Book;
import com.example.demo.repository.IBookingRepository;
import com.example.demo.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements IBookService {
    @Autowired
    private IBookingRepository bookingRepository;

    @Override
    public Page<Book> findOrderByCheckStatusIsFalse(Pageable pageable) {
        return bookingRepository.findAllByCheckStatusIsFalse(pageable);
    }

    @Override
    public void addBook(Book booking) {
         bookingRepository.save(booking);
    }

    @Override
    public void updateBook(Book booking) {
      bookingRepository.save(booking);
    }

    @Override
    public void deleteBook(int id) {
      Book book =  findById(id);
      book.setCheckStatus(true);
      bookingRepository.delete(book);
    }

    @Override
    public Book findById(int id) {
        return bookingRepository.findById(id).orElse(null);
    }

    @Override
    public void giveBackBook(int code) {
        Book book =  findById(code);
        int countBook = book.getCountBook()+1;
        book.setCountBook(countBook);
        bookingRepository.save(book);
    }

}
