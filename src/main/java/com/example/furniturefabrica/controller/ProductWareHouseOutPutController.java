package com.example.furniturefabrica.controller;

import com.example.furniturefabrica.entity.ProductWareHouseOutPut;
import com.example.furniturefabrica.payload.ApiResponse;
import com.example.furniturefabrica.payload.ProductWareHouseOutPutDto;
import com.example.furniturefabrica.service.ProductWareHouseOutputService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/productWareHouseOutput")
public class ProductWareHouseOutPutController {

    @Autowired
    ProductWareHouseOutputService productWareHouseOutputService;

    @GetMapping

    public HttpEntity<?> getAll() {

        List<ProductWareHouseOutPut> all = productWareHouseOutputService.getAll();

        return ResponseEntity.status(201).body(all);

    }

    @PostMapping("/add")

    public HttpEntity<?> add(@RequestParam ProductWareHouseOutPutDto productWareHouseOutPutDto) {
        ApiResponse add = productWareHouseOutputService.add(productWareHouseOutPutDto);

        return ResponseEntity.status(add.isSuccess() ? 201 : 409).body(add);
    }

    @PutMapping("/edit/{id}")
    public HttpEntity<?> edit(@PathVariable Integer id, @RequestParam ProductWareHouseOutPutDto productWareHouseOutPutDto) {
        ApiResponse edit = productWareHouseOutputService.edit(id, productWareHouseOutPutDto);
        return ResponseEntity.status(edit.isSuccess() ? 201 : 409).body(edit);

    }

    @GetMapping("/getOne/{id}")
    public HttpEntity<?> getOne(@PathVariable Integer id) {
        ApiResponse one = productWareHouseOutputService.getOne(id);
        return ResponseEntity.status(one.isSuccess() ? 201 : 409).body(one);

    }

    @DeleteMapping("/delete/{id}")
    public HttpEntity<?> delete(@PathVariable Integer id) {
        ApiResponse delete = productWareHouseOutputService.delete(id);

        return ResponseEntity.status(delete.isSuccess() ? 201 : 409).body(delete);


    }

}
