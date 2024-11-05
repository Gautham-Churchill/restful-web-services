package dev.gautham.rest.restfulwebservices.jpa.instructor;

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

@Slf4j
@RestController
@RequestMapping("/instructors")
@Tag(name = "Instructor APIs")
@RequiredArgsConstructor
public class InstructorController {

    private final InstructorService instructorService;

    @GetMapping
    public List<Instructor> getAllInstructors() {
        return instructorService.getAllInstructor();
    }

    @GetMapping("/hobby")
    public List<InstructorProjection> getAllInstructorsHobby() {
        return instructorService.getAllInstructorHobbies();
    }

    @GetMapping("/byHobby")
    public List<InstructorDetail> getAllInstructorsByHobby(@RequestParam("hobby") String hobby) {
        return instructorService.getInstructorsByHobby(hobby);
    }

    /**
     * This method retrieves an instructor by ID.
     * It returns 404 Not Found if the instructor is not found.
     *
     * @param id the ID of the instructor to retrieve
     * @return the instructor
     */
    @GetMapping("/{id}")
    public Instructor getInstructorById(@PathVariable Integer id) {
        return instructorService.getInstructorById(id);
    }

    /**
     * Creates a new instructor. This method will return a 201 Created status once the operation is completed.
     *
     * @param instructor the instructor to create
     * @return the created instructor
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Instructor saveInstructor(@RequestBody Instructor instructor) {
        return instructorService.saveInstructor(instructor);
    }

    @PutMapping
    public Instructor updateInstructor(@RequestBody Instructor instructor) {
        return instructorService.saveInstructor(instructor);
    }

    @DeleteMapping("/{id}")
    public void deleteInstructor(@PathVariable Integer id) {
        instructorService.deleteInstructorById(id);
    }
}
