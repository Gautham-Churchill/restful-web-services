package dev.gautham.rest.restfulwebservices.jpa.instructor;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class InstructorNotFoundException extends RuntimeException {

    public InstructorNotFoundException(String s) { super(s); }

}