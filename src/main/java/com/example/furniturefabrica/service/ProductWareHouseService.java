package com.example.furniturefabrica.service;

import com.example.furniturefabrica.entity.ProductType;
import com.example.furniturefabrica.entity.ProductWareHouse;
import com.example.furniturefabrica.payload.ApiResponse;
import com.example.furniturefabrica.payload.ProductTypeWareHouseDto;
import com.example.furniturefabrica.repositories.ProductTypeRepository;
import com.example.furniturefabrica.repositories.ProductWareHouseRepository;
import com.sun.tools.javac.util.DefinedBy;
import org.graalvm.compiler.lir.alloc.lsra.LinearScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductWareHouseService {

    @Autowired
    ProductWareHouseRepository productWareHouseRepository;

    @Autowired
    ProductTypeRepository productTypeRepository;


    public ApiResponse add(ProductTypeWareHouseDto productTypeWareHouseDto) {
        ProductWareHouse productWareHouse1 = new ProductWareHouse();
        Optional<ProductType> byId = productTypeRepository.findById(productTypeWareHouseDto.getProductTypeId());
        if (!byId.isPresent()) return new ApiResponse("not found", false);
        ProductType productType = byId.get();
        productWareHouse1.setProductType(productType);
        productWareHouse1.setName(productTypeWareHouseDto.getName());
        productWareHouse1.setAmount(productTypeWareHouseDto.getAmount());
        productWareHouse1.setOveralPrice(productWareHouse1.getOveralPrice());
        ProductWareHouse save = productWareHouseRepository.save(productWareHouse1);
        return new ApiResponse("success", true);

    }


    public ApiResponse edit(Integer id, ProductTypeWareHouseDto productTypeWareHouseDto) {
        Optional<ProductWareHouse> byId1 = productWareHouseRepository.findById(id);
        if (!byId1.isPresent()) return new ApiResponse("not found ", false);
        ProductWareHouse productWareHouse1 = byId1.get();
        Optional<ProductType> byId = productTypeRepository.findById(productTypeWareHouseDto.getProductTypeId());
        if (!byId.isPresent()) return new ApiResponse("not found", false);
        ProductType productType = byId.get();
        productWareHouse1.setProductType(productType);
        productWareHouse1.setName(productTypeWareHouseDto.getName());
        productWareHouse1.setAmount(productTypeWareHouseDto.getAmount());
        productWareHouse1.setOveralPrice(productWareHouse1.getOveralPrice());
        ProductWareHouse save = productWareHouseRepository.save(productWareHouse1);
        return new ApiResponse("success", true);


    }

    public ApiResponse getOne(Integer id) {

        Optional<ProductWareHouse> byId = productWareHouseRepository.findById(id);
        if (!byId.isPresent()) return new ApiResponse("not found", true);
        ProductWareHouse productWareHouse = byId.get();

        return new ApiResponse("success", true, productWareHouse);


    }

    public List<ProductWareHouse> getAll() {

        return productWareHouseRepository.findAll();


    }

    public ApiResponse delete(Integer id) {
        productWareHouseRepository.deleteById(id);

        return new ApiResponse("success", true);


    }
}
