package com.example.furniturefabrica.service;

import com.example.furniturefabrica.entity.Attachment;
import com.example.furniturefabrica.entity.Product;
import com.example.furniturefabrica.entity.ProductType;
import com.example.furniturefabrica.payload.ApiResponse;
import com.example.furniturefabrica.payload.ProductDto;
import com.example.furniturefabrica.repositories.AttachmentRepository;
import com.example.furniturefabrica.repositories.ProductRepository;
import com.example.furniturefabrica.repositories.ProductTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.PublicKey;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;


    @Autowired
    ProductTypeRepository productTypeRepository;

    @Autowired
    AttachmentRepository attachmentRepository;


    public ApiResponse addProduct(ProductDto productDto) {

        Product product = new Product();
        Optional<ProductType> byId = productTypeRepository.findById(productDto.getProductTypeId());

        if (!byId.isPresent()) return new ApiResponse("not found", false);
        ProductType productType = byId.get();
        product.setProductType(productType);
        Optional<Attachment> repositoryById = attachmentRepository.findById(productDto.getAttachmentId());
        if (!repositoryById.isPresent()) return new ApiResponse("not found", false);
        Attachment attachment = repositoryById.get();
        product.setAttachment(attachment);
        product.setNameRu(product.getNameRu());
        product.setNameUz(productDto.getNameUz());
        productRepository.save(product);
        return new ApiResponse("success", true);



    }

    public ApiResponse editProduct(Integer id ,ProductDto  productDto){
        Optional<Product> byId = productRepository.findById(id);
        if (!byId.isPresent()) return new ApiResponse("not found",false);
        Product product = byId.get();
        Optional<ProductType> byId1 = productTypeRepository.findById(productDto.getProductTypeId());

        if (!byId1.isPresent()) return new ApiResponse("not found", false);
        ProductType productType = byId1.get();
        product.setProductType(productType);
        Optional<Attachment> repositoryById = attachmentRepository.findById(productDto.getAttachmentId());
        if (!repositoryById.isPresent()) return new ApiResponse("not found", false);
        Attachment attachment = repositoryById.get();
        product.setAttachment(attachment);
        product.setNameRu(product.getNameRu());
        product.setNameUz(productDto.getNameUz());
        productRepository.save(product);
        return new ApiResponse("success", true);



    }


}
