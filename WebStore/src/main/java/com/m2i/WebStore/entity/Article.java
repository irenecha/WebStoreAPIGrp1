package com.m2i.WebStore.entity;

import com.github.javafaker.Faker;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity @Table(name = "article")
@Getter @Setter @AllArgsConstructor
public class Article { 
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_article")
	private int idArticle;
	private String description;
	private String brand;
	private Double price;
	
	public Article() {
		Faker f = new Faker();
		this.description = f.lorem().characters(200, 240);
		this.brand = f.company().name();
		this.price = f.number().randomDouble(2, 1, 5000);
	}
}