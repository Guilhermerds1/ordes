package com.estudos.orders.resources;

import ch.qos.logback.core.status.Status;
import com.estudos.orders.entities.Category;
import com.estudos.orders.services.CategoryService;
import jdk.jshell.Snippet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/category")

public class CategoryResource {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<Category>> findAll(){
        List<Category> categories = categoryService.findAll();
        return ResponseEntity.ok().body(categories);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Category> findById(@PathVariable Long id){
        Category category = categoryService.findById(id);
        return ResponseEntity.ok().body(category);
    }

    @PostMapping
    public ResponseEntity<Category> saveCategory(@RequestBody Category category){
        categoryService.saveCategory(category);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
