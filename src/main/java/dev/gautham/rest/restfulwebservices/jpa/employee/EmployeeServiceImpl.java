package dev.gautham.rest.restfulwebservices.jpa.employee;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/** This entire code can be created by Spring data rest out of the box if the dependency is added in pom and the correct
repository class is created like show in {@link dev.gautham.rest.restfulwebservices.jpa.employee.EmployeeRepository}
**/

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    public List<EmployeeEntity> findAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public EmployeeEntity findById(Integer id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee with id: "+ id + " is not found"));
    }

    @Override
    public EmployeeEntity saveEmployee(EmployeeEntity employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public EmployeeEntity updateEmployee(EmployeeEntity employee) {
        EmployeeEntity existingEmployee = employeeRepository.findById(employee.getId())
                .orElseThrow(() -> new EmployeeNotFoundException("Employee with id: "+ employee.getId() + " is not found"));
        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());
        existingEmployee.setEmail(employee.getEmail());
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployeeById(Integer id) {
        employeeRepository.deleteById(id);
    }


}
