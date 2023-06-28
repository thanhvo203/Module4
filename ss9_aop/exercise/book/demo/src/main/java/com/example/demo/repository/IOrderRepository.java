package com.example.demo.repository;

import com.example.demo.model.OrderBook;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderRepository extends JpaRepository<OrderBook,Integer> {

    Page<OrderBook> findOrderByCheckStatusIsFalse(Pageable pageable);
    OrderBook findByCode(int id);

    boolean existsAllByCode(int code);

}
