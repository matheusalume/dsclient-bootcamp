package com.devsuperior.dsclient.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dsclient.entities.Client;
import com.devsuperior.dsclient.repositories.ClientRepository;
import com.devsuperior.dsclient.services.exceptions.ResourceNotFoundException;

@Service
public class ClientService {

	@Autowired
	private ClientRepository repository;

	@Transactional(readOnly = true)
	public List<Client> findAll(){
		List<Client> clients = repository.findAll();
		return clients;
	}

	public Client findById(Long id) {
		Optional<Client> opt = repository.findById(id);
		Client client = opt.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
		return client;
	}
}
