package com.lab2.alugueldeautomoveis.model;


import java.util.List;

import javax.management.InvalidAttributeValueException;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_client_user")
public class ClientUser {
    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cpf;
    private String rg;
    
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany
    @JoinColumn(name = "client_ocupation_id")
    private List<Ocupation> ocupations;

    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;

    public ClientUser(String name, String email, String password, String cpf, String rgString) throws InvalidAttributeValueException {
        user = new User(name, email, password);
        setCpf(cpf);
        setRg(rg);     
    }


    public Long getId() {
        return this.id;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return this.rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public List<Ocupation> getOcupations() {
        return this.ocupations;
    }

    public Address getAddress() {
        return this.address;
    }

}
