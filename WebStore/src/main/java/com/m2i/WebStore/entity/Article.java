package com.m2i.WebStore.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity @Table
@Getter @Setter @AllArgsConstructor @ToString
public class Article { 
	
	private int idArticle;
	private String description;
	private String brand;
	private Float price;
	

}
