package raven.webpos.handler;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import raven.webpos.exception.RequestValidationException;

import java.nio.file.AccessDeniedException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RequestValidationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionResponse handle(RequestValidationException exp) {
        return ExceptionResponse.builder()
                .error("Request not valid")
                .errorSource(exp.getViolationSource())
                .validationErrors(exp.getViolations())
                .build();
    }

    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ExceptionResponse handle(EntityNotFoundException exp) {
        return ExceptionResponse.builder()
                .error(exp.getMessage())
                .build();
    }

    @ExceptionHandler(AccessDeniedException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ExceptionResponse handle(AccessDeniedException exp) {
        return ExceptionResponse.builder()
                .error("Access denied")
                .build();
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ExceptionResponse handle(Exception exp) {
        return ExceptionResponse.builder()
                .error(exp.getMessage())
                .build();
    }
}
