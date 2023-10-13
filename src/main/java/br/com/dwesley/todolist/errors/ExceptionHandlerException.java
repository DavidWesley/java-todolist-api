package br.com.dwesley.todolist.errors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerException {
    /**
     * Handles the HttpMessageNotReadableException.
     *
     * @param err the HttpMessageNotReadableException to handle
     * @return the ResponseEntity with the error message
     */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<String> handleHttpMessageNotReadableException(HttpMessageNotReadableException err) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err.getMostSpecificCause().getMessage());
    }
}
