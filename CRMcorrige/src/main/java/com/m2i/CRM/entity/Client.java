package com.m2i.CRM.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Range;

import com.github.javafaker.Faker;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@Entity
@Table
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank
    private String companyName;
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @Email
    private String email;
    @NotBlank
    private String phone;
    @NotBlank
    private String address;
    @NotBlank
    private String zipCode;
    @NotBlank
    private String city;
    @NotBlank
    private String country;
    @Range(min = 0, max = 1 )
    private int state;  //  INACTIVE:0    ACTIVE:1
    
    public Client(Faker f) {
    	this.companyName = f.company().name();
    	this.firstName = f.name().firstName();
    	this.lastName = f.name().lastName();
    	this.email = f.internet().emailAddress();
    	this.phone = f.phoneNumber().cellPhone();
    	this.address = f.address().streetAddress();
    	this.zipCode = f.address().zipCode();
    	this.city = f.address().city();
    	this.country = f.address().country();
    	this.state = 1;
    }
    
    
}
