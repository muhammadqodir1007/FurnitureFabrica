package com.example.furniturefabrica.controller;

import com.example.furniturefabrica.entity.ProductType;
import com.example.furniturefabrica.payload.ApiResponse;
import com.example.furniturefabrica.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProductTypeController {


    @Autowired
    ProductTypeService productTypeService;


    @GetMapping
    public HttpEntity<?> getList() {
        List<ProductType> list = productTypeService.getList();

        return ResponseEntity.status(201).body(list);


    }

    @GetMapping("/getOne/{id}")
    public HttpEntity<?> getOne(Integer id) {
        ApiResponse one = productTypeService.getOne(id);

        return ResponseEntity.status(one.isSuccess() ? 201 : 409).body(one);

    }

    @PostMapping("/add")
    public HttpEntity<?> add(@RequestParam ProductType productType) {
        ApiResponse add = productTypeService.add(productType);

        return ResponseEntity.status(add.isSuccess() ? 201 : 409).body(add);

    }

    @PutMapping("edit/{id}")
    public HttpEntity<?> edit(@PathVariable Integer id, @RequestParam ProductType productType) {
        ApiResponse edit = productTypeService.edit(id, productType);
        return ResponseEntity.status(edit.isSuccess() ? 201 : 409).body(edit);
    }

    @DeleteMapping("delete/{id}")
    public HttpEntity<?> delete(@PathVariable Integer id) {

        ApiResponse delete = productTypeService.delete(id);

        return ResponseEntity.status(delete.isSuccess() ? 201 : 409).body(delete);
    }


}
