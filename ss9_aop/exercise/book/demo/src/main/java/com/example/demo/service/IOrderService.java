package com.example.demo.service;

import com.example.demo.model.Book;
import com.example.demo.model.OrderBook;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IOrderService {
    Page<OrderBook> findOrderByCheckStatusIsFalse(Pageable pageable);

    void updateBook(OrderBook order);


    OrderBook findById(int id);
    boolean existsAllByCode(int code);

    void addNewOrder(Book book, int code);


}
