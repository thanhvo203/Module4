package com.example.demo.service.impl;

import com.example.demo.model.Book;
import com.example.demo.model.OrderBook;
import com.example.demo.repository.IOrderRepository;
import com.example.demo.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class OrderServiceImpl implements IOrderService {

    @Autowired
    private IOrderRepository iOrderRepository;

    @Override
    public Page<OrderBook>  findOrderByCheckStatusIsFalse(Pageable pageable) {
        return iOrderRepository.findOrderByCheckStatusIsFalse(pageable);
    }

    @Override
    public void updateBook(OrderBook order) {
         iOrderRepository.save(order);
    }

    @Override
    public OrderBook findById(int id) {
        return iOrderRepository.findById(id).orElse(null);
    }

    @Override
    public boolean existsAllByCode(int code) {
        return iOrderRepository.existsAllByCode(code);
    }


    @Override
    public void addNewOrder(Book book, int code) {
        OrderBook order = new OrderBook();
        order.setDateOrder(LocalDate.now());
        order.setCode(code);
        order.setBooking(book);
        iOrderRepository.save(order);
    }

}
