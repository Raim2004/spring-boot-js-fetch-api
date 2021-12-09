package com.peaksoft.springboot.service;

import com.peaksoft.springboot.entity.User;
import com.peaksoft.springboot.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository employeeRepository;

    public UserServiceImpl(UserRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<User> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public User findById(Long id) {
        return employeeRepository.findById(id).get();
    }

    @Override
    public User save(User user) {
        return employeeRepository.save(user);
    }

    @Override
    public void deleteById(Long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public User findUsersByUsername(String username) {
        return employeeRepository.findUsersByUsername(username);
    }
}
