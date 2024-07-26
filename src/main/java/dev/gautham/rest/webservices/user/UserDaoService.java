package dev.gautham.rest.webservices.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
    
    private static List<User> users = new ArrayList<>();

    private static int userCount = 0;

    static {
        users.add(new User(++userCount, "Gautham", LocalDate.of(1993,5,16)));
        users.add(new User(++userCount, "Suvetha", LocalDate.now().minusYears(26).minusMonths(0).minusDays(8)));
    }

    public List<User> findAllUsers() {
        return users;
    }

    public User findUserById(Integer id) {
        return users.stream().filter(user -> user.getId().equals(id)).findFirst().orElse(null);
    }

    public User save(User user) {
        user.setId(++userCount);
        users.add(user);
        return findUserById(userCount);
    }

    public void deleteById(Integer id) {
        users.removeIf(user -> user.getId().equals(id));
    }
}
