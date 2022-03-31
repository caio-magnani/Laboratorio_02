package com.lab2.alugueldeautomoveis.controller.util.dto;

import javax.management.InvalidAttributeValueException;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.lab2.alugueldeautomoveis.model.User;

public class LoginUserRequest {
    @NotNull
    @Min(5)
    private String email;
    
    @NotNull
    @Min(8)
    private String password;

    public LoginUserRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
    
    public User toUser() throws InvalidAttributeValueException{
        return new User(null, this.getEmail(), this.getPassword());
    }
}
