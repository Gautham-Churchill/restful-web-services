package dev.gautham.rest.restfulwebservices.jpa.student;

import java.util.List;
import java.util.Optional;

public interface StudentDao {

    Optional<StudentEntity> findById(Integer id);

    List<StudentEntity> findAll();

    List<StudentEntity> findByLastName(String theLastName);

    void save(StudentEntity student);

    void update(StudentEntity studentEntity);

    boolean deleteById(Integer id);

    int deleteAll();
}
