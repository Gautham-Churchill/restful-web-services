package dev.gautham.rest.restfulwebservices.jpa.student;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudentMapper {

    StudentEntity mapStudentDaoToStudentEntity(StudentDao studentDao);
}
