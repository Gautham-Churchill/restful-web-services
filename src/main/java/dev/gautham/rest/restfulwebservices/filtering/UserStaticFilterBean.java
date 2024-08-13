package dev.gautham.rest.restfulwebservices.filtering;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserStaticFilterBean {

    private String userName;
    @JsonIgnore
    private String password;
    private String birthDate;
}
