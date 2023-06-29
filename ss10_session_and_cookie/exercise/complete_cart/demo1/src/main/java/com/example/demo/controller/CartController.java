package com.example.demo.controller;

import com.example.demo.model.Cart;
import com.example.demo.service.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CartController {
    @Autowired
    private ProductServiceImpl productService;

    @GetMapping("change/{id}")
    public String changeQuality(@PathVariable("id") int id, @SessionAttribute("addedCart") Cart cart,
                                @RequestParam("action") String action) {
        if (action.equals("addition")) {
            cart.addProduct(productService.findProductByID(id));
        } else {
            cart.subtractProduct(productService.findProductByID(id));
        }
        return "redirect:/product/your-cart";
    }

    @GetMapping("delete/{id}")
    public String deleteCart(@PathVariable("id") int id, @SessionAttribute("addedCart") Cart cart,
                             @RequestParam("action") String action, RedirectAttributes redirectAttributes) {
        if (action.equals("delete") && productService.findProductByID(id) == null) {
            redirectAttributes.addFlashAttribute("message", "This id doesn't exit");
            return "redirect:/product/your-cart";
        }
        cart.deleteCart(productService.findProductByID(id));
        redirectAttributes.addFlashAttribute("message", "Delete Success");
        return "redirect:/product/your-cart";
    }
}

