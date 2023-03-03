package com.m2i.CRM.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.m2i.CRM.entity.Order;
import com.m2i.CRM.repository.OrderRepository;

@Service
public class OrderService {

	@Autowired
	OrderRepository oRepo;
	
	public List<Order> findAll(){
		return oRepo.findAll();
	}
	
	public Order findById(int id){
		return oRepo.findById(id).orElse(null);
	}
	
	public void save(Order o){
		oRepo.save(o);
	}
	
	public void update(int id, Order o) {
		Order orderInDB = findById(id);
		if (o != null) {
			orderInDB.setTypePresta(o.getTypePresta());
			orderInDB.setDesignation(o.getDesignation());
			orderInDB.setNbDays(o.getNbDays());
			orderInDB.setUnitPrice(o.getUnitPrice());
			orderInDB.setState(o.getState());
			save(orderInDB);
		}
	}
	
	
	public void delete(int id) {
		Order o = findById(id);
		if (o != null) oRepo.delete(o);
	}
}
