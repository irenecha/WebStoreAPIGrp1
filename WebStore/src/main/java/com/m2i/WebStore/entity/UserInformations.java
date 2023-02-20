package com.m2i.WebStore.entity;

import jakarta.persistence.CascadeType;
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
@Getter @Setter @NoArgsConstructor @ToString @AllArgsConstructor
public class UserInformations {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idInformations;
	
	private String adress;
	
	private String city;
	
	private String email;
	
	private String phoneNumber;
	
	@OneToOne( cascade = CascadeType.ALL ) 
    @JoinColumn( name="id_user" )
    private User user;

}
