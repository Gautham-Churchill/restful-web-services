package dev.gautham.rest.restfulwebservices.jpa.instructor;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface InstructorRepository extends JpaRepository<Instructor, Integer> {

    // better options to write native or JPQL queries if the number of db queries via JPA is lot!
    @Query("SELECT i FROM Instructor i LEFT JOIN FETCH i.instructorDetail LEFT JOIN FETCH i.courses")
    List<Instructor> findAllInstructors();

    List<InstructorProjection> findAllProjectedBy();

    @Query("SELECT i FROM Instructor i LEFT JOIN FETCH i.instructorDetail WHERE i.id= :id")
    Optional<Instructor> findInstructorById(@Param("id") Integer id);

}
