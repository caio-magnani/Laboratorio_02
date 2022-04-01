package com.lab2.alugueldeautomoveis.controller.util.dto;

import java.util.List;

import com.lab2.alugueldeautomoveis.model.Address;
import com.lab2.alugueldeautomoveis.model.ClientUser;
import com.lab2.alugueldeautomoveis.model.Ocupation;
import com.lab2.alugueldeautomoveis.model.User;

public interface ClientUserRequestInterface {

    public User getUser();

    public void setUser(User user);

    public String getCpf();

    public void setCpf(String cpf);

    public String getRg();

    public void setRg(String rg);

    public List<Ocupation> getOcupations();

    public Address getAddress();

    public ClientUser toClientUser();
}
