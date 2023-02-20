package com.m2i.WebStore.entity;

import jakarta.persistence.Column;
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

@Entity @Table(name = "article")
@Getter @Setter @AllArgsConstructor @ToString
@NoArgsConstructor
public class Article { 
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
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