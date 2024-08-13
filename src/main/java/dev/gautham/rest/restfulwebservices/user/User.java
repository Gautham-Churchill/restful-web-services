package dev.gautham.rest.restfulwebservices.user;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class User {
    
    private Integer id;

    @Size(min = 2, message = "Name should have min 2 characters in length")
    private String name;

    @NotNull(message = "Birthdate can't be empty")
    @Past(message = "Birthdate can't be in future")
    private LocalDate birthDate;

}
