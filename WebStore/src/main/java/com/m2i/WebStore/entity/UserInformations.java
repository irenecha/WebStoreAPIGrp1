package com.m2i.WebStore.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.javafaker.Faker;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity @Table(name="user_informations")
@Getter @Setter @ToString @AllArgsConstructor
public class UserInformations {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_informations")
	private int idInformations;
	
	private String adress;
	
	private String city;
	
	private String email;
	
	private String phoneNumber;
	
	@OneToOne( cascade = CascadeType.ALL ) 
    @JoinColumn( name="id_informations" )	
	@JsonIgnore
    private User user;

	public UserInformations() {
		super();
		
		Faker faker=new Faker();
		this.adress = faker.address().streetAddress();
		this.city = faker.address().city();
		this.email = faker.internet().emailAddress();
		this.phoneNumber = faker.phoneNumber().cellPhone();
	}
	
	

}
