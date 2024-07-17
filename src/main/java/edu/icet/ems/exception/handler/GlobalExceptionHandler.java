package edu.icet.ems.exception.handler;

import edu.icet.ems.exception.CustomerNotFoundException;
import edu.icet.ems.exception.ParameterNotFoundException;
import edu.icet.ems.model.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(CustomerNotFoundException.class)
    ResponseEntity<ErrorResponse> handleCustomerNotFoundException(CustomerNotFoundException ex) {
        log.debug("Customer Not Found Error {}", ex.getMessage());
        return ResponseEntity.ok().body(ErrorResponse.builder()
                .errorMessage(ex.getMessage()).status("failed").build());
    }

    @ExceptionHandler(ParameterNotFoundException.class)
    ResponseEntity<ErrorResponse> handleParameterNotFoundException(ParameterNotFoundException ex) {
        log.debug("Parameter Not Found Error {}", ex.getMessage());
        return ResponseEntity.ok().body(ErrorResponse.builder()
                .errorMessage(ex.getMessage()).status("failed").build());
    }
}
