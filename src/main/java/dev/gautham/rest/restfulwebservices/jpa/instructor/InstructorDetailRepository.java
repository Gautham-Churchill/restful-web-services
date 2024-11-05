package dev.gautham.rest.restfulwebservices.jpa.instructor;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InstructorDetailRepository extends JpaRepository<InstructorDetail, Integer> {

    List<InstructorDetail> findAllByHobby(String hobby);
}
