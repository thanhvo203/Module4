package com.example.demo.controller;


import com.example.demo.model.TypeBlog;

import com.example.demo.respository.ITypeBlogRepository;

import com.example.demo.service.impl.TypeBlogServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/type-blog")
public class TypeBlogController {
    @Autowired
    private TypeBlogServiceImpl typeBlogService;

    @Autowired
    private ITypeBlogRepository typeBlogRepository;


    @GetMapping()
    public String showListTypeBLog(@PageableDefault(size = 2) Pageable pageable, Model model) {
        model.addAttribute("typeBlogs", typeBlogRepository.findAllByCheckStatusIsFalse(pageable));
        return "/list-type-blog";
    }

    @GetMapping("/create")
    public String showFormCreateTypeBlog(Model model) {
        TypeBlog typeBlog = new TypeBlog();
        model.addAttribute("typeBlog", typeBlog);
        return "/create-type-blog";
    }

    @PostMapping("/create")
    public String createTypeBlog(@ModelAttribute TypeBlog typeBlog, RedirectAttributes redirectAttributes) {
        typeBlogService.createTypeBlog(typeBlog);
        redirectAttributes.addFlashAttribute("message", "Add New Type Blog Success");
        return "redirect:/type-blog";

    }

    @GetMapping("/delete/{id}")
    public String showListDeleteTypeBLog(@PathVariable int id, Model model, RedirectAttributes redirectAttributes) {
        if (typeBlogService.getTypeBlogByID(id) == null) {
            redirectAttributes.addFlashAttribute("message", "ID not found to delete");
            return "redirect:/type-blog";
        } else {
            TypeBlog typeBlog = typeBlogService.getTypeBlogByID(id);
            model.addAttribute("typeBlog", typeBlog);
            return "/delete-type-blog";
        }
    }

    @PostMapping("/delete/{id}")
    public String deleteTypeBlog(@RequestParam("id") int id, RedirectAttributes redirectAttributes) {
        if (typeBlogService.getTypeBlogByID(id) == null) {
            redirectAttributes.addFlashAttribute("message", "ID not found to delete");
            return "redirect:/type-blog";
        } else {
            typeBlogService.deleteTypeBlog(id);
            redirectAttributes.addFlashAttribute("message", "Delete Type Blog Success");
            return "redirect:/type-blog";
        }
    }

    @GetMapping("/edit/{id}")
    public String showFormEditTypeBlog(@PathVariable int id, Model model, RedirectAttributes redirectAttributes) {
        if (typeBlogService.getTypeBlogByID(id) == null) {
            redirectAttributes.addFlashAttribute("message", "ID not found to edit");
            return "redirect:/type-blog";
        } else {
            TypeBlog typeBlog = typeBlogService.getTypeBlogByID(id);
            model.addAttribute("typeBlog", typeBlog);
            return "/edit-type-blog";
        }
    }

    @PostMapping("/edit/{id}")
    private String editTypeBlog(@RequestParam("id") int id, TypeBlog typeBlog, RedirectAttributes redirectAttributes) {
        if (typeBlogService.getTypeBlogByID(id) == null) {
            redirectAttributes.addFlashAttribute("message", "ID not found to edit");
            return "redirect:/type-blog";
        } else {
            typeBlogService.updateTypeBlog(typeBlog);
            redirectAttributes.addFlashAttribute("message", "Edit Type Blog Success");
            return "redirect:/type-blog";
        }
    }
}
