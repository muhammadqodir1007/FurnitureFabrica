package com.example.furniturefabrica.service;

import com.example.furniturefabrica.entity.ProductType;
import com.example.furniturefabrica.entity.ProductWareHouse;
import com.example.furniturefabrica.entity.ProductWareHouseInput;
import com.example.furniturefabrica.payload.ApiResponse;
import com.example.furniturefabrica.payload.ProductTypeWareHouseDto;
import com.example.furniturefabrica.payload.ProductWareHouseInputDto;
import com.example.furniturefabrica.repositories.ProductTypeRepository;
import com.example.furniturefabrica.repositories.ProductWareHouseInputRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ProductWareHouseServiceInput {

    @Autowired
    ProductWareHouseInputRepository productWareHouseInputRepository;
    @Autowired
    ProductTypeRepository productTypeRepository;

    public ApiResponse add(ProductWareHouseInputDto productWareHouseInputDto) {
        ProductWareHouseInput productWareHouseInput = new ProductWareHouseInput();
        Optional<ProductType> byId = productTypeRepository.findById(productWareHouseInputDto.getProductTypeId());
        if (!byId.isPresent()) return new ApiResponse(" not found", false);

        ProductType productType = byId.get();
        productWareHouseInput.setProductType(productType);
        productWareHouseInput.setAmount(productWareHouseInputDto.getAmount());
        productWareHouseInput.setInputDate(new Date());
        productWareHouseInput.setAmount(productWareHouseInputDto.getAmount());
        productWareHouseInput.setPrice(productWareHouseInput.getPrice());
        productWareHouseInputRepository.save(productWareHouseInput);

        return new ApiResponse("success", true);


    }

    public ApiResponse edit(Integer id, ProductWareHouseInputDto productWareHouseInputDto) {
        Optional<ProductWareHouseInput> byId = productWareHouseInputRepository.findById(id);
        if (!byId.isPresent()) return new ApiResponse(" not found", false);

        ProductWareHouseInput productWareHouseInput = byId.get();
        Optional<ProductType> byId1 = productTypeRepository.findById(productWareHouseInputDto.getProductTypeId());
        if (!byId1.isPresent()) return new ApiResponse(" not found", false);

        ProductType productType = byId1.get();

        productWareHouseInput.setProductType(productType);
        productWareHouseInput.setAmount(productWareHouseInputDto.getAmount());
        productWareHouseInput.setInputDate(new Date());
        productWareHouseInput.setAmount(productWareHouseInputDto.getAmount());
        productWareHouseInput.setPrice(productWareHouseInput.getPrice());
        productWareHouseInputRepository.save(productWareHouseInput);

        return new ApiResponse("success", true);


    }

    public List<ProductWareHouseInput> getAll() {
        return productWareHouseInputRepository.findAll();


    }

    public ApiResponse getOne(Integer id) {

        Optional<ProductWareHouseInput> byId = productWareHouseInputRepository.findById(id);
        if (!byId.isPresent()) return new ApiResponse("not found", false);
        ProductWareHouseInput productWareHouseInput = byId.get();
        return new ApiResponse("success", true, productWareHouseInput);


    }

    public ApiResponse delete(Integer id) {

        Optional<ProductWareHouseInput> byId = productWareHouseInputRepository.findById(id);
        if (!byId.isPresent()) return new ApiResponse("not found", false);
        ProductWareHouseInput productWareHouseInput = byId.get();
        return new ApiResponse("success", true, productWareHouseInput);


    }


}
