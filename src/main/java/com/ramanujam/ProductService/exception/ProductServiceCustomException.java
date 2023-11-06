package com.ramanujam.ProductService.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class ProductServiceCustomException extends RuntimeException{
    private String errorCode;

    public ProductServiceCustomException(String message, String errorCode)
    {
        //Get the message from RuntimeException
        super(message);
        this.errorCode = errorCode;
    }

}
