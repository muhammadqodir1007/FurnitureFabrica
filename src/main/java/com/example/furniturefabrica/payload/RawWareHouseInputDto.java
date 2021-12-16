package com.example.furniturefabrica.payload;

import com.example.furniturefabrica.entity.Product;
import com.example.furniturefabrica.entity.Supplier;
import lombok.Data;

import javax.persistence.ManyToOne;
import java.util.Date;

@Data
public class RawWareHouseInputDto {

    private Integer productId;

    private Integer supplierId;

    private double amount;

    private double price;

    private Date inputDate;
}
