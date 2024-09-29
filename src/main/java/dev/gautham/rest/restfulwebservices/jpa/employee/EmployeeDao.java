package dev.gautham.rest.restfulwebservices.jpa.employee;

import java.util.List;

public interface EmployeeDao {

    List<EmployeeEntity> findAll();

    EmployeeEntity save(EmployeeEntity employee);

    int deleteById(Integer id);
}
