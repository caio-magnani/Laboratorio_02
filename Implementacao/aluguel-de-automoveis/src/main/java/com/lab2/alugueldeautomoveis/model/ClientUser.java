package com.lab2.alugueldeautomoveis.model;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tb_client_user")
public class ClientUser {
    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Min(14)
    private String cpf;

    @NotNull
    @Min(10)
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

    public ClientUser(String name, String email, String password, String cpf, String rgString){
        user = new User(name, email, password);
        setCpf(cpf);
        setRg(rg);     
    }
    
    public ClientUser() {
    	
    }


    public Long getId() {
        return this.id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    @Override
    public boolean equals(Object object) {
        ClientUser clientUserObject = (ClientUser) object;
        return this.getCpf().equals(clientUserObject.getCpf()) || this.getRg().equals(clientUserObject.getRg()) || this.getUser().getEmail().equals(clientUserObject.getUser().getEmail());
        
    }

}
