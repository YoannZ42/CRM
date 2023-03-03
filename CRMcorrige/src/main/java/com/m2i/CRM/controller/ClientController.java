package com.m2i.CRM.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.javafaker.Faker;
import com.m2i.CRM.entity.Client;
import com.m2i.CRM.repository.ClientRepository;
import com.m2i.CRM.service.ClientService;

@RestController
@RequestMapping("/client")
public class ClientController {

	@Autowired
	ClientService cService;
	
	@Autowired
	ClientRepository cRepo;
	
	
	@GetMapping
	public List<Client> all(){
		return cRepo.findAll();
	}
	
	@GetMapping("/{id}")
	public Client getById(@PathVariable("id") int id) {
		return cRepo.findById(id).orElse(null);
	}
	
	@PostMapping
	public void postClient(@RequestBody @Valid Client c) {
		cRepo.save(c);
	}
	
	@PutMapping("/{id}")
	public void putClient(@RequestBody @Valid Client c, @PathVariable("id") int id) {
		c.setId(id);
		cRepo.save(c);
	}
	
	@DeleteMapping("/{id}")
	public void deleteClient(@PathVariable("id") int id) {
		cRepo.delete( cRepo.findById(id).orElse(null));
	}
	
	@PostMapping("/fake")
	public Client fake() {
		Faker f = new Faker();
		return cRepo.save( new Client(f));
	}
	
	
}
