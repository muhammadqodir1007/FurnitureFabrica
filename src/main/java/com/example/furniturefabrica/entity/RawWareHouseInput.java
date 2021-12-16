package com.example.furniturefabrica.entity;

import com.example.furniturefabrica.entity.templete.AbsEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.util.Date;
@EqualsAndHashCode(callSuper = true)
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data


public class RawWareHouseInput extends AbsEntity {
    @ManyToOne
    private Product product;
    @ManyToOne
    private Supplier supplier;

    private double amount;

    private double price;

    private Date inputDate;



}
