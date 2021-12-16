package com.example.furniturefabrica.exeptions;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@AllArgsConstructor
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourseNotFoundExeption extends RuntimeException {

    private final String resourceName;
    private final String resourceField;
    private final Object object;
}
