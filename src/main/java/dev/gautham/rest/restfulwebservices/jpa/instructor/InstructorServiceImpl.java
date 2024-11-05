package dev.gautham.rest.restfulwebservices.jpa.instructor;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class InstructorServiceImpl implements InstructorService {

    private final InstructorRepository instructorRepository;
    private final InstructorDetailRepository instructorDetailRepository;

    @Override
    public List<Instructor> getAllInstructor() {
        return instructorRepository.findAllInstructors();
    }

    @Override
    public List<InstructorProjection> getAllInstructorHobbies() {
        return instructorRepository.findAllProjectedBy();
    }

    public Instructor getInstructorById(Integer id) {
        return instructorRepository.findById(id).orElseThrow(() -> new InstructorNotFoundException("Instructor with id: "+ id + " is not found"));
    }

    public Instructor saveInstructor(Instructor instructor) {
        return instructorRepository.save(instructor);
    }

    @Override
    public void deleteInstructorById(Integer id) {
        instructorRepository.deleteById(id);
    }

    @Override
    public List<InstructorDetail> getInstructorsByHobby(String hobby) {
        return instructorDetailRepository.findAllByHobby(hobby);
    }
}

