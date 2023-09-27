package com.buono.control.exception;

import lombok.Data;

@Data
public class StandardError {

    private Integer status;
    private String error;
    private String message;
}
