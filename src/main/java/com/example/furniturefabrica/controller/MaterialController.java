package com.example.furniturefabrica.controller;

import com.example.furniturefabrica.entity.Material;
import com.example.furniturefabrica.payload.ApiResponse;
import com.example.furniturefabrica.payload.MaterialDto;
import com.example.furniturefabrica.service.MaterialService;
import org.aspectj.weaver.ResolvedPointcutDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/material")
public class MaterialController {

    @Autowired
    MaterialService materialService;


    @GetMapping
    public ApiResponse getMaterial() {

        List<Material> materials = materialService.getMaterials();
        return new ApiResponse("success", true, materials);


    }

    @GetMapping("/getOne/{id}")
    public HttpEntity<?> getById(@PathVariable Integer id) {
        ApiResponse one = materialService.findOne(id);

        return ResponseEntity.status(one.isSuccess() ? 201 : 409).body(one);


    }

    @PostMapping("/addMaterial")
    public HttpEntity<?> addMaterial(@RequestParam MaterialDto materialDto) {
        ApiResponse apiResponse = materialService.addMaterial(materialDto);

        return ResponseEntity.status(apiResponse.isSuccess() ? 201 : 409).body(apiResponse);


    }

    @PutMapping("/editMaterial/{id}")

    public HttpEntity<?> editMaterial(@PathVariable Integer id, @RequestParam MaterialDto materialDto) {
        ApiResponse apiResponse = materialService.editMaterial(id, materialDto);

        return ResponseEntity.status(apiResponse.isSuccess() ? 201 : 409).body(apiResponse);


    }

    @DeleteMapping("/delete/{id}")

    public HttpEntity<?> deleteMaterial(@PathVariable Integer id) {


        ApiResponse apiResponse = materialService.deleteById(id);

        return ResponseEntity.status(apiResponse.isSuccess() ? 201 : 409).body(apiResponse);
    }


}
