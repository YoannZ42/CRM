package com.m2i.CRM.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.m2i.CRM.entity.Client;

public interface ClientRepository extends JpaRepository<Client, Integer> {

}
