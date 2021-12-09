package com.peaksoft.springboot.service;

import com.peaksoft.springboot.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {

    List<User> findAll();
    User findById(Long id);
    User save(User user);
    void deleteById(Long id);
    User findUsersByUsername (String username);
}
