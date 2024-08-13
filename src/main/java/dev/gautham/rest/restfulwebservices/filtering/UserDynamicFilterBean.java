package dev.gautham.rest.restfulwebservices.filtering;

import com.fasterxml.jackson.annotation.JsonFilter;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@JsonFilter("userBeanFilter")
public class UserDynamicFilterBean {

    private String userName;
    private String password;
    private String birthDate;

}
