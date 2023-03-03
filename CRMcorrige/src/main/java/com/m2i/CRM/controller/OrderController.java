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
import com.m2i.CRM.entity.Order;
import com.m2i.CRM.repository.ClientRepository;
import com.m2i.CRM.repository.OrderRepository;
import com.m2i.CRM.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	OrderService oService;
	
	@Autowired
	OrderRepository oRepo;
	
	@Autowired
	ClientRepository cRepo;
	
	@GetMapping
	public List<Order> all(){
		return oRepo.findAll();
	}
	
	@GetMapping("/{id}")
	public Order getById(@PathVariable("id") int id) {
		return oRepo.findById(id).orElse(null);
	}
	
	@PostMapping("/{idclient}")
	public void postOrder(@PathVariable("idclient") int idClient, @RequestBody @Valid Order o) {
		o.setClient( cRepo.findById(idClient).orElse(null) );
		oRepo.save(o);
	}
	
	@PutMapping("/{id}")
	public void putOrder(@RequestBody @Valid Order o, @PathVariable("id") int id) {
		o.setId(id);
		oRepo.save(o);
	}
	
	@DeleteMapping("/{id}")
	public void deleteOrder(@PathVariable("id") int id) {
		oRepo.delete( oRepo.findById(id).orElse(null));
	}
	
	@PostMapping("/fake/{idclient}")
	public Order fake(@PathVariable("idclient") int id) {
		return oRepo.save( new Order(new Faker() , cRepo.findById(id).orElse(null)) );
	}
	
}
