package com.example.demo.controller;

import com.example.demo.model.Product;
import com.example.demo.service.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductServiceImpl productService;

    @GetMapping()
    public String showListProduct(Model model) {
        model.addAttribute("product1",new Product());
        model.addAttribute("product", productService.getListProduct());
        return "/list";
    }

    @GetMapping("/create")
    public String showListCreate(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        return "/create";
    }
    @PostMapping("/create")
    public String createProduct(Product product) {
        productService.createProduct(product);
        return "redirect:/product";
    }
    @GetMapping("/{id}/delete")
    public String showListDelete(@PathVariable int id, Model model){
       model.addAttribute("product",productService.getProductByID(id));
        return "/delete";
    }
    @PostMapping("/delete")
    public String deleteProduct(@RequestParam("id") int id){
        productService.deleteProduct(id);
        return "redirect:/product";
    }
    @GetMapping("/{id}/edit")
    public String showListEdit(@PathVariable int id,  Model model){
        model.addAttribute("product" ,productService.getProductByID(id));
        return "/edit";
    }
    @PostMapping("/edit")
    private String editProduct(@RequestParam("id")int id , Product product){
        productService.editProduct(id,product);
        return "redirect:/product";
    }
    @GetMapping("/{id}/detail")
    public String showListDetail(@PathVariable int id,  Model model){
        model.addAttribute("product" ,productService.getProductByID(id));
        return "/detail";
    }
    @PostMapping("/search")
    public String searchProduct(@ModelAttribute Product product,  Model model){
        model.addAttribute("product" ,productService.searchProduct(product.getName()));
        return "/search";
    }
}
