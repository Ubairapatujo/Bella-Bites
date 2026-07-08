package com.bakery.bakery_management.security;

import com.bakery.bakery_management.model.User;
import com.bakery.bakery_management.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataSeeder implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public DataSeeder(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) {
        if (userRepository.findByUsername("admin").isEmpty()) {
            User admin = new User("admin", passwordEncoder.encode("admin123"), "ADMIN", "Bakery Admin");
            userRepository.save(admin);
            System.out.println("✅ Admin user created: admin / admin123");
        }

        if (userRepository.findByUsername("employee1").isEmpty()) {
            User emp = new User("employee1", passwordEncoder.encode("emp123"), "EMPLOYEE", "Staff Member");
            userRepository.save(emp);
            System.out.println("✅ Employee user created: employee1 / emp123");
        }
    }
}