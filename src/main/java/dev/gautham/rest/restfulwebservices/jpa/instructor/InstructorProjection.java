package dev.gautham.rest.restfulwebservices.jpa.instructor;

public interface InstructorProjection {

    String getFirstName();
    String getLastName();
    InstructorDetailProjection getInstructorDetail();

}
