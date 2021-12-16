package com.example.furniturefabrica.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductWareHouseOutPut {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    private Customer customer;
    @ManyToOne
    private ProductType productType;

    @ManyToOne
    private Product product;


    private double amount;

    private  double price;

    private Date outputDate;
    


}
