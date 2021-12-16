package com.example.furniturefabrica.payload;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class UserDto {
    @NotNull(message = "Firstname ni kiriting")
    private String firstname;
    @NotNull(message = "Lastname ni kiriting")
    private String lastname;
    @NotNull(message = "phone ni kiriting")
    private String phone;
    @NotNull(message = "username ni kiriting")
    private String username;
    @NotNull(message = "password ni kiriting")
    private String password;

    private Long roleId;
}
