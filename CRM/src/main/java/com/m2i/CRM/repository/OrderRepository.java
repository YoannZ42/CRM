package com.m2i.CRM.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.m2i.CRM.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Integer>{

}
