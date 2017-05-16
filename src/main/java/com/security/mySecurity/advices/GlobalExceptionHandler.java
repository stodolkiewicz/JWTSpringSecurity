package com.security.mySecurity.advices;

import com.security.mySecurity.exceptions.ProfileNotFoundException;
import lombok.Data;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.NOT_FOUND;

/**
 * Created by Admin on 16/05/2017.
 */

@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(value = NOT_FOUND)
    @ExceptionHandler(ProfileNotFoundException.class)
    @ResponseBody
    public ErrorResponse profileNotFound(ProfileNotFoundException ex){
        return new ErrorResponse("USER_NOT_FOUND", ex.getMessage());
    }

    @Data
    public static class ErrorResponse {
        private final String code;
        private final String message;
    }
}
