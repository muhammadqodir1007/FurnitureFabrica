package com.example.furniturefabrica.service;

import com.example.furniturefabrica.entity.Customer;
import com.example.furniturefabrica.payload.ApiResponse;
import com.example.furniturefabrica.repositories.CustomerRepository;
import com.sun.tools.javac.util.DefinedBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;


    public List<Customer> getCustomerList() {
        List<Customer> all = customerRepository.findAll();
        return all;


    }

    public ApiResponse findById(Integer id) {
        Optional<Customer> byId = customerRepository.findById(id);
        if (!byId.isPresent()) return new ApiResponse("not found", false);
        Customer customer = byId.get();
        return new ApiResponse("success", true, customer);

    }


    public ApiResponse addCustomer(Customer customer) {
        Customer customer1 = new Customer();
        customer1.setPhoneNumber(customer.getPhoneNumber());
        customer1.setName(customer.getName());
        customerRepository.save(customer1);
        return new ApiResponse("success", true);

    }

    public ApiResponse editCustomer(Integer id, Customer customer) {
        Optional<Customer> byId = customerRepository.findById(id);
        if (!byId.isPresent()) return new ApiResponse("not found ", false);
        Customer customer1 = byId.get();
        customer1.setName(customer.getName());
        customer1.setPhoneNumber(customer.getPhoneNumber());
        customerRepository.save(customer1);
        return new ApiResponse("success", true);


    }

    public ApiResponse deleteCustomer(Integer id) {

        Optional<Customer> byId = customerRepository.findById(id);
        if (!byId.isPresent()) return new ApiResponse("not found ", false);

        customerRepository.deleteById(id);
        return new ApiResponse("success", true);

    }
}
