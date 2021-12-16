package com.example.furniturefabrica.service;

import com.example.furniturefabrica.entity.Supplier;
import com.example.furniturefabrica.payload.ApiResponse;
import com.example.furniturefabrica.repositories.SupplierRepository;
import com.sun.tools.javac.util.DefinedBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SupplierService {
    @Autowired
    SupplierRepository supplierRepository;


    public ApiResponse addSuplier(Supplier supplier) {

        Supplier supplier1 = new Supplier();
        supplier1.setName(supplier.getName());
        supplier1.setPhoneNumber(supplier.getPhoneNumber());
        supplierRepository.save(supplier1);
        return new ApiResponse("success", true);


    }

    public ApiResponse getSupplier() {
        List all = supplierRepository.findAll();
        return new ApiResponse("success", true, all);


    }

    public ApiResponse editSupplier(Integer id, Supplier supplier) {

        Optional<Supplier> byId = supplierRepository.findById(id);
        if (!byId.isPresent()) return new ApiResponse("not found", false);
        Supplier supplier1 = byId.get();
        supplier1.setPhoneNumber(supplier.getPhoneNumber());
        supplier1.setName(supplier.getName());
        supplierRepository.save(supplier1);
        return new ApiResponse("edited", true);


    }

    public ApiResponse deleteSupplier(Integer id) {
        Optional<Supplier> byId = supplierRepository.findById(id);
        if (!byId.isPresent()) return new ApiResponse("not found", false);
        supplierRepository.deleteById(id);

        return new ApiResponse("deleted", true);


    }

    public ApiResponse findById(Integer id) {
        Optional<Supplier> byId = supplierRepository.findById(id);
        return byId.map(supplier -> new ApiResponse("success", true, supplier)).orElseGet(() -> new ApiResponse("not found ", false));


    }


}
