package com.shizuca.user.controller;

import com.shizuca.user.dao.UserDTO;
import com.shizuca.user.model.User;
import com.shizuca.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAll(){
        return userService.getAll();
    }

    @PostMapping
    public Long create(@RequestBody UserDTO userDTO){
        return userService.save(userDTO);
    }
}
