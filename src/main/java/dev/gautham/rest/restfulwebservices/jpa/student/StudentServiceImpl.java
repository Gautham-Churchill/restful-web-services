package dev.gautham.rest.restfulwebservices.jpa.student;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class StudentServiceImpl implements StudentService {

    private final StudentDao studentDao;

    @Override
    public StudentEntity findStudentById(Integer id) {
        log.debug("Find Student by id: {}", id);
        return studentDao.findById(id).orElseThrow(() -> new StudentNotFoundException("Student with id " + id + " is not found"));
    }

    @Override
    public List<StudentEntity> findAllStudents() {
        log.debug("Find all students");
        return studentDao.findAll();
    }

    @Override
    public List<StudentEntity> findStudentsByLastName(String lastName) {
        log.debug("Find students by given last name: {}", lastName);
        return studentDao.findByLastName(lastName);
    }

    @Override
    @Transactional
    public StudentEntity saveStudent(StudentEntity student) {
        return studentDao.save(student);

    }

    @Override
    @Transactional
    public StudentEntity updateStudent(StudentEntity studentEntity) {
        return studentDao.update(studentEntity);
    }

    @Override
    @Transactional
    public void deleteStudentById(Integer id) {
        log.debug("Deleting student with id: {}", id);
        if(studentDao.deleteById(id)){
            log.info("Deleted student");
        } else {
            log.warn("No student with id {} is found", id);
        }
    }

    @Override
    @Transactional
    public int deleteAllStudents() {
        return studentDao.deleteAll();
    }
}
