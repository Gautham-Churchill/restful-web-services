package dev.gautham.rest.restfulwebservices.jpa.instructor;

import java.util.List;

public interface InstructorService {

    List<Instructor> getAllInstructor();

    List<InstructorProjection> getAllInstructorHobbies();

    Instructor getInstructorById(Integer id);

    Instructor saveInstructor(Instructor instructor);

    void deleteInstructorById(Integer id);

    List<InstructorDetail> getInstructorsByHobby(String hobby);
}
