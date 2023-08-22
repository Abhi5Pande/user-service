package io.getarrays.userservice;

import io.getarrays.userservice.domain.Role;
import io.getarrays.userservice.domain.User;
import io.getarrays.userservice.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class UserServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserServiceApplication.class, args);
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    CommandLineRunner run(UserService userService) {
        return args -> {
            userService.saveRole(new Role(null, "ROLE_USER"));
            userService.saveRole(new Role(null, "ROLE_MANAGER"));
            userService.saveRole(new Role(null, "ROLE_ADMIN"));
            userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

            userService.saveUser(new User(null,"Abhijit Pachpande","abhijit","1234",new ArrayList<>()));
            userService.saveUser(new User(null,"Sanjay Pachpande","sanjay","1234",new ArrayList<>()));
            userService.saveUser(new User(null,"Akshit Khamesra","akshit","1234",new ArrayList<>()));
            userService.saveUser(new User(null,"Harsh Kulkarni","harsh","1234",new ArrayList<>()));

            userService.addRoleToUser("abhijit","ROLE_USER");
            userService.addRoleToUser("abhijit","ROLE_MANAGER");
            userService.addRoleToUser("abhijit","ROLE_SUPER_ADMIN");
            userService.addRoleToUser("akshit","ROLE_USER");
            userService.addRoleToUser("sanjay","ROLE_ADMIN");
            userService.addRoleToUser("Harsh","ROLE_MANAGER");
        };
    }
}
