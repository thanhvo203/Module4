package com.example.demo.controller;

import com.example.demo.model.BLog;
import com.example.demo.respository.IBlogRepository;
import com.example.demo.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


@RestController
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<BLog> showListBLog() {
        return blogService.findAllByCheckStatusIsFalse();
    }

    @PostMapping()
    public ResponseEntity<BLog> createBlog(@RequestBody BLog bLog, @PathVariable int id) {
        if (blogService.getBlogById(id) == null){
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }else {
            blogService.createBlog(bLog);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
    }


    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteBlog(@PathVariable int id) {
        if (blogService.getBlogById(id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            blogService.deleteBlog(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @PutMapping("{id}")
    private ResponseEntity<?> editBlog(@RequestBody BLog bLog, @PathVariable int id) {
        if (blogService.getBlogById(id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            blogService.updateBlog(bLog);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<BLog> showDetailBLog(@PathVariable int id) {
        if (blogService.getBlogById(id) == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            BLog bLog = blogService.detailBlog(id);
            return new ResponseEntity<>(bLog, HttpStatus.OK);
        }
    }
}
