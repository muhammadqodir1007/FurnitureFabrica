package com.example.furniturefabrica.controller;

import com.example.furniturefabrica.entity.RawMaterialOutPut;
import com.example.furniturefabrica.payload.ApiResponse;
import com.example.furniturefabrica.service.RawWareHouseInPutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class RawWareHouseInPutController {


    @Autowired
    RawWareHouseInPutService rawWareHouseInPutService;


    @GetMapping
    public HttpEntity<?> getAll() {

        List<RawMaterialOutPut> rawMaterialOutPuts = rawMaterialOutPutService.get();
        return ResponseEntity.status(201).body(rawMaterialOutPuts);

    }

    @GetMapping("/getOne/{id}")
    public HttpEntity<?> getOne(@PathVariable Integer id) {
        ApiResponse one = rawMaterialOutPutService.getOne(id);

        return ResponseEntity.status(one.isSuccess() ? 201 : 409).body(one);

    }

    @PostMapping("/add")
    public HttpEntity<?> add(@RequestParam RawMaterialOutPut rawMaterialOutPut) {
        ApiResponse add = rawMaterialOutPutService.add(rawMaterialOutPut);

        return ResponseEntity.status(add.isSuccess() ? 201 : 409).body(add);
    }

    @PutMapping("/edit")
    public HttpEntity<?> add(@PathVariable Integer id, @RequestParam RawMaterialOutPut rawMaterialOutPut) {
        ApiResponse edit = rawMaterialOutPutService.edit(id, rawMaterialOutPut);

        return ResponseEntity.status(edit.isSuccess() ? 201 : 409).body(edit);
    }

    @DeleteMapping("/delete/{id}")
    public HttpEntity<?> delete(@PathVariable Integer id) {

        ApiResponse delete = rawMaterialOutPutService.delete(id);

        return ResponseEntity.status(delete.isSuccess() ? 201 : 409).body(delete);
    }


}
