package dev.gautham.rest.restfulwebservices.config;

import dev.gautham.rest.restfulwebservices.constants.ApplicationConstants;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

import static dev.gautham.rest.restfulwebservices.constants.ApplicationConstants.EMPLOYEES_API;
import static dev.gautham.rest.restfulwebservices.constants.ApplicationConstants.EMPLOYEES_NEXT_API;

@Configuration
public class SecurityConfig {

    /**
     * Fetching user details from db
     *
     * @param dataSource the db data source
     * @return user details
     */
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);

        // user is passed in from login
        jdbcUserDetailsManager.setUsersByUsernameQuery("select user_id, pw, active from members where user_id = ?");
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery("select user_id, role from roles where user_id = ?");

        return jdbcUserDetailsManager;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(config ->
                config
                        .requestMatchers(HttpMethod.GET, "/swagger-ui/**").hasRole(ApplicationConstants.EMPLOYEE)
                        .requestMatchers(HttpMethod.GET, "/v3/api-docs/**").hasRole(ApplicationConstants.EMPLOYEE)
                        .requestMatchers(HttpMethod.GET, EMPLOYEES_API).hasRole(ApplicationConstants.EMPLOYEE)
                        .requestMatchers(HttpMethod.GET, EMPLOYEES_NEXT_API).hasRole(ApplicationConstants.EMPLOYEE)
                        .requestMatchers(HttpMethod.POST, EMPLOYEES_API).hasRole(ApplicationConstants.MANAGER)
                        .requestMatchers(HttpMethod.PUT, EMPLOYEES_API).hasRole(ApplicationConstants.MANAGER)
                        .requestMatchers(HttpMethod.DELETE, EMPLOYEES_NEXT_API).hasRole(ApplicationConstants.ADMIN));

        // for basic auth
        http.httpBasic(Customizer.withDefaults());

        // disable CSRF
        http.csrf(csrf -> csrf.disable());

        return http.build();
    }

    /* Hardcoding users details using in memory details */
    /*@Bean
    public InMemoryUserDetailsManager userDetailsManager() {
        UserDetails john = User.builder()
                .username("john")
                .password("{noop}test123")
                .roles(ApplicationConstants.EMPLOYEE)
                .build();

        UserDetails mary = User.builder()
                .username("mary")
                .password("{noop}test123")
                .roles(ApplicationConstants.EMPLOYEE, ApplicationConstants.MANAGER)
                .build();

        UserDetails susan = User.builder()
                .username("susan")
                .password("{noop}test123")
                .roles(ApplicationConstants.EMPLOYEE, ApplicationConstants.MANAGER, ApplicationConstants.ADMIN)
                .build();

        return new InMemoryUserDetailsManager(john, mary, susan);
    }*/
}
