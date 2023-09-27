package com.buono.control.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
public class ErrorResponse implements Serializable {

        private final String message;
        private final int code;
        private final String status;
        private final String objectName;
        private final List<ErrorObject> errors;

}
