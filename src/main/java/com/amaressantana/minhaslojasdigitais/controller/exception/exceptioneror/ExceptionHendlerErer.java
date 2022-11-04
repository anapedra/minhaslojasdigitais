package com.amaressantana.minhaslojasdigitais.controller.exception.exceptioneror;

import com.amaressantana.minhaslojasdigitais.controller.exception.standererroe.StanderError;
import com.amaressantana.minhaslojasdigitais.services.exeptions.EntityNotFoundExcepion;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;
@ControllerAdvice
public class ExceptionHendlerErer {
    @ExceptionHandler(EntityNotFoundExcepion.class)
    public ResponseEntity<StanderError> entityNotFound(EntityNotFoundExcepion e,  HttpServletRequest request){
        StanderError error =new StanderError();
        error.setTimestamp(Instant.now());
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setError("Resource not found");
        error.setMessage(e.getMessage());
        error.setPath(request.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
}
