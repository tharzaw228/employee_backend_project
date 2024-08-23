package org.example.backendcrudproject;

import lombok.RequiredArgsConstructor;
import org.example.backendcrudproject.dao.EmployeeDao;
import org.example.backendcrudproject.entity.Employee;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class BackendCrudProjectApplication {

    private final EmployeeDao employeeDao;

    @Bean @Profile("dev")
    public ApplicationRunner applicationRunner() {
        return args -> {
            List.of(
                    new Employee(null, "John", "Doe", "john@gmail.com", "55-555-55", LocalDate.now(), 2000),
                    new Employee(null, "John", "Soe", "john@gmail.com", "55-444-55", LocalDate.now(), 3000),
                    new Employee(null, "John", "Myo", "john@gmail.com", "55-333-55", LocalDate.now(), 4000),
                    new Employee(null, "John", "Toe", "john@gmail.com", "55-222-55", LocalDate.now(), 5000)
            ).forEach(employeeDao::save);
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(BackendCrudProjectApplication.class, args);
    }

}
