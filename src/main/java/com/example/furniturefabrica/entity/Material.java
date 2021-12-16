package com.example.furniturefabrica.entity;

import com.example.furniturefabrica.entity.templete.AbsEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
public class Material extends AbsEntity {
    @Column(nullable = false, unique = true)
    private String code;
    private String nameRu, nameUz;

    private int normal;


    @OneToOne
    private Attachment attachment;


    @OneToOne
    private Measurement measurement;


}
