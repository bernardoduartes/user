package com.shizuca.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shizuca.user.dao.UserDTO;
import com.shizuca.user.model.User;
import com.shizuca.user.service.UserService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAll(){
        log.info("Getting all users");
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable(name = "id") final Long userId){
        log.info("Getting user by id");
        return userService.getById(userId);
    }

    @PostMapping
    public Long create(@RequestBody UserDTO userDTO){
        log.info("Posting a user");
        return userService.save(userDTO);
    }
}
