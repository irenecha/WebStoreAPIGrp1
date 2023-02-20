package com.m2i.WebStore.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity @Table(name="user")

@AllArgsConstructor @NoArgsConstructor
@ToString
public class User {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter
	private int id;
	
	@Getter  @Setter 
	private String login;
	
	@Getter  @Setter 
	private String password;
	
	@Getter  @Setter 
	private int connectionNumber;

}
