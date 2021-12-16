package com.example.furniturefabrica.payload;

import com.example.furniturefabrica.entity.ProductType;
import lombok.Data;

import java.util.Date;

@Data
public class ProductWareHouseInputDto {
    private Integer productTypeId;


    private double amount;

    private  double price;

    private Date inputDate;
}
