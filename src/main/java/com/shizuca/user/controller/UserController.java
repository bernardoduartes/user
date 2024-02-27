package com.shizuca.user.controller;

import com.shizuca.user.dao.UserDTO;
import com.shizuca.user.model.User;
import com.shizuca.user.service.UserService;
import jakarta.websocket.server.PathParam;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
