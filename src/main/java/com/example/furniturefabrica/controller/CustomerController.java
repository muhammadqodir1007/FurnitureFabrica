package com.example.furniturefabrica.controller;

import com.example.furniturefabrica.entity.Customer;
import com.example.furniturefabrica.payload.ApiResponse;
import com.example.furniturefabrica.payload.CustomerDto;
import com.example.furniturefabrica.repositories.CustomerRepository;
import com.example.furniturefabrica.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/api/customer")
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CustomerService customerService;


    @GetMapping("/getList")
    public HttpEntity<?> getCustomer() {
        List<Customer> customerList = customerService.getCustomerList();

        return (HttpEntity<?>) customerList;


    }

    @GetMapping("/getOne/{id}")
    public HttpEntity<?> findById(@PathVariable Integer id) {


        ApiResponse byId = customerService.findById(id);


        return ResponseEntity.status(byId.isSuccess() ? 201 : 409).body(byId);


    }

    @PostMapping("/add")
    public HttpEntity<?> addCustomer(@RequestParam Customer customer) {
        ApiResponse apiResponse = customerService.addCustomer(customer);
        return ResponseEntity.status(apiResponse.isSuccess() ? 201 : 409).body(apiResponse);
    }

    @PutMapping("/edit/{id}")
    public HttpEntity<?> editCustomer(@PathVariable Integer id, @RequestParam Customer customer) {
        ApiResponse apiResponse = customerService.editCustomer(id, customer);

        return ResponseEntity.status(apiResponse.isSuccess() ? 201 : 409).body(apiResponse);

    }

    @DeleteMapping("/delete/{id}")
    public HttpEntity<?> deleteCustomer(@PathVariable Integer id) {
        ApiResponse apiResponse = customerService.deleteCustomer(id);

        return ResponseEntity.status(apiResponse.isSuccess() ? 201 : 409).body(apiResponse);


    }


}
