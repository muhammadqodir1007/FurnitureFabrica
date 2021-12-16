package com.example.furniturefabrica.controller;

import com.example.furniturefabrica.entity.RawWareHouseInput;
import com.example.furniturefabrica.payload.ApiResponse;
import com.example.furniturefabrica.payload.RawWareHouseInputDto;
import com.example.furniturefabrica.service.RawWareHouseInPutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Controller
@RequestMapping("/api/rawWareHouseInput")
public class RawWareHouseInputController {


    @Autowired
    RawWareHouseInPutService rawWareHouseInPutService;


    @GetMapping("/getAll")
    public HttpEntity<?> getAll() {

        List<RawWareHouseInput> all = rawWareHouseInPutService.getAll();
        return ResponseEntity.ok().body(all);
    }

    @GetMapping("/getOne/{id}")
    public HttpEntity<?> getOne(@PathVariable Integer id) {
        ApiResponse one = rawWareHouseInPutService.getOne(id);
        return ResponseEntity.status(one.isSuccess() ? 201 : 409).body(one);
    }

    @PostMapping("/add")
    public HttpEntity<?> add(@RequestParam RawWareHouseInputDto rawWareHouseInputDto) {
        ApiResponse add = rawWareHouseInPutService.add(rawWareHouseInputDto);

        return ResponseEntity.status(add.isSuccess() ? 201 : 409).body(add);
    }

    @PutMapping("edit/{id}")
    public HttpEntity<?> edit(@PathVariable Integer id, @RequestParam RawWareHouseInputDto rawWareHouseInputDto) {
        ApiResponse edit = rawWareHouseInPutService.edit(id, rawWareHouseInputDto);

        return ResponseEntity.status(edit.isSuccess() ? 201 : 409).body(edit);
    }

    @DeleteMapping("delete/{id}")
    public HttpEntity<?> delete(@PathVariable Integer id) {
        ApiResponse delete = rawWareHouseInPutService.delete(id);
        return ResponseEntity.status(delete.isSuccess() ? 201 : 409).body(delete);

    }
}
