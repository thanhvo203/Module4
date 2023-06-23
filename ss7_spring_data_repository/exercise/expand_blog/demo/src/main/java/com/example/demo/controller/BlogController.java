package com.example.demo.controller;

import com.example.demo.model.BLog;
import com.example.demo.respository.IBlogRepository;
import com.example.demo.service.impl.BlogServiceImpl;
import com.example.demo.service.impl.TypeBlogServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private BlogServiceImpl blogService;
    @Autowired
    private TypeBlogServiceImpl typeBlogService;
    @Autowired
    private IBlogRepository blogRepository;


    @GetMapping()
    public String showListBLog(@PageableDefault(size = 2, sort = "date") Pageable pageable, Model model) {
        model.addAttribute("typeBlogs",typeBlogService.getListBlog());
        model.addAttribute("blogs", blogRepository.findAllByCheckStatusIsFalse(pageable));
        return "/list";
    }
    @GetMapping("/search/{id}")
    public String searchBlogs(@PageableDefault(size = 2, sort = "date") Pageable pageable,@PathVariable("id") int id, Model model){
        model.addAttribute("typeBlogs",typeBlogService.getListBlog());
        model.addAttribute("blogs",blogService.searchTypeBlogById(id,pageable));
        return "/search";
    }

    @GetMapping("/create")
    public String showListCreate(Model model) {
        BLog bLog = new BLog();
        model.addAttribute("blog", bLog);
        model.addAttribute("typeBlogs", typeBlogService.getListBlog());
        return "/create";
    }

    @PostMapping("/create")
    public String createBlog(@ModelAttribute BLog bLog, RedirectAttributes redirectAttributes) {
        blogService.createBlog(bLog);
        redirectAttributes.addFlashAttribute("message", "Add New Blog Success");
        return "redirect:/blog";

    }

    @GetMapping("/delete/{id}")
    public String showListDeleteBLog(@PathVariable int id, Model model, RedirectAttributes redirectAttributes) {
        if (blogService.getBlogByID(id) == null) {
            redirectAttributes.addFlashAttribute("message", "ID not found to delete");
            return "redirect:/blog";
        } else {
            BLog bLog = blogService.getBlogByID(id);
            model.addAttribute("blog", bLog);
            return "/delete";
        }
    }

    @PostMapping("/delete/{id}")
    public String deleteBlog(@RequestParam("id") int id, RedirectAttributes redirectAttributes) {
        if (blogService.getBlogByID(id) == null) {
            redirectAttributes.addFlashAttribute("message", "ID not found to delete");
            return "redirect:/blog";
        } else {
            blogService.deleteBlog(id);
            redirectAttributes.addFlashAttribute("message", "Delete Blog Success");
            return "redirect:/blog";
        }
    }

    @GetMapping("/edit/{id}")
    public String showListEditBlog(@PathVariable int id, Model model, RedirectAttributes redirectAttributes) {
        if (blogService.getBlogByID(id) == null) {
            redirectAttributes.addFlashAttribute("message", "ID not found to edit");
            return "redirect:/blog";
        } else {
            BLog bLog = blogService.getBlogByID(id);
            model.addAttribute("blog", bLog);
            model.addAttribute("typeBlogs", typeBlogService.getListBlog());
            return "/edit";
        }
    }

    @PostMapping("/edit/{id}")
    private String editBlog(@RequestParam("id") int id, BLog product, RedirectAttributes redirectAttributes) {
        if (blogService.getBlogByID(id) == null) {
            redirectAttributes.addFlashAttribute("message", "ID not found to edit");
            return "redirect:/blog";
        } else {
            blogService.updateBlog(product);
            redirectAttributes.addFlashAttribute("message", "Edit Blog Success");
            return "redirect:/blog";
        }
    }

    @GetMapping("/detail/{id}")
    public String showListDetail(@PathVariable int id, Model model, RedirectAttributes redirectAttributes) {
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
