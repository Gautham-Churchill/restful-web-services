package dev.gautham.rest.restfulwebservices.jpa.employee;

import java.util.List;

public interface EmployeeService {

    List<EmployeeEntity> findAllEmployees();

    EmployeeEntity findById(Integer id);

    EmployeeEntity saveEmployee(EmployeeEntity employee);

    EmployeeEntity updateEmployee(EmployeeEntity employee);

    void deleteEmployeeById(Integer id);
}
