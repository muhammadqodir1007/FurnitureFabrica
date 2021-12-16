package com.example.furniturefabrica.payload;

import com.example.furniturefabrica.entity.Attachment;
import com.example.furniturefabrica.entity.Measurement;
import lombok.Data;

import javax.persistence.OneToOne;

@Data
public class MaterialDto {

    private String code;


    private String nameRu, nameUz;

    private int normal;


    private Integer attachmentId;


    private Integer measurementId;

}
