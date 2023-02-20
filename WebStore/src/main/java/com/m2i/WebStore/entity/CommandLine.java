package com.m2i.WebStore.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class CommandLine {
	
	@Id @GeneratedValue( strategy = GenerationType.IDENTITY)
	private int id;
	private int quantity;
	

}
