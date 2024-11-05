package dev.gautham.rest.restfulwebservices.filtering;

import com.fasterxml.jackson.annotation.JsonFilter;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@JsonFilter("addressFilter")
public class Address {

    private String street;
    private String city;

}
