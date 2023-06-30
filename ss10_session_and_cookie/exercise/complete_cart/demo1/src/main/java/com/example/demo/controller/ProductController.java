package com.example.demo.controller;

import com.example.demo.model.Cart;
import com.example.demo.model.Product;
import com.example.demo.service.IProductService;
import com.example.demo.service.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/product")
@SessionAttributes("addedCart")
public class ProductController {
    @Autowired
    private IProductService productService;

    @GetMapping()
    public String showListProduct(Model model) {
        model.addAttribute("products", productService.showListProduct());
        return "/list-product";
    }
    @ModelAttribute("addedCart")
    public Cart getCart(){
        return new Cart();
    }
    @GetMapping("/detail/{id}")
    public String detailProduct(@PathVariable("id") int id , Model model, RedirectAttributes redirectAttributes){
        if (productService.findProductByID(id) == null) {
            redirectAttributes.addFlashAttribute("message", "This id doesn't exits");
            return "redirect:/product";
        }else {
            Product product = productService.findProductByID(id);
            model.addAttribute("product", product);
            return "/detail-product";
        }
    }
    @GetMapping("/cart/{id}")
    public String addToCart(@PathVariable("id") int id, @ModelAttribute("addedCart") Cart cart, RedirectAttributes redirectAttributes){
        if (productService.findProductByID(id) == null){
            redirectAttributes.addFlashAttribute("message","This Product Doesn't exit");
            return "redirect:/product";
        }
        cart.addProduct(productService.findProductByID(id));
        redirectAttributes.addFlashAttribute("message","Add To Cart Success");
        return "redirect:/product";
    }
    @GetMapping("/your-cart")
    public String showYourCart (@SessionAttribute("addedCart") Cart cart, Model model){
        model.addAttribute("carts",cart);
        return "/your-cart";
    }

}
