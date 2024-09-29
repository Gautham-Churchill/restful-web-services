package dev.gautham.rest.restfulwebservices.jpa.employee;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/** This entire code can be created by Spring data rest out of the box if the dependency is added in pom and the correct
    repository class is created like show in {@link dev.gautham.rest.restfulwebservices.jpa.employee.EmployeeRepository}
**/

@RestController
@RequiredArgsConstructor
@RequestMapping("/employees")
@Tag(name = "Employee APIs")
@Slf4j
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping
    public List<EmployeeEntity> getAllEmployees() {
        log.info("Get all employees");
        return employeeService.findAllEmployees();
    }

    @GetMapping("/{id}")
    public EmployeeEntity getEmployeeById(@PathVariable Integer id) {
        log.info("Get employee by id: {}", id);
        return employeeService.findById(id);
    }

    @PostMapping
    public EmployeeEntity saveEmployee(@RequestBody EmployeeEntity employee) {
        log.info("Saving employee");
        return employeeService.saveEmployee(employee);
    }

    @PutMapping
    public EmployeeEntity updateEmployee(@RequestBody EmployeeEntity employee) {
        log.info("Updating employee");
        return employeeService.saveEmployee(employee);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Integer id) {
        employeeService.deleteEmployeeById(id);
    }
}
