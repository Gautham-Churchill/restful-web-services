package dev.gautham.rest.restfulwebservices.coach;

import org.springframework.stereotype.Component;

@Component
public class BaseballCoach implements Coach {

    @Override
    public String getDailyWorkOut() {
        return "Spend 30 minutes in batting practice";
    }
}
