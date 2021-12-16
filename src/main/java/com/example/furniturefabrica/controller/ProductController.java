package com.example.furniturefabrica.controller;

import com.example.furniturefabrica.entity.Product;
import com.example.furniturefabrica.payload.ApiResponse;
import com.example.furniturefabrica.payload.ProductDto;
import com.example.furniturefabrica.repositories.ProductRepository;
import com.example.furniturefabrica.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    ProductRepository productRepository;
    @Autowired
    ProductService productService;


    @GetMapping("/list")
    public HttpEntity<?> getProduct() {
        List<Product> all = productRepository.findAll();
        return ResponseEntity.ok(all);


    }

    @GetMapping("/getOne/{id}")
    public HttpEntity<?> getOne(@PathVariable Integer id) {
        Optional<Product> byId = productRepository.findById(id);
        if (!byId.isPresent()) return (HttpEntity<?>) ResponseEntity.status(HttpStatus.NOT_FOUND);
        Product product = byId.get();

        return ResponseEntity.ok(product);

    }

    @PostMapping("/add")
    public HttpEntity<?> addProduct(@RequestParam ProductDto productDto) {
        ApiResponse apiResponse = productService.addProduct(productDto);
        return ResponseEntity.status(apiResponse.isSuccess() ? 201 : 409).body(apiResponse);


    }

    @PutMapping("/editProduct/{id}")

    public HttpEntity<?> edit(@PathVariable Integer id, @RequestParam ProductDto productDto) {
        ApiResponse apiResponse = productService.editProduct(id, productDto);
        return ResponseEntity.status(apiResponse.isSuccess() ? 201 : 409).body(apiResponse);

    }

    @DeleteMapping("delete/{id}")
    public HttpEntity<?> deleteById(@PathVariable Integer id) {
        Optional<Product> byId = productRepository.findById(id);
        if (!byId.isPresent()) return (HttpEntity<?>) ResponseEntity.status(HttpStatus.NOT_FOUND);

        productRepository.deleteById(id);
        return (HttpEntity<?>) ResponseEntity.ok();
    }


}
