package com.lab2.alugueldeautomoveis.controller;

import java.util.List;

import javax.management.InvalidAttributeValueException;

import com.lab2.alugueldeautomoveis.model.ClientUser;
import com.lab2.alugueldeautomoveis.model.Ocupation;
import com.lab2.alugueldeautomoveis.controller.util.dto.LoginUserRequest;
import com.lab2.alugueldeautomoveis.controller.util.exception.InvalidLoginException;
import com.lab2.alugueldeautomoveis.model.Address;
import com.lab2.alugueldeautomoveis.model.User;
import com.lab2.alugueldeautomoveis.repository.AddressRepository;
import com.lab2.alugueldeautomoveis.repository.ClientUserRepository;
import com.lab2.alugueldeautomoveis.repository.OcupationRepository;
import com.lab2.alugueldeautomoveis.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/client")
public class ClientUserController {

	@Autowired
	private ClientUserRepository clientUserRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private AddressRepository addressRepository;

	@Autowired
	private OcupationRepository ocupationRepository;

	@GetMapping(value = "/login")
	public String loginPage(){
		return "login-client";
	}
	
	@PostMapping(value = "/login")
	public String login(LoginUserRequest userRequest) throws InvalidLoginException, InvalidAttributeValueException{
		
		return "client";
	}

	@GetMapping(value = "/cadastro")
	public String cadastroPage(){
		return "cadastro-client";
	}
	
	@PostMapping(value = "/cadastro")
	public ClientUser insert(@RequestBody ClientUser client) {
		saveClientUser(client);
		return client;
	}
	public List<ClientUser> getAll() {
		return clientUserRepository.findAll();
	}
	
	public ClientUser get(Long id) {
		return clientUserRepository.findById(id).get();
	}
	
	public ClientUser getByEmail(String email){
		return clientUserRepository.findAll().stream().filter(c -> c.getUser().getEmail().equals(email)).findFirst().get();
	}

	public boolean successLogin(User user){
		User thisUser = this.getByEmail(user.getEmail()).getUser();
		if(thisUser.getPassword() == null)
			throw new NullPointerException();
		return thisUser.login(user.getEmail(),user.getPassword()) ;
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