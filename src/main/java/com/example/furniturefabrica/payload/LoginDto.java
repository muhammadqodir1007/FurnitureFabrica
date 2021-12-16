package com.example.furniturefabrica.payload;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class LoginDto {
    @NotNull(message = "username bo'sh bolamsin")
    private String userName;
    @NotNull(message = "password bosh bolmasin")
    private String password;
}
