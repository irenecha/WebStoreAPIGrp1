package com.m2i.WebStore.entity;

import com.github.javafaker.Faker;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity @Table(name="commandLine")
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class CommandLine {
	
	@Id @GeneratedValue( strategy = GenerationType.IDENTITY)
	@Column(name="id_command_line")
	private int idCommandLine;
	private int quantity;
	
	@ManyToOne
	@JoinColumn(name = "id_command")
	private Command command;
	
	@ManyToOne
	@JoinColumn(name = "id_article")
	private Article article;
	
	public CommandLine(Command c) {
		Faker f = new Faker();
		this.command = c;
		this.quantity = f.number().numberBetween(0, 400);
	}
	
	public CommandLine(Article a) {
		Faker f = new Faker();
		this.article = a;
		this.quantity = f.number().numberBetween(0, 400);
	}

	@Override
	public String toString() {
		return "CommandLine [idCommandLine=" + idCommandLine + ", quantity=" + quantity + ", article=" + article + "]";
	}
	
	
	
}