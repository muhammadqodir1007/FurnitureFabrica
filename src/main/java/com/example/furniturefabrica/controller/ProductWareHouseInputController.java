package com.example.furniturefabrica.controller;

import com.example.furniturefabrica.entity.ProductWareHouse;
import com.example.furniturefabrica.entity.ProductWareHouseInput;
import com.example.furniturefabrica.payload.ApiResponse;
import com.example.furniturefabrica.payload.ProductTypeWareHouseDto;
import com.example.furniturefabrica.payload.ProductWareHouseInputDto;
import com.example.furniturefabrica.service.ProductWareHouseService;
import com.example.furniturefabrica.service.ProductWareHouseServiceInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/productWareHouseInput")
public class ProductWareHouseInputController {


    @Autowired
    ProductWareHouseServiceInput productWareHouseServiceInput;


    @GetMapping
    public HttpEntity<?> getList() {
        List<ProductWareHouseInput> all = productWareHouseServiceInput.getAll();

        return ResponseEntity.status(201).body(all);


    }

    @PostMapping("/getOne/{id}")
    public HttpEntity<?> getOne(@PathVariable Integer id) {
        ApiResponse one = productWareHouseServiceInput.getOne(id);


        return ResponseEntity.status(one.isSuccess() ? 201 : 409).body(one);


    }

    @PutMapping
    public HttpEntity<?> edit(@PathVariable Integer id, @RequestParam ProductWareHouseInputDto productWareHouseInputDto) {

        ApiResponse edit = productWareHouseServiceInput.edit(id, productWareHouseInputDto);

        return ResponseEntity.status(edit.isSuccess() ? 201 : 409).body(edit);

    }

    @DeleteMapping("/delete/{id}")
    public HttpEntity<?> delete(@PathVariable Integer id) {


        ApiResponse delete = productWareHouseServiceInput.delete(id);

        return ResponseEntity.status(delete.isSuccess() ? 201 : 409).body(delete);

    }

    @GetMapping("/getOne/{id}")

    public HttpEntity<?> getById(@PathVariable Integer id) {
        ApiResponse one = productWareHouseServiceInput.getOne(id);

        return ResponseEntity.status(one.isSuccess() ? 201 : 409).body(one);
    }


}