package com.buono.control.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class ErrorObject implements Serializable {

    private final String message;
    private final String field;
}
