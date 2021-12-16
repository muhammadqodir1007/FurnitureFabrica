package com.example.furniturefabrica.service;

import com.example.furniturefabrica.entity.Customer;
import com.example.furniturefabrica.entity.Product;
import com.example.furniturefabrica.entity.ProductType;
import com.example.furniturefabrica.entity.ProductWareHouseOutPut;
import com.example.furniturefabrica.payload.ApiResponse;
import com.example.furniturefabrica.payload.ProductWareHouseOutPutDto;
import com.example.furniturefabrica.repositories.CustomerRepository;
import com.example.furniturefabrica.repositories.ProductRepository;
import com.example.furniturefabrica.repositories.ProductTypeRepository;
import com.example.furniturefabrica.repositories.ProductWareHouseOutPutRepostiory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductWareHouseOutputService {
    @Autowired
    ProductWareHouseOutPutRepostiory productWareHouseOutPutRepostiory;

    @Autowired
    CustomerRepository customerRepository;


    @Autowired
    ProductTypeRepository productTypeRepository;

    @Autowired
    ProductRepository productRepository;


    public ApiResponse add(ProductWareHouseOutPutDto productWareHouseOutPutDto) {

        ProductWareHouseOutPut productWareHouseOutPut = new ProductWareHouseOutPut();
        Optional<ProductType> byId = productTypeRepository.findById(productWareHouseOutPutDto.getProductTypeId());
        if (!byId.isPresent()) return new ApiResponse("not found", false);
        ProductType productType = byId.get();
        Optional<Product> productOptional = productRepository.findById(productWareHouseOutPutDto.getProductId());
        if (!productOptional.isPresent()) return new ApiResponse("product not found", false);
        Product product = productOptional.get();

        Optional<Customer> customerOptional = customerRepository.findById(productWareHouseOutPutDto.getCustomerId());
        if (!customerOptional.isPresent()) return new ApiResponse("customer not found ", false);
        Customer customer = customerOptional.get();

        productWareHouseOutPut.setProduct(product);
        productWareHouseOutPut.setProductType(productType);
        productWareHouseOutPut.setAmount(productWareHouseOutPutDto.getAmount());
        productWareHouseOutPut.setOutputDate(productWareHouseOutPutDto.getOutputDate());
        productWareHouseOutPut.setCustomer(customer);
        productWareHouseOutPut.setPrice(productWareHouseOutPutDto.getPrice());
        productWareHouseOutPutRepostiory.save(productWareHouseOutPut);
        return new ApiResponse("saved", true);

    }

    public ApiResponse edit(Integer id, ProductWareHouseOutPutDto productWareHouseOutPutDto) {
        Optional<ProductWareHouseOutPut> mains = productWareHouseOutPutRepostiory.findById(id);
        if (!mains.isPresent()) return new ApiResponse("not found", false);
        ProductWareHouseOutPut productWareHouseOutPut = mains.get();
        Optional<ProductType> byId = productTypeRepository.findById(productWareHouseOutPutDto.getProductTypeId());
        if (!byId.isPresent()) return new ApiResponse("not found", false);
        ProductType productType = byId.get();
        Optional<Product> productOptional = productRepository.findById(productWareHouseOutPutDto.getProductId());
        if (!productOptional.isPresent()) return new ApiResponse("product not found", false);
        Product product = productOptional.get();

        Optional<Customer> customerOptional = customerRepository.findById(productWareHouseOutPutDto.getCustomerId());
        if (!customerOptional.isPresent()) return new ApiResponse("customer not found ", false);
        Customer customer = customerOptional.get();

        productWareHouseOutPut.setProduct(product);
        productWareHouseOutPut.setProductType(productType);
        productWareHouseOutPut.setAmount(productWareHouseOutPutDto.getAmount());
        productWareHouseOutPut.setOutputDate(productWareHouseOutPutDto.getOutputDate());
        productWareHouseOutPut.setCustomer(customer);
        productWareHouseOutPut.setPrice(productWareHouseOutPutDto.getPrice());
        productWareHouseOutPutRepostiory.save(productWareHouseOutPut);
        return new ApiResponse("saved", true);


    }

    public List<ProductWareHouseOutPut> getAll() {
        return productWareHouseOutPutRepostiory.findAll();


    }

    public ApiResponse getOne(Integer id) {
        Optional<ProductWareHouseOutPut> byId = productWareHouseOutPutRepostiory.findById(id);
        if (!byId.isPresent()) return new ApiResponse("not found ", false);
        ProductWareHouseOutPut productWareHouseOutPut = byId.get();
        return new ApiResponse("success", true, productWareHouseOutPut);


    }

    public ApiResponse delete(Integer id) {
        Optional<ProductWareHouseOutPut> byId = productWareHouseOutPutRepostiory.findById(id);
        if (!byId.isPresent()) return new ApiResponse("not found ", false);
        productWareHouseOutPutRepostiory.deleteById(id);


        return new ApiResponse("deleted", true);


    }


}
