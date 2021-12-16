package com.example.furniturefabrica.controller;

import com.example.furniturefabrica.entity.Measurement;
import com.example.furniturefabrica.payload.ApiResponse;
import com.example.furniturefabrica.service.MeasurementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/measurement")
public class MeasurementController {
    @Autowired
    MeasurementService measurementService;


    @GetMapping("/list")

    public HttpEntity<?> getAll() {
        List<Measurement> all =
                measurementService.getAll();
        return ResponseEntity.status(409).body(all);

    }

    @GetMapping("/getOne/{id}")
    public HttpEntity<?> getOne(@PathVariable Integer id) {

        ApiResponse one = measurementService.getOne(id);
        return ResponseEntity.status(one.isSuccess() ? 201 : 409).body(one);
    }

    @PostMapping("/add")

    public HttpEntity<?> addMeasurement(@RequestParam Measurement measurement) {
        ApiResponse apiResponse = measurementService.addMeasurement(measurement);
        return ResponseEntity.status(apiResponse.isSuccess() ? 201 : 409).body(apiResponse);


    }

    @DeleteMapping("/delete/{id}")
    public HttpEntity<?> delete(@PathVariable Integer id) {
        ApiResponse delete = measurementService.delete(id);

        return ResponseEntity.status(delete.isSuccess() ? 201 : 409).body(delete);


    }

    @PutMapping("/edit/{id}")
    public HttpEntity<?> edit(@PathVariable Integer id, @RequestParam Measurement measurement) {
        ApiResponse edit = measurementService.edit(id, measurement);
        return ResponseEntity.status(edit.isSuccess() ? 201 : 409).body(edit);


    }


}
