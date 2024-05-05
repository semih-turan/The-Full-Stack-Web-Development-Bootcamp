package dev.patika.librarymanagementapi.v1.core.config;

import dev.patika.librarymanagementapi.v1.core.exception.NotFoundException;
import dev.patika.librarymanagementapi.v1.core.result.Result;
import dev.patika.librarymanagementapi.v1.core.utils.ResultHelper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.validation.FieldError;


import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleValidationErrors(MethodArgumentNotValidException ex){

        List<String> validationErrorList = ex.getBindingResult().getFieldErrors().stream()
                .map(FieldError::getDefaultMessage).collect(Collectors.toList());

        return new ResponseEntity<>(ResultHelper.ERROR(validationErrorList), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Result> handleNotFoundException(NotFoundException ex){
        return new ResponseEntity<>(ResultHelper.NOT_FOUND(), HttpStatus.NOT_FOUND);
    }
}

