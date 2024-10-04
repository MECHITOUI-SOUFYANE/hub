package com.alten.controller.advice;

import com.alten.exception.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerHandlerError {

    @ExceptionHandler
    public ResponseEntity<ApiErrorWrapper> handleKnowError(Exception exception) {
        int code = 500;
        String message = "Une erreur inattendue est survenue. Veuillez contacter votre administrateur";
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        if (exception instanceof ProductNotFoundException) {
            code = 404;
            status = HttpStatus.NOT_FOUND;
            message = exception.getMessage();
        }
        return new ResponseEntity<>(ApiErrorWrapper.builder()
                .code(code)
                .message(message)
                .build(), status);
    }


}
