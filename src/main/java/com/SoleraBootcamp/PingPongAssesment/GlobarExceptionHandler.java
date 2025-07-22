package com.SoleraBootcamp.PingPongAssesment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobarExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handleMethodArgumentNotValid(MethodArgumentNotValidException ex){
        String errorMessage = ex.getBindingResult()
                               .getFieldErrors()
                               .stream()
                               .map(fieldError -> fieldError.getDefaultMessage())
                               .findFirst()
                               .orElse("Validation error");
        return ResponseEntity.badRequest().body(errorMessage);
    }

}
