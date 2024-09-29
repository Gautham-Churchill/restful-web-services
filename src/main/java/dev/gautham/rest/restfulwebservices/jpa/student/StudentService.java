package dev.gautham.rest.restfulwebservices.jpa.student;

import java.util.List;

public interface StudentService {

    StudentEntity findStudentById(Integer id);

    List<StudentEntity> findAllStudents();

    List<StudentEntity> findStudentsByLastName(String lastName);

    StudentEntity saveStudent(StudentEntity student);

    StudentEntity updateStudent(StudentEntity studentEntity);

    void deleteStudentById(Integer id);

    int deleteAllStudents();
}
