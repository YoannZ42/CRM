package com.m2i.CRM.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

import org.hibernate.validator.constraints.Range;

import com.github.javafaker.Faker;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@Entity
@Table(name = "orders")
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Order {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank
    private String typePresta;
    @NotBlank
    private String designation;
    @Positive
    private int nbDays;
    @Positive
    private float unitPrice;
    @Range(min = 0, max = 2)
    private int state; // CANCELLED:0 OPTION:1 CONFIRMED:2
    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name="clientId")
    private Client client;
    
    public Order(Faker f, Client c) {
    	System.out.println(c);
    	this.client = c;
    	this.typePresta = f.commerce().productName();
    	this.designation = f.commerce().productName();
    	this.nbDays = f.number().numberBetween(10, 500);
    	this.unitPrice = f.number().numberBetween(500, 5000);
    	this.state = f.number().numberBetween(0, 2);
    }
}
