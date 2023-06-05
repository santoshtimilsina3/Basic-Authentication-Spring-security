package com.example.springs.service;

import com.example.springs.entity.Role;
import com.example.springs.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService extends UserDetailsService {
    public User saveUser(User user);
    public Role saveRole(Role role);

    List<User> getUsers();


}
