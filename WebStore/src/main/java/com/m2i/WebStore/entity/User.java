package com.m2i.WebStore.entity;

import java.util.List;

import com.github.javafaker.Faker;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity @Table(name="user")

@AllArgsConstructor
@ToString
public class User {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter
	@Column(name="id_user")
	private int idUser;
	
	@Getter  @Setter 
	private String login;
	
	@Getter  @Setter 
	private String password;
	
	@Getter  @Setter 
	@Column(name="connection_number")
	private int connectionNumber;
	
	@ManyToMany
    @JoinTable( name = "user_role_association",
			    joinColumns = @JoinColumn( name = "id_user" ),
			    inverseJoinColumns = @JoinColumn( name = "id_role" ) )
	private List<Role> roles;
	
	@OneToMany(targetEntity = Command.class, mappedBy = "user")
	private List<Command> commands;
	
	public User() {
		Faker f = new Faker();
		
		this.login = f.name().username();
		this.password = f.internet().password(8, 25, true, true, true);
		this.connectionNumber = f.number().randomDigit();	
		}

}
