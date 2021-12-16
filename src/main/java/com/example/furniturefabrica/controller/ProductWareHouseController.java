package com.example.furniturefabrica.controller;

import com.example.furniturefabrica.entity.ProductWareHouse;
import com.example.furniturefabrica.payload.ApiResponse;
import com.example.furniturefabrica.payload.ProductTypeWareHouseDto;
import com.example.furniturefabrica.service.ProductWareHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/productWareHouse")
public class ProductWareHouseController {

    @Autowired
    ProductWareHouseService productWareHouseService;


    @GetMapping("/list")
    public HttpEntity<?> getList() {
        List<ProductWareHouse> all = productWareHouseService.getAll();

        return ResponseEntity.status(201).body(all);


    }

    @PostMapping("/add")
    public HttpEntity<?> add(@RequestParam ProductTypeWareHouseDto productWareHouseDto) {
        ApiResponse add = productWareHouseService.add(productWareHouseDto);
        return ResponseEntity.status(add.isSuccess() ? 201 : 409).body(add);


    }

    @PutMapping("/edit/{id}")

    public HttpEntity<?> edit(Integer id, ProductTypeWareHouseDto productTypeWareHouseDto) {

        ApiResponse edit = productWareHouseService.edit(id, productTypeWareHouseDto);
        return ResponseEntity.status(edit.isSuccess() ? 201 : 409).body(edit);
    }

    @DeleteMapping("/delete/{id}")
    public HttpEntity<?> delete(Integer id) {
        ApiResponse delete = productWareHouseService.delete(id);


        return ResponseEntity.status(delete.isSuccess() ? 201 : 409).body(delete);


    }

    @GetMapping("/getOne/{id}")
    public HttpEntity<?> getOne(Integer id) {

        ApiResponse one = productWareHouseService.getOne(id);

        return ResponseEntity.status(one.isSuccess() ? 201 : 409).body(one);

    }


}
