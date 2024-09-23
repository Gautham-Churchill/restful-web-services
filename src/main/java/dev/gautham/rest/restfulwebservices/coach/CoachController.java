package dev.gautham.rest.restfulwebservices.coach;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/coach")
@Tag(name = "CoachController")
public class CoachController {

    private final Coach coach;

    public CoachController(@Qualifier("trackCoach") Coach coach) {
        this.coach = coach;
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return coach.getDailyWorkOut();
    }

}
