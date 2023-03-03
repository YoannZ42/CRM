package com.m2i.CRM.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.m2i.CRM.entity.Client;
import com.m2i.CRM.repository.ClientRepository;

@Service
public class ClientService {
	
	@Autowired
	ClientRepository cRepo;
	
	public List<Client> findAll(){
		return cRepo.findAll();
	}
	
	public Client findById(int id){
		return cRepo.findById(id).orElse(null);
	}
	
	public void save(Client c){
		cRepo.save(c);
	}
	
	public void update(int id, Client c) {
		Client clientInDB = findById(id);
		if (c != null) {
			clientInDB.setCompanyName(c.getCompanyName());
			clientInDB.setFirstName(c.getFirstName());
			clientInDB.setLastName(c.getLastName());
			clientInDB.setEmail(c.getEmail());
			clientInDB.setPhone(c.getPhone());
			clientInDB.setAddress(c.getAddress());
			clientInDB.setZipCode(c.getZipCode());
			clientInDB.setCity(c.getCity());
			clientInDB.setCountry(c.getCountry());
			clientInDB.setState(c.getState());
			save(clientInDB);
		}
	}
	
	
	public void delete(int id) {
		Client c = findById(id);
		if (c != null) cRepo.delete(c);
	}

}
