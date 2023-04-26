package com.example.springs;

import com.example.springs.entity.Role;
import com.example.springs.entity.User;
import com.example.springs.repository.IRoleRepository;
import com.example.springs.repository.UserRepository;
import com.example.springs.service.UserService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class SpringsApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringsApplication.class, args);
    }

    @Bean
    CommandLineRunner run(@Qualifier("userDetailsServiceImpl") UserService iUserService, IRoleRepository iRoleRepository, UserRepository iUserRepository, PasswordEncoder passwordEncoder) {
        return args ->
        {
            iUserService.saveRole(new Role("ROLE_USER"));
            iUserService.saveRole(new Role("ROLE_ADMIN"));
            iUserService.saveRole(new Role("ROLE_SUPERADMIN"));
            iUserService.saveUser(new User("admin@gmail.com", passwordEncoder.encode("adminPassword"), true, new HashSet<>()));
            iUserService.saveUser(new User("superadminadmin@gmail.com", passwordEncoder.encode("superadminPassword"), true, new HashSet<>()));
            iUserService.saveUser(new User("user@gmail.com", passwordEncoder.encode("user"), true, new HashSet<>()));

            Role role = iRoleRepository.findByName("ROLE_ADMIN");
            User user = iUserRepository.getUserByUserName("admin@gmail.com");
            Set<Role> setRole = new HashSet<>();
            setRole.add(role);
            user.setRoles(setRole);
            iUserService.saveUser(user);

            User userr = iUserRepository.getUserByUserName("superadminadmin@gmail.com");
            Role rolee = iRoleRepository.findByName("ROLE_SUPERADMIN");
            Set<Role> setRole1 = new HashSet<>();
            setRole1.add(rolee);
            userr.setRoles(setRole1);
            iUserService.saveUser(userr);

            User normal = iUserRepository.getUserByUserName("user@gmail.com");
            Role userRole = iRoleRepository.findByName("ROLE_USER");
            Set<Role> setRole3 = new HashSet<>();
            setRole3.add(userRole);
            normal.setRoles(setRole3);
            iUserService.saveUser(normal);

        };
    }

}
