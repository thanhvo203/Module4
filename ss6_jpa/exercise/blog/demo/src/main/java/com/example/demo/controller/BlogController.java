package com.example.demo.controller;

import com.example.demo.model.BLog;
import com.example.demo.service.impl.BlogServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private BlogServiceImpl blogService;

    @GetMapping()
    public String showListBLog(Model model) {
        model.addAttribute("blogs", blogService.getListBlog());
        return "/list";
    }

    @GetMapping("/create")
    public String showListCreate(Model model) {
        BLog bLog = new BLog();
        model.addAttribute("blog", bLog);
        return "/create";
    }
    @PostMapping("/create")
    public String createBlog(BLog bLog, RedirectAttributes redirectAttributes) {
        blogService.createBlog(bLog);
        redirectAttributes.addFlashAttribute("message", "Add New Blog Success");
        return "redirect:/blog";

    }
    @GetMapping("/delete/{id}")
    public String showListDeleteBLog(@PathVariable int id, Model model, RedirectAttributes redirectAttributes){
        if (blogService.getBlogByID(id) == null) {
            redirectAttributes.addFlashAttribute("message", "ID not found to delete");
            return "redirect:/blog";
        } else {
            BLog bLog = blogService.getBlogByID(id);
            model.addAttribute("blog", bLog);
            return "/delete";
        }
    }
    @PostMapping("/delete")
    public String deleteBlog(@RequestParam("id") int id, RedirectAttributes redirectAttributes){
        blogService.deleteBlog(id);
        redirectAttributes.addFlashAttribute("message", "Delete Blog Success");
        return "redirect:/blog";
    }
    @GetMapping("/edit/{id}")
    public String showListEditBlog(@PathVariable int id,  Model model, RedirectAttributes redirectAttributes){
        if (blogService.getBlogByID(id) == null) {
            redirectAttributes.addFlashAttribute("message", "ID not found to edit");
            return "redirect:/blog";
        } else {
            BLog bLog = blogService.getBlogByID(id);
            model.addAttribute("blog", bLog);
            return "/edit";
        }
    }
    @PostMapping("/edit")
    private String editBlog( BLog product, RedirectAttributes redirectAttributes){
        blogService.updateBlog(product);
        redirectAttributes.addFlashAttribute("message", "Edit Blog Success");
        return "redirect:/blog";
    }
    @GetMapping("/detail/{id}")
    public String showListDetail(@PathVariable int id,  Model model, RedirectAttributes redirectAttributes){
        if (blogService.getBlogByID(id) == null) {
            redirectAttributes.addFlashAttribute("message", "ID not found to detail");
            return "redirect:/blog";
        } else {
            BLog bLog = blogService.getBlogByID(id);
            model.addAttribute("blog", bLog);
            return "/detail";
        }
    }
}
