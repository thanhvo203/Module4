package com.example.demo.controller;

import com.example.demo.model.Product;
import com.example.demo.service.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductServiceImpl productService;

    @GetMapping()
    public String showListProduct(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("products", productService.getListProduct());
        return "/list";
    }

    @GetMapping("/create")
    public String showListCreate(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        return "/create";
    }

    @PostMapping("/create")
    public String createProduct(@ModelAttribute Product product, RedirectAttributes redirectAttributes) {
        productService.createProduct(product);
        redirectAttributes.addFlashAttribute("message", "Add New Product Success");
        return "redirect:/product";
    }

    @GetMapping("/delete/{id}")
    public String showListDelete(@PathVariable int id, Model model, RedirectAttributes redirectAttributes) {
        Product product = productService.getProductByID(id);
        if (product == null) {
            redirectAttributes.addFlashAttribute("message", "ID not found to delete");
            return "redirect:/product";
        } else {
            model.addAttribute("product", product);
            return "/delete";
        }
    }

    @PostMapping("/delete")
    public String deleteProduct(@RequestParam("id") int id, RedirectAttributes redirectAttributes) {
        productService.deleteProduct(id);
        redirectAttributes.addFlashAttribute("message", "Delete Product Success");
        return "redirect:/product";
    }

    @GetMapping("/edit/{id}")
    public String showListEdit(@PathVariable int id, Model model, RedirectAttributes redirectAttributes) {
        Product product = productService.getProductByID(id);
        if (product == null) {
            redirectAttributes.addFlashAttribute("message", "ID not found to edit");
            return "redirect:/product";
        } else {
            model.addAttribute("product", product);
            return "/edit";
        }
    }

    @PostMapping("/edit")
    private String editProduct(@RequestParam("id") int id, @ModelAttribute Product product, RedirectAttributes redirectAttributes) {
        productService.editProduct(id, product);
        redirectAttributes.addFlashAttribute("message", "Edit Product Success");
        return "redirect:/product";
    }

    @GetMapping("/detail/{id}")
    public String showListDetail(@PathVariable int id, Model model, RedirectAttributes redirectAttributes) {
        Product product = productService.getProductByID(id);
        if (product == null) {
            redirectAttributes.addFlashAttribute("message", "ID not found to detail");
            return "redirect:/product";
        } else {
            model.addAttribute("product", productService.getProductByID(id));
            return "/detail";
        }
    }

    @PostMapping("/search")
    public String searchProduct(@ModelAttribute Product product, Model model, RedirectAttributes redirectAttributes) {
        model.addAttribute("product", productService.searchProduct(product.getName()));
        redirectAttributes.addFlashAttribute("message", "Search Product Success");
        return "/search";
    }
}
