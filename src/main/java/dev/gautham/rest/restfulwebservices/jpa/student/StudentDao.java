package dev.gautham.rest.restfulwebservices.jpa.student;

import java.util.List;
import java.util.Optional;

public interface StudentDao {

    Optional<StudentEntity> findById(Integer id);

    List<StudentEntity> findAll();

    List<StudentEntity> findByLastName(String theLastName);

    StudentEntity save(StudentEntity student);

    StudentEntity update(StudentEntity studentEntity);

    boolean deleteById(Integer id);

    int deleteAll();
}
