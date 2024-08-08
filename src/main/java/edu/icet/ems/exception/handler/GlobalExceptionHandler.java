package edu.icet.ems.exception.handler;

import edu.icet.ems.exception.EmployeeAlreadyExistException;
import edu.icet.ems.exception.EmployeeNotFoundException;
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

    private final String statusMessage;

    private GlobalExceptionHandler() {
        this.statusMessage = "failed";
    }

    @ExceptionHandler(EmployeeNotFoundException.class)
    ResponseEntity<ErrorResponse> handleCustomerNotFoundException(EmployeeNotFoundException ex) {
        log.debug("Employee Not Found Error {}", ex.getMessage());
        return ResponseEntity.ok().body(ErrorResponse.builder()
                .errorMessage(ex.getMessage()).status(statusMessage).build());
    }

    @ExceptionHandler(ParameterNotFoundException.class)
    ResponseEntity<ErrorResponse> handleParameterNotFoundException(ParameterNotFoundException ex) {
        log.debug("Parameter Not Found Error {}", ex.getMessage());
        return ResponseEntity.ok().body(ErrorResponse.builder()
                .errorMessage(ex.getMessage()).status(statusMessage).build());
    }

    @ExceptionHandler(EmployeeAlreadyExistException.class)
    ResponseEntity<ErrorResponse> handleEmployeeAlreadyExistException(EmployeeAlreadyExistException ex) {
        log.debug("Employee Already exist Exception threw | {}", ex.getMessage());
        return ResponseEntity.ok().body(ErrorResponse.builder()
                .errorMessage(ex.getMessage()).status(statusMessage).build());
    }
}
