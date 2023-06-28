package com.example.demo.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "order_book")
public class OrderBook {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private int id;

    private LocalDate dateOrder;

    private int code;
    @ManyToOne
    @JoinColumn
    private Book booking;

    private boolean checkStatus;

    public OrderBook(int id, LocalDate dateOrder, int code, Book booking, boolean checkStatus) {
        this.id = id;
        this.dateOrder = dateOrder;
        this.code = code;
        this.booking = booking;
        this.checkStatus = checkStatus;
    }


    public OrderBook() {
    }

    public OrderBook(LocalDate dateOrder, int code, Book booking, boolean checkStatus) {

        this.dateOrder = dateOrder;
        this.code = code;
        this.booking = booking;
        this.checkStatus = checkStatus;
    }


    public boolean isCheckStatus() {
        return checkStatus;
    }

    public void setCheckStatus(boolean checkStatus) {
        this.checkStatus = checkStatus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDateOrder() {
        return dateOrder;
    }

    public void setDateOrder(LocalDate dateOrder) {
        this.dateOrder = dateOrder;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Book getBooking() {
        return booking;
    }

    public void setBooking(Book booking) {
        this.booking = booking;
    }
}
