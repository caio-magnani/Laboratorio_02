package com.lab2.alugueldeautomoveis.controller.util.dto;

import com.lab2.alugueldeautomoveis.model.ClientUser;

class ClientUserRequestInterface {
	
	private String name;
	private String email;
	private String password;
	private String rg;
	private String cpf;
	
	

    public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public String getCpf() {
    	return this.cpf;
    }

    public String getRg() {
    	return this.rg;
    }
    
    

    public ClientUserRequestInterface(String name, String email, String password, String rg, String cpf) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.rg = rg;
		this.cpf = cpf;
	}

	public ClientUser toClientUser() {
		return new ClientUser(name, email, password, cpf, rg);
	}
}
