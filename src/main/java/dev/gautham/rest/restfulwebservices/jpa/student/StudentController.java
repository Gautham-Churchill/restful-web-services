package dev.gautham.rest.restfulwebservices.jpa.student;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
@Tag(name = "Student APIs")
@Slf4j
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/{id}")
    public StudentEntity getStudent(@PathVariable Integer id) {
        log.info("Get student by id: {}", id);
        return studentService.findStudentById(id);
    }

    @GetMapping
    public List<StudentEntity> getAllStudents() {
        log.info("Get all students");
        return studentService.findAllStudents();
    }

    @GetMapping("/findByLastName")
    public List<StudentEntity> getStudentsByLastName(@RequestParam String lastName) {
        log.info("Get students by last name: {}", lastName);
        return studentService.findStudentsByLastName(lastName);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public StudentEntity saveStudent(@RequestBody StudentEntity studentEntity) {
        log.info("Saving Student");
        return studentService.saveStudent(studentEntity);
    }

    @PutMapping
    public StudentEntity updateStudent(@RequestBody StudentEntity studentEntity) {
        log.info("Updating Student");
        return studentService.updateStudent(studentEntity);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Integer id) {
        log.info("Deleting student with id: {}", id);
        studentService.deleteStudentById(id);
    }

    @DeleteMapping
    public int deleteAllStudents() {
        log.info("Deleting all students");
        return studentService.deleteAllStudents();
    }


}
