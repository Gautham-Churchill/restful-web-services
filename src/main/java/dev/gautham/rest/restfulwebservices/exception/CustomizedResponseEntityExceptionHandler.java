package dev.gautham.rest.restfulwebservices.exception;

import dev.gautham.rest.restfulwebservices.jpa.employee.EmployeeNotFoundException;
import dev.gautham.rest.restfulwebservices.jpa.student.StudentNotFoundException;
import dev.gautham.rest.restfulwebservices.user.UserNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;


@ControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ErrorDetails> handleAllExceptions(Exception ex, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(),
                ex.getMessage(), request.getDescription(false));

        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler({UserNotFoundException.class, StudentNotFoundException.class, EmployeeNotFoundException.class})
    public final ResponseEntity<ErrorDetails> handleUserNotFoundException(Exception ex, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(),
                ex.getMessage(), request.getDescription(false));

        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                        HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        String errorMessage = ex.getFieldError() != null? ex.getFieldError().getDefaultMessage() : "";
        ErrorDetails er = new ErrorDetails(LocalDateTime.now(), errorMessage, request.getDescription(false));

        return new ResponseEntity<>(er, HttpStatus.BAD_REQUEST);
    }

}