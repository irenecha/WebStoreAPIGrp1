package com.m2i.WebStore.entity;

import java.util.Date;
import java.util.List;

import com.github.javafaker.Faker;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity @Table(name="command")

@AllArgsConstructor
@ToString
public class Command {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter
	@Column(name="id_command")
	private int idCommand;
	
	@Getter @Setter
	@Column(name="command_date")
	private Date commandDate;
	
	@ManyToOne
	@JoinColumn(name="id_user")
	private User user;
	
	@OneToMany(targetEntity = CommandLine.class, mappedBy = "command")
	private List<CommandLine> commandLines;
	
	@OneToOne( mappedBy = "command")	
	private Payment payments;
	
	public Command(User u) {
		Faker f = new Faker();
		this.user = u;
		this.commandDate = f.date().birthday();
	}
}
