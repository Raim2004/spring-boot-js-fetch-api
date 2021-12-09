package com.peaksoft.springboot.controller;

import com.peaksoft.springboot.entity.User;
import com.peaksoft.springboot.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    private final UserService userService;

    public AdminController(UserService userService) {
        this.userService = userService;
    }


    //    @GetMapping("/info")
//    public ResponseEntity<List<User>> getAll(){
//        try {
//            return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
//        } catch (Exception ex){
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//    }
    @CrossOrigin
    @GetMapping("/info")
    public List<User> get() {
        List<User> users = new ArrayList<>();
        for (User user : userService.findAll()) {
            users.add(new User(user.getId(), user.getName(), user.getLastName(), user.getAge(),user.getEmail()));
        }
        return users.stream().sorted(Comparator.comparing(User::getId)).collect(Collectors.toList());
    }


    @GetMapping("/{Id}")
    public ResponseEntity<User> getById(@PathVariable("Id") Long employeeId) {
        try {
            return new ResponseEntity<>(userService.findById(employeeId), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    @PostMapping
    public ResponseEntity<User> add(@RequestBody User user) {
        try {
            return new ResponseEntity<>(userService.save(user), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping
    public ResponseEntity<User> update(@RequestBody User user) {
        try {
            return new ResponseEntity<>(userService.save(user), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{Id}")
    public String delete(@PathVariable("Id") Long employeeId) {
        try {
            userService.deleteById(employeeId);
            return "User with ID = " + employeeId + " was successfully deleted.";
        } catch (Exception e) {
            return String.valueOf(HttpStatus.BAD_REQUEST);
        }
    }

}
