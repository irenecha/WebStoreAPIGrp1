package com.m2i.WebStore.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity @Table(name = "article")
@Getter @Setter @AllArgsConstructor @ToString
public class Article { 
	
	@Column(name="id_article")
	private int idArticle;
	private String description;
	private String brand;
	private Float price;
	
	
	public Article(String description, String brand, Float price) {
		super();
		this.description = description;
		this.brand = brand;
		this.price = price;
	}	
	
	
	
}