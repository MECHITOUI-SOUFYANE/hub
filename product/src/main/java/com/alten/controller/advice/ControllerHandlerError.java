package com.alten.controller.advice;

import com.alten.configuration.LocalResolverConfiguration;
import com.alten.exception.ProductNotFoundException;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.*;


@ControllerAdvice
public class ControllerHandlerError {

    private final static Logger LOGGER = LoggerFactory.getLogger(ControllerHandlerError.class);

    @ExceptionHandler
    public ResponseEntity<ApiErrorWrapper> handleKnowError(Exception exception) {
        int code = 500;
        String message = LocalResolverConfiguration.getMessage("global.message.error");
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        if (exception instanceof ProductNotFoundException) {
            code = 404;
            status = HttpStatus.NOT_FOUND;
            message = exception.getMessage();
        } else {
            LOGGER.error(exception.getMessage(), exception);
        }
        return new ResponseEntity<>(ApiErrorWrapper.builder()
                .code(code)
                .messages(Collections.singletonList(message))
                .build(), status);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiErrorWrapper> handleValidationExceptions(MethodArgumentNotValidException ex) {
        ApiErrorWrapper apiErrorWrapper = ApiErrorWrapper.builder().code(HttpStatus.BAD_REQUEST.value()).messages(new ArrayList<>()).build();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String objectName = ((FieldError) error).getObjectName();
            apiErrorWrapper.messages().add(String.join(StringUtils.SPACE,objectName+"."+fieldName,error.getDefaultMessage()));
        });
        return new ResponseEntity<>(apiErrorWrapper,HttpStatus.BAD_REQUEST);
    }


}
