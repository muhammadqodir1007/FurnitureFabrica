package com.example.furniturefabrica.payload;

import lombok.Data;

@Data
public class ProductDto {

    private String nameRu,nameUz;

    private Integer attachmentId;

    private  Integer productTypeId;

}
