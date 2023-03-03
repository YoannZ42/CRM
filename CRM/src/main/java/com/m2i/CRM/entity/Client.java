package com.m2i.CRM.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

import com.github.javafaker.Faker;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="clients")
@Entity
public class Client {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
//	@Size(max = 20, min = 3, message = "Size should be between 3 to 20")
	@NotEmpty(message = "Enter your Company name")
	private String companyName;
	
//	@Size(max = 20, min = 3, message = "Size should be between 3 to 20")
	private String firstName;
	
//	@Size(max = 20, min = 3, message = "Size should be between 3 to 20")
	private String lastName;
	
//	@Email(message = "Invalid EmailId.Please enter proper EmailId")
	private String email;
	
	private String phone;
	
//	@Size(max = 250, min = 20, message = "Size should be between 20 to 250")
	private String address;
	
	private String zipCode;
	
	private String city;
	
	private String country;
	
	@Range(min = 0, max = 1, message = "Doit être entre 0 et 1")
	private int state;
	
//	@OneToMany(targetEntity = Order.class, cascade = CascadeType.ALL)
//	@JoinColumn(name = "fk_oc", referencedColumnName = "id")
	
	//@JsonIgnore
	@OneToMany( targetEntity=Order.class, mappedBy="client" , cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Order> listOrders;
	
	
	public Client(Faker f){		
		this.companyName = f.company().name();
		this.firstName = f.name().firstName();
		this.lastName = f.name().lastName();
		this.email = f.internet().emailAddress();
		this.phone = f.phoneNumber().phoneNumber();
		this.address = f.address().fullAddress();
		this.zipCode = f.address().zipCode();
		this.city = f.address().city();
		this.country = f.address().country();
		this.state = f.number().numberBetween(0, 1);
		this.listOrders = new ArrayList<>();
				
	}

}
	
//http://localhost:8080/swagger-ui/#/






