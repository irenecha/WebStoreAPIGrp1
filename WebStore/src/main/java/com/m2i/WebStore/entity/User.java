package com.m2i.WebStore.entity;

import java.util.List;

import com.github.javafaker.Faker;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity @Table(name="users")

@AllArgsConstructor
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
	@Getter  @Setter 
	private List<Role> roles;
	
	@OneToMany(targetEntity = Command.class, mappedBy = "user")
	@Getter  @Setter 
	private List<Command> commands;
	
	@OneToOne( mappedBy = "user")
	@Getter  @Setter 
	private UserInformations informations;
	
	public User() {
		Faker f = new Faker();
		
		this.login = f.name().username();
		this.password = f.internet().password(8, 25, true, true, true);
		this.connectionNumber = f.number().randomDigit();	
		}

	@Override
	public String toString() {
		return "User [idUser=" + idUser + ", login=" + login + ", password=" + password + ", connectionNumber="
				+ connectionNumber + ", roles=" + roles + ", commands=" + commands + ", informations=" + informations
				+ "]";
	}

	
}
