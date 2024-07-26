package dev.gautham.rest.webservices.user;

import java.net.URI;
import java.util.List;

import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


@RestController
@RequestMapping("/users")
@Log4j2
public class UserController {
    
    private final UserDaoService userDaoService;

    public UserController(UserDaoService userDaoService) {
        this.userDaoService = userDaoService;
    }

    @GetMapping
    public List<User> getAllUsers() {
        log.info("Get all users call");
        return userDaoService.findAllUsers();
    }

    @GetMapping("/{id}")
    public EntityModel<User> getUser(@PathVariable Integer id) {
        User userById = userDaoService.findUserById(id);
        if(userById == null) {
            throw new UserNotFoundException("User with id " + id + " is not found");
        }

        EntityModel<User> entityModel = EntityModel.of(userById);
        WebMvcLinkBuilder link = WebMvcLinkBuilder.linkTo(methodOn(this.getClass()).getAllUsers());
        entityModel.add(link.withRel("get-all-users"));
        return entityModel;
    }

    @PostMapping
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        User savedUser = userDaoService.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(savedUser.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Integer id) {
        userDaoService.deleteById(id);
    }
}
