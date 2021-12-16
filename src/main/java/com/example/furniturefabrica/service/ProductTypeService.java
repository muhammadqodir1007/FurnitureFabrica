package com.example.furniturefabrica.service;

import com.example.furniturefabrica.entity.ProductType;
import com.example.furniturefabrica.payload.ApiResponse;
import com.example.furniturefabrica.repositories.ProductTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductTypeService {

    @Autowired
    ProductTypeRepository productTypeRepository;


    public ApiResponse add(ProductType productType) {

        ProductType productType1 = new ProductType();

        productType1.setNameRu(productType.getNameRu());
        productType1.setNameUz(productType.getNameUz());
        productTypeRepository.save(productType1);
        return new ApiResponse("added", true);
    }

    public ApiResponse edit(Integer id, ProductType productType) {

        Optional<ProductType> byId = productTypeRepository.findById(id);
        if (!byId.isPresent()) return new ApiResponse("not found", false);
        ProductType productType1 = byId.get();
        productType1.setNameRu(productType.getNameRu());
        productType1.setNameUz(productType1.getNameUz());

        productTypeRepository.save(productType1);
        return new ApiResponse("success", true);


    }

    public List<ProductType> getList() {

        return productTypeRepository.findAll();
    }

    public ApiResponse getOne(Integer id) {

        Optional<ProductType> byId = productTypeRepository.findById(id);
        if (!byId.isPresent()) return new ApiResponse("not found", false);
        ProductType productType = byId.get();

        return new ApiResponse("success", true, productType);
    }

    public ApiResponse delete(Integer id) {
        productTypeRepository.deleteById(id);
        return new ApiResponse("success", true);


    }

}
