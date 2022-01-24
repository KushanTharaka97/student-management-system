package com.sms.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
@Getter
public class ResourceNotFoundException extends RuntimeException{
    private String resource;
    private String field;
    private Object type;

    public ResourceNotFoundException(String resource, String field, Object type) {
        super(String.format("%s not found %s: %s", resource, field, type));
        this.resource = resource;
        this.field = field;
        this.type = type;
    }

}
