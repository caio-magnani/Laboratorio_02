package com.lab2.alugueldeautomoveis.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tb_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Min(3)
    private String name;

    @NotNull
    @Min(5)
    private String email;

    @NotNull
    @Min(8)
    private String password;

    public User(String name,String email, String password){
        setName(name);
        setEmail(email);
        setPassword(password);
    }
    
    public User() {
    	
    }
    
    public Long getId() {
    	return this.id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }
    
    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", email=" + email +  ", password=" + password + "]";
    }

    @AssertTrue
    public boolean login(String email, String password) {   	
    	return (this.email == email && this.password == password);
    }
}