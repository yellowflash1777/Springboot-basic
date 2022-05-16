package com.example.firebase.demofirebase.controller;

import com.example.firebase.demofirebase.entity.Product;
import com.example.firebase.demofirebase.service.Productservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api")
public class Productcontroller {

    @Autowired
    private Productservice productservice;

    @PostMapping("/products")
    public String saveProduct(@RequestBody Product product) throws ExecutionException, InterruptedException {
        return productservice.saveProduct(product);
    }


    @GetMapping ("/products/{name}")
    public Product getProduct(@PathVariable String name) throws ExecutionException, InterruptedException {
        return productservice.getProductDetailyname(name);
    }

    @GetMapping ("/products")
    public List<Product> getAllProduct() throws ExecutionException, InterruptedException {
        return productservice.getProductDetail();
    }


    @PutMapping("/products")
    public String update(@RequestBody Product product) throws ExecutionException, InterruptedException {
        return productservice.updateProduct(product);
    }

    @DeleteMapping ("/products/{name}")
    public String deleteProduct(@PathVariable String name) throws ExecutionException, InterruptedException {
        return productservice.deleteProduct(name);
    }



}
