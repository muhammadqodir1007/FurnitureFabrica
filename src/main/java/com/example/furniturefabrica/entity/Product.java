package com.example.furniturefabrica.entity;

import com.example.furniturefabrica.entity.Attachment;
import com.example.furniturefabrica.entity.templete.AbsEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@EqualsAndHashCode(callSuper = true)
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Product extends AbsEntity {
    private String nameRu,nameUz;

    @OneToOne
    private Attachment attachment;
    @OneToOne
    private ProductType  productType;





}
