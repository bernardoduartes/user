package com.shizuca.user.dao;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserDTO {
    private String nome;
    private Integer idade;
}
