package com.m2i.WebStore.entity;

import java.util.Date;

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
import lombok.ToString;

@Entity @Table(name="command")

@AllArgsConstructor @NoArgsConstructor
@ToString
public class Command {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter
	private int idCommand;
	
	private Date commandDate;
	
	@ManyToOne
	@JoinColumn(name="id_user")
	private User user;
}
