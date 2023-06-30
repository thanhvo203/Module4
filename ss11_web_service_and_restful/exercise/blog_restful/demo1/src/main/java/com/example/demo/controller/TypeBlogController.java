package com.example.demo.controller;


import com.example.demo.model.TypeBlog;
import com.example.demo.respository.ITypeBlogRepository;
import com.example.demo.service.ITypeBlogService;
import com.example.demo.service.impl.TypeBlogServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.lang.reflect.Type;
import java.time.temporal.TemporalUnit;
import java.util.List;

@RestController
@RequestMapping("/type-blog")
public class TypeBlogController {
    @Autowired
    private ITypeBlogService typeBlogService;


    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<TypeBlog> showListTypeBLog() {
        return typeBlogService.findAllByCheckStatusIsFalse();
    }

    @PostMapping()
    public ResponseEntity<TypeBlog> createTypeBlog(@RequestBody TypeBlog typeBlog,@PathVariable int id) {
        if (typeBlogService.getTypeBlogById(id) == null){
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }else{
            typeBlogService.updateTypeBlog(typeBlog);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
    }


    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteTypeBlog(@PathVariable int id) {
        if (typeBlogService.getTypeBlogById(id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            typeBlogService.deleteTypeBlog(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }


    @PutMapping("{id}")
    private ResponseEntity<?> editTypeBlog(@RequestBody TypeBlog typeBlog, @PathVariable int id) {
        if (typeBlogService.getTypeBlogById(id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            typeBlogService.updateTypeBlog(typeBlog);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @GetMapping("{id}")
    private ResponseEntity<TypeBlog> detailTypeBlog(@PathVariable int id) {
        if (typeBlogService.getTypeBlogById(id) == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            TypeBlog typeBlog = typeBlogService.detailTypeBlog(id);
            return new ResponseEntity<>(typeBlog , HttpStatus.OK);
        }
    }
}
