package dev.gautham.rest.restfulwebservices.jpa.employee;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
// to set custom url path for the controller
//@RepositoryRestResource(path = "employees")
@Tag(name = "Employee APIs")
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Integer> {
}
