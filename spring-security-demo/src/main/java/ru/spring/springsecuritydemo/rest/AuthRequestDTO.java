package ru.spring.springsecuritydemo.rest;

import lombok.Data;

@Data
public class AuthRequestDTO {
    private String email;
    private String password;
}
