package com.example.furniturefabrica.controller;

import com.example.furniturefabrica.entity.Supplier;
import com.example.furniturefabrica.payload.ApiResponse;
import com.example.furniturefabrica.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/supplier")
public class SupplierController {
    @Autowired

    SupplierService supplierService;

    @GetMapping("/list")
    public HttpEntity<?> getSuppliers() {
        ApiResponse supplier = supplierService.getSupplier();

        return ResponseEntity.status(supplier.isSuccess() ? 201 : 409).body(supplier);
    }

    @PostMapping("/add")
    public HttpEntity<?> addSupplier(@RequestParam Supplier supplier) {
        ApiResponse apiResponse = supplierService.addSuplier(supplier);
        return ResponseEntity.status(apiResponse.isSuccess() ? 201 : 409).body(apiResponse);


    }

    @PutMapping("/edit/{id}")
    public HttpEntity<?> editSupplier(@PathVariable Integer id, @RequestParam Supplier supplier) {

        ApiResponse apiResponse = supplierService.editSupplier(id, supplier);

        return ResponseEntity.status(apiResponse.isSuccess() ? 201 : 409).body(apiResponse);

    }

    @GetMapping("/getOne/{id}")
    public HttpEntity<?> getbyId(@PathVariable Integer id) {
        ApiResponse byId = supplierService.findById(id);

        return ResponseEntity.status(byId.isSuccess() ? 201 : 409).body(byId);


    }

    @DeleteMapping("/delete/{id}")
    public HttpEntity<?> deleteById(@PathVariable Integer id) {
        ApiResponse apiResponse = supplierService.deleteSupplier(id);
        return ResponseEntity.status(apiResponse.isSuccess() ? 201 : 409).body(apiResponse);

    }


}
