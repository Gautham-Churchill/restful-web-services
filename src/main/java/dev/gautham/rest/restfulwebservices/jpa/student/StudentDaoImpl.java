package dev.gautham.rest.restfulwebservices.jpa.student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class StudentDaoImpl implements StudentDao {

    private final EntityManager en;

    @Override
    public Optional<StudentEntity> findById(Integer id) {
        return Optional.ofNullable(en.find(StudentEntity.class, id));
    }

    @Override
    public List<StudentEntity> findAll() {
        TypedQuery<StudentEntity> query = en.createQuery("FROM StudentEntity s order by s.id", StudentEntity.class);
        return query.getResultList();
    }

    @Override
    public List<StudentEntity> findByLastName(String theLastName) {
        TypedQuery<StudentEntity> query = en.createQuery("FROM StudentEntity WHERE lower(lastName)=lower(:theLastName) ORDER BY firstName", StudentEntity.class);
        query.setParameter("theLastName", theLastName);
        return query.getResultList();
    }

    @Override
    public StudentEntity save(StudentEntity student) {
        return en.merge(student);
    }

    @Override
    public StudentEntity update(StudentEntity studentEntity) {
        StudentEntity student = findById(studentEntity.getId()).orElseThrow(() -> new StudentNotFoundException("Student with id " + studentEntity.getId() + " is not found"));
        student.setFirstName(studentEntity.getFirstName());
        student.setLastName(studentEntity.getLastName());
        student.setEmail(studentEntity.getEmail());
        return en.merge(student);
    }

    @Override
    public boolean deleteById(Integer id) {
        Optional<StudentEntity> student = findById(id);
        student.ifPresent(en::remove);
        return student.isPresent();
    }

    @Override
    public int deleteAll() {
        return en.createQuery("DELETE FROM StudentEntity").executeUpdate();
    }
}
