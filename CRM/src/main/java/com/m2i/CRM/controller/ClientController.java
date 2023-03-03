package com.m2i.CRM.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
import com.m2i.CRM.entity.Order;
import com.m2i.CRM.service.ClientService;
import com.m2i.CRM.service.OrderService;

@RestController
@RequestMapping("/client")
public class ClientController {
	
	@Autowired
	ClientService cService;
	
	@Autowired
	OrderService oService;
	

//	GET localhost:8080/client -> FindAll()
	@GetMapping
	public List<Client> FindAll() {
		return cService.findAll();
	}
	
//	GET localhost:8080/client/{id} -> FindById(id)	
	@GetMapping("/{id}")
	public Client FindById(@PathVariable("id") int id) {
		return cService.findById(id);
	}
	

//	POST localhost:8080/client -> save(client)	
	@PostMapping
	public void saveClient(@RequestBody Client c) {
		cService.save(c);
	}
	
//	PUT localhost:8080/client/{id} -> update(client, id)
	@PutMapping("/{id}")
	public void updateClient(@PathVariable("id") int id,@RequestBody Client c) {
		cService.update(id, c);
	}
	
	
//	DELETE localhost:8080/client/{id} -> delete(id)		
	@DeleteMapping("/{id}")
	public void deleteClient(@PathVariable("id") int id) {
		cService.delete(id);
	}
	
	
//	POST localhost:8080/client -> Création de plusieurs clients et d'orders associés
	@PostMapping("/fake")
	public List<Client> fakeClients() {
		
		List<Client> fakeClients = new ArrayList<>();
		
		Faker f = new Faker();
		Random r = new Random();
		
		for(int i = 0 ; i<25; i++) {
			Client client = new Client(f);
			cService.save(client);
			
			for(int j = 0 ; j<r.nextInt(10); j++) {
				
				Order order = new Order(client, f);
				client.getListOrders().add(order);
				oService.save(order);
			}
			
			fakeClients.add(client);
		}
		return fakeClients;
		
	}
	
	
	

	// On renvoie les orders d'un client (par son id)
	
	@GetMapping("/test/{id}")
	public List<Order> getOrderByClient(@PathVariable("id") int id) {
		Client client = cService.findById(id);
		return client.getListOrders();
		
	}
	
	
	

}