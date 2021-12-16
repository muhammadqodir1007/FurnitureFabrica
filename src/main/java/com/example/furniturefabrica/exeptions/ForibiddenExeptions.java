package com.example.furniturefabrica.exeptions;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@EqualsAndHashCode(callSuper = true)
@Data
@ResponseStatus(HttpStatus.FORBIDDEN)
public class ForibiddenExeptions extends RuntimeException{

    private String type;
    private String message;

    public ForibiddenExeptions(String type, String message) {
        this.type = type;
        this.message = message;
    }


}
