package com.shizuca.user.service;


import com.shizuca.user.dao.UserDTO;
import com.shizuca.user.model.User;
import com.shizuca.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAll(){
        return userRepository.findAll();
    }

    public User getById(final Long userId){
        return userRepository.findById(userId).orElse(User.builder().build());
    }
    public Long save(final UserDTO userDTO){
        var persistedUser = userRepository.save(
                User.builder()
                        .idade(userDTO.getIdade())
                        .nome(userDTO.getNome())
                        .build()
        );
        return persistedUser.getId();
    }
}
