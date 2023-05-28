package com.gautham.rest.webservices.restfulwebservices.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
    
    private static List<User> users = new ArrayList<>();

    static {
        users.add(new User(1, "Gautham", LocalDate.of(1993,5,16)));
        users.add(new User(2, "Suvetha", LocalDate.now().minusYears(26).minusMonths(0).minusDays(8)));
    }

    public List<User> findAllUsers() {
        return users;
    }

    public User findUserById(Integer id) {
        return users.stream().filter(user -> user.getId().equals(id)).findFirst().get();
    }
}
