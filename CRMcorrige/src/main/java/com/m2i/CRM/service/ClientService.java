package com.m2i.CRM.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.m2i.CRM.repository.ClientRepository;

@Service
public class ClientService {

	@Autowired
	ClientRepository cRepo;
}
