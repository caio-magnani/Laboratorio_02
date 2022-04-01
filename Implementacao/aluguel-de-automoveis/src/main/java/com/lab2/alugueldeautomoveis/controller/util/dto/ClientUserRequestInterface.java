package com.lab2.alugueldeautomoveis.controller.util.dto;

import java.util.List;

import com.lab2.alugueldeautomoveis.model.Address;
import com.lab2.alugueldeautomoveis.model.ClientUser;
import com.lab2.alugueldeautomoveis.model.Ocupation;
import com.lab2.alugueldeautomoveis.model.User;

class ClientUserRequestInterface {
	
	private String name;
	private String email;
	private String password;
	private String rg;
	private String cpf;
	private List<Ocupation> ocupations;
	private Address address;
	
	

    public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public List<Ocupation> getOcupations() {
		return ocupations;
	}

	public String getCpf() {
    	return this.cpf;
    }

    public String getRg() {
    	return this.rg;
    }

 //   public List<Ocupation> getOcupations(){
//    	return this.ocupations;
 //   }

//    public Address getAddress() {
//    	return this.address;
//    }
    
    

    public ClientUserRequestInterface(String name, String email, String password, String rg, String cpf) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.rg = rg;
		this.cpf = cpf;
		this.ocupations = ocupations;
		this.address = address;
	}

	public ClientUser toClientUser() {
		return new ClientUser(name, email, password, cpf, rg);
	}
}
