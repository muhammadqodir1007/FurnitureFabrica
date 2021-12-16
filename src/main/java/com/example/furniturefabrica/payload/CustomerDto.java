package com.example.furniturefabrica.payload;

import jdk.internal.jline.internal.Nullable;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class CustomerDto {
    @NotNull
    private String name;
    @NotNull
    private String phoneNumber;
}
