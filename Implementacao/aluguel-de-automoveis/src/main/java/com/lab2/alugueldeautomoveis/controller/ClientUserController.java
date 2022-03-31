package com.lab2.alugueldeautomoveis.controller;

import java.util.List;

import com.lab2.alugueldeautomoveis.model.ClientUser;
import com.lab2.alugueldeautomoveis.model.Ocupation;
import com.lab2.alugueldeautomoveis.model.Address;
import com.lab2.alugueldeautomoveis.model.User;
import com.lab2.alugueldeautomoveis.model.exceptions.InvalidLoginException;
import com.lab2.alugueldeautomoveis.repository.AddressRepository;
import com.lab2.alugueldeautomoveis.repository.ClientUserRepository;
import com.lab2.alugueldeautomoveis.repository.OcupationRepository;
import com.lab2.alugueldeautomoveis.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.thymeleaf.exceptions.AlreadyInitializedException;


@Controller
public class ClientUserController {

	@Autowired
	private ClientUserRepository clientUserRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private AddressRepository addressRepository;

	@Autowired
	private OcupationRepository ocupationRepository;
	
	@GetMapping(value = "client")
	public List<ClientUser> getAll() {
		return clientUserRepository.findAll();
	}

	@GetMapping(value = "client/{id}")
	public ClientUser get(@PathVariable Long id) {
		return clientUserRepository.findById(id).get();
	}

	@GetMapping(value = "client/login")
	public String loginPage(){
		return "login-client";
	}

	@GetMapping(value = "client/cadastro")
	public String cadastroPage(){
		return "cadastro-client";
	}

	@PostMapping(value = "client/login")
	public String login(User user) throws InvalidLoginException{
		try{
			if(!this.successLogin(user))
				throw new InvalidLoginException("Este login é invalido! \n Verifique se seu email ou senha estâo corretos.");
		}catch(NullPointerException e){
			throw new InvalidLoginException("Esta conta não foi cadastrada ainda.");
		}
		return "client";
	}
	
	@PostMapping(value = "client/cadastro")
	public ClientUser insert(@RequestBody ClientUser client) {
		if (getAll().contains(client))
			throw new AlreadyInitializedException("Ja existe esta conta no sistema");
		saveClientUser(client);
		return client;
	}
	
	public ClientUser getByEmail(String email){
		return clientUserRepository.findAll().stream().filter(c -> c.getUser().getEmail().equals(email)).findFirst().get();
	}

	public boolean successLogin(User user){
		return (this.getByEmail(user.getEmail()).getUser().login(user.getEmail(),user.getPassword()))?true:false;
	}

	private void saveUser(User user){
		userRepository.save(user);
	}

	private void saveOcupations(List<Ocupation> ocupations){
		for (Ocupation ocupation : ocupations) {
			ocupationRepository.save(ocupation);
		}
	}

	private void saveAddress(Address address){
		addressRepository.save(address);
	}

	private void saveClientUser(ClientUser clientUser){
		saveUser(clientUser.getUser());
		saveAddress(clientUser.getAddress());
		saveOcupations(clientUser.getOcupations());
		clientUserRepository.save(clientUser);
	}
	
}
