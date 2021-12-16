package com.example.furniturefabrica.controller;

import com.example.furniturefabrica.aop.CheckPermissions;
import com.example.furniturefabrica.entity.User;
import com.example.furniturefabrica.payload.ApiResponse;
import com.example.furniturefabrica.payload.UserDto;
import com.example.furniturefabrica.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @CheckPermissions(huquq = "ADD_USER")
    @PostMapping
    public HttpEntity<?> addUser(@Valid @RequestBody UserDto userDto) {
        ApiResponse apiResponse = userService.addUser(userDto);
        return ResponseEntity.status(apiResponse.isSuccess() ? 201 : 409).body(apiResponse);
    }

    @CheckPermissions(huquq = "EDIT_USER")
    @PutMapping("/{id}")
    public HttpEntity<?> editUser(@Valid @PathVariable long id, @RequestBody UserDto userDto) {
        ApiResponse apiResponse = userService.editUser(userDto, id);
        return ResponseEntity.status(apiResponse.isSuccess() ? 201 : 409).body(apiResponse);
    }

    @PreAuthorize(value = "hasAnyAuthority('DELETE_USER')")
    @DeleteMapping("/{id}")
    public HttpEntity<?> deleteUser(@PathVariable long id) {
        ApiResponse apiResponse = userService.deleteUser(id);
        return ResponseEntity.status(apiResponse.isSuccess() ? 201 : 409).body(apiResponse);
    }

    @PreAuthorize(value = "hasAnyAuthority('VIEW_USER')")
    @GetMapping("/{id}")
    public HttpEntity<?> getOne(@PathVariable long id) {
        ApiResponse apiResponse = userService.getOne(id);
        return ResponseEntity.status(apiResponse.isSuccess() ? 201 : 409).body(apiResponse);
    }

    @PreAuthorize(value = "hasAnyAuthority('VIEW_USER')")
    @GetMapping
    public HttpEntity<?> getall() {
        List<User> getall = userService.getall();
        return ResponseEntity.ok(getall);

    }
}
