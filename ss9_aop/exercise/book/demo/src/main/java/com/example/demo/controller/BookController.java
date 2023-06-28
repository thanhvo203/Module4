package com.example.demo.controller;

import com.example.demo.model.Book;
import com.example.demo.model.OrderBook;
import com.example.demo.service.impl.BookServiceImpl;
import com.example.demo.service.impl.OrderServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookServiceImpl bookService;

    @Autowired
    private OrderServiceImpl orderService;

    @GetMapping()
    public String getAllBook(@PageableDefault(size = 2) Pageable pageable, Model model) {
        model.addAttribute("books", bookService.findOrderByCheckStatusIsFalse(pageable));
        return "/list-book";
    }

    @GetMapping("create")
    public String showFormCreate(Model model) {
        model.addAttribute("book", new Book());
        return "create-book";
    }

    @PostMapping("create")
    public String createBook(@ModelAttribute Book book, RedirectAttributes redirectAttributes) {
        bookService.addBook(book);
        redirectAttributes.addFlashAttribute("message", "Add new Success");
        return "redirect:/book";
    }

    @GetMapping("/delete/{id}")
    public String showFormDelete(@PathVariable int id, Model model, RedirectAttributes redirectAttributes) {
        if (bookService.findById(id) == null) {
            redirectAttributes.addFlashAttribute("message", "Not found id");
            return "redirect:/book";
        } else {
            Book book = bookService.findById(id);
            model.addAttribute("book", book);
            return "/delete-book";
        }
    }

    @PostMapping("/delete/{id}")
    public String deleteBook(@RequestParam("id") int id, RedirectAttributes redirectAttributes) {
        if (bookService.findById(id) == null) {
            redirectAttributes.addFlashAttribute("message", "Not found id");
            return "redirect:/book";
        } else {
            bookService.deleteBook(id);
            redirectAttributes.addFlashAttribute("message", "Delete Book Success");
            return "redirect:/book";
        }
    }

    @GetMapping("/edit/{id}")
    public String showFormEidt(@PathVariable int id, Model model, RedirectAttributes redirectAttributes) {
        if (bookService.findById(id) == null) {
            redirectAttributes.addFlashAttribute("message", "Not found id");
            return "redirect:/book";
        } else {
            Book book = bookService.findById(id);
            model.addAttribute("book", book);
            return "/edit-book";
        }
    }

    @PostMapping("/edit/{id}")
    public String editSong(@ModelAttribute Book book,
                           RedirectAttributes redirectAttributes) {
        bookService.updateBook(book);
        redirectAttributes.addFlashAttribute("message", "Edit Book Success");
        return "redirect:/book";
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
    @GetMapping("/return")
    String showFormGiveBackBook(){
        return "/return-book";
    }
    @PostMapping("/return")
    public String returnBook(@RequestParam("code") int code, RedirectAttributes redirectAttributes) {
        bookService.giveBackBook(code);
        redirectAttributes.addFlashAttribute("message","Give Back Success");
        return "redirect:/book";
    }
}
