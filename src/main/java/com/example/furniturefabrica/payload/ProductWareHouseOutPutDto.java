package com.example.furniturefabrica.payload;

import com.example.furniturefabrica.entity.Customer;
import com.example.furniturefabrica.entity.Product;
import com.example.furniturefabrica.entity.ProductType;
import lombok.Data;

import javax.persistence.ManyToOne


import java.util.Date;

@Data
public class ProductWareHouseOutPutDto {
    private Integer customerId;

    private Integer productTypeId;


    private Integer productId;


    private double amount;

    private double price;

    private Date outputDate;


}

