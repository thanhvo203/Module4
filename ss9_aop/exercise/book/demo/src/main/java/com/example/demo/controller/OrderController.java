package com.example.demo.controller;


import com.example.demo.model.Book;
import com.example.demo.service.impl.BookServiceImpl;
import com.example.demo.service.impl.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/order")
public class OrderController {
   @Autowired
    private OrderServiceImpl orderService;
   @Autowired
   private BookServiceImpl bookService;

   @GetMapping()
    public String showListOrder(@PageableDefault(size = 2) Pageable pageable, Model model){
       model.addAttribute("orders",orderService.findOrderByCheckStatusIsFalse(pageable));
       return "/list-order";
   }
    @GetMapping("/borrow/{id}")
    public String showBorrowDetail(@PathVariable int id, Model model) {
        Book book = bookService.findById(id);
        model.addAttribute("book", book);
        int code = (int) Math.floor((Math.random() + 1) * 10000);
        while (orderService.existsAllByCode(code)) {
            code = (int) Math.floor((Math.random() + 1) * 10000);
        }
        model.addAttribute("code", code);
        return "order-book";
    }
    @PostMapping("/borrow/{id}")
    public String borrowBook(@ModelAttribute Book book, RedirectAttributes redirectAttributes, @RequestParam int id) {
        if (book.getCountBook() > 0) {
            orderService.addNewOrder(book, id);
            book.setCountBook(book.getCountBook() - 1);
            bookService.updateBook(book);
            redirectAttributes.addFlashAttribute("message", "Borrow Successfully book");
        } else {
            redirectAttributes.addFlashAttribute("message", "This book doesn't exit");
        }
        return "redirect:/book";
    }
}
