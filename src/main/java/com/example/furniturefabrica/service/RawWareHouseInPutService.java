package com.example.furniturefabrica.service;

import com.example.furniturefabrica.entity.Product;
import com.example.furniturefabrica.entity.RawMaterialOutPut;
import com.example.furniturefabrica.entity.RawWareHouseInput;
import com.example.furniturefabrica.entity.Supplier;
import com.example.furniturefabrica.payload.ApiResponse;
import com.example.furniturefabrica.payload.RawWareHouseInputDto;
import com.example.furniturefabrica.repositories.ProductRepository;
import com.example.furniturefabrica.repositories.RawWareInPutRepository;
import com.example.furniturefabrica.repositories.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RawWareHouseInPutService {
    @Autowired
    RawWareInPutRepository rawMaterialInPutRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    SupplierRepository supplierRepository;


    public ApiResponse add(RawWareHouseInputDto rawWareHouseInput) {
        RawWareHouseInput rawWareHouseInput1 = new RawWareHouseInput();
        rawWareHouseInput1.setInputDate(rawWareHouseInput.getInputDate());
        rawWareHouseInput1.setAmount(rawWareHouseInput.getAmount());
        rawWareHouseInput1.setPrice(rawWareHouseInput.getPrice());


        Optional<Product> byId = productRepository.findById(rawWareHouseInput.getProductId());
        if (!byId.isPresent()) return new ApiResponse("not found", false);
        Product product = byId.get();
        Optional<Supplier> optionalSupplier = supplierRepository.findById(rawWareHouseInput.getSupplierId());
        if (!optionalSupplier.isPresent()) return new ApiResponse("SUPLIER NOT FOUND", false);
        Supplier supplier = optionalSupplier.get();


        rawWareHouseInput1.setProduct(product);
        rawWareHouseInput1.setSupplier(supplier);
        rawMaterialInPutRepository.save(rawWareHouseInput1);

        return new ApiResponse("success", true);


    }

    public ApiResponse edit(Integer id, RawWareHouseInputDto rawWareHouseInput) {
        Optional<RawWareHouseInput> repositoryById = rawMaterialInPutRepository.findById(id);
        if (!repositoryById.isPresent()) return new ApiResponse("NOT FOUND", false);
        RawWareHouseInput rawWareHouseInput1 = repositoryById.get();
        rawWareHouseInput1.setInputDate(rawWareHouseInput.getInputDate());
        rawWareHouseInput1.setAmount(rawWareHouseInput.getAmount());
        rawWareHouseInput1.setPrice(rawWareHouseInput.getPrice());


        Optional<Product> byId = productRepository.findById(rawWareHouseInput.getProductId());
        if (!byId.isPresent()) return new ApiResponse("not found", false);
        Product product = byId.get();
        Optional<Supplier> optionalSupplier = supplierRepository.findById(rawWareHouseInput.getSupplierId());
        if (!optionalSupplier.isPresent()) return new ApiResponse("SUPLIER NOT FOUND", false);
        Supplier supplier = optionalSupplier.get();


        rawWareHouseInput1.setProduct(product);
        rawWareHouseInput1.setSupplier(supplier);
        rawMaterialInPutRepository.save(rawWareHouseInput1);

        return new ApiResponse("success", true);


    }

    public ApiResponse getOne(Integer id) {
        Optional<RawWareHouseInput> byId = rawMaterialInPutRepository.findById(id);
        if (!byId.isPresent()) return new ApiResponse("not found", false);
        RawWareHouseInput rawWareHouseInput = byId.get();
        return new ApiResponse("success", true, rawWareHouseInput);

    }

    public List<RawWareHouseInput> getAll() {
        return rawMaterialInPutRepository.findAll();
    }

    public ApiResponse delete(Integer id) {
        Optional<RawWareHouseInput> byId = rawMaterialInPutRepository.findById(id);
        if (!byId.isPresent()) return new ApiResponse("not found", false);
        rawMaterialInPutRepository.deleteById(id);
        return new ApiResponse("success", true);

    }
}