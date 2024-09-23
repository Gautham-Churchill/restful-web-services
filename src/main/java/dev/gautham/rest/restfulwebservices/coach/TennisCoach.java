package dev.gautham.rest.restfulwebservices.coach;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class TennisCoach implements Coach{

    @Override
    public String getDailyWorkOut() {
        return "Practice your back end volley";
    }
}
