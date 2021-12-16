package com.example.furniturefabrica.payload;

import com.example.furniturefabrica.entity.ProductType;
import lombok.Data;

import javax.persistence.ManyToOne;

@Data
public class ProductTypeWareHouseDto {

    private String name;

    private Integer productTypeId;



    private double amount;

    private double overalPrice;








}
