package com.m2i.CRM.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.m2i.CRM.entity.Order;
import com.m2i.CRM.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	OrderService oService;
	

//	GET localhost:8080/order -> FindAll()
	@GetMapping
	public List<Order> FindAll() {
		return oService.findAll();
	}
	
//	GET localhost:8080/order/{id} -> FindById(id)Une order est forcément liée à un client
	@GetMapping("/{id}")
	public Order FindById(@PathVariable("id") int id) {
		return oService.findById(id);
	}
	

//	POST localhost:8080/order -> save(order) 
	@PostMapping
	public void saveOrder(@RequestBody Order o) {
		oService.save(o);
	}
	
//	PUT localhost:8080/order/{id} -> update(order, id)
	@PutMapping("/{id}")
	public void updateOrder(@PathVariable("id") int id,@RequestBody Order o) {
		oService.update(id, o);
	}
	
	
//	DELETE localhost:8080/order/{id} -> delete(id)	
	@DeleteMapping("/{id}")
	public void deleteOrder(@PathVariable("id") int id) {
		oService.delete(id);
	}

}
