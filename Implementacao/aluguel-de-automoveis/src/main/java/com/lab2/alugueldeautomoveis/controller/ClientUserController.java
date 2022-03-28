package com.lab2.alugueldeautomoveis.controller;

import java.util.List;

import com.lab2.alugueldeautomoveis.model.ClientUser;
import com.lab2.alugueldeautomoveis.model.Ocupation;
import com.lab2.alugueldeautomoveis.model.Address;
import com.lab2.alugueldeautomoveis.model.User;
import com.lab2.alugueldeautomoveis.repository.AddressRepository;
import com.lab2.alugueldeautomoveis.repository.ClientUserRepository;
import com.lab2.alugueldeautomoveis.repository.OcupationRepository;
import com.lab2.alugueldeautomoveis.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/clients")
public class ClientUserController {

	@Autowired
	private ClientUserRepository clientUserRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private AddressRepository addressRepository;

	@Autowired
	private OcupationRepository ocupationRepository;
	
	@GetMapping
	public List<ClientUser> getAll() {
		return clientUserRepository.findAll();
	}

	@GetMapping(value = "/{id}")
	public ClientUser get(@PathVariable Long id) {
		return clientUserRepository.getById(id);
	}
	
	@PostMapping
	public ClientUser insert(@RequestBody ClientUser client) {
		saveClientUser(client);
		return client;
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
