package com.m2i.CRM.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.javafaker.Faker;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="orders")
@Entity
public class Order {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
//	@Size(max = 50, min = 3, message = "Size should be between 3 to 50")
	private String typePresta;
	
//	@Size(max = 1000, min = 3, message = "Size should be between 3 to 1000")
	private String designation;
	
//	@Positive(message = "Doit etre positif")
	private int nbDays;
	
//	@Positive(message = "Doit etre positif")
	private int unitPrice;
	
//	@Range(min = 0, max = 2, message = "Doit être entre 0 et 2")
	private int state;
	
//	@ManyToOne @JoinColumn(name="fk_oc")	
//	@JsonIgnore
	
	@ManyToOne @JoinColumn(name="id_client")	
	@JsonIgnore
	private Client client;
	
	
	
	public Order(Client c) {
		this.client = c;
		c.getListOrders().add(this);
	}
	
	
	public Order(Client c, Faker f) {
		
		this.client = c;
		
		this.typePresta = f.lorem().characters(40);
		
		this.designation = f.lorem().characters(250);
		
		this.nbDays = f.number().numberBetween(1, 1000);
		
		this.unitPrice = f.number().numberBetween(1, 1000);
		
		this.state = f.number().numberBetween(0, 2);
		
		c.getListOrders().add(this);
			
	}
	
}




 
