package com.m2i.WebStore.entity;

import java.util.List;

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

@AllArgsConstructor @NoArgsConstructor
@ToString
public class User {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter
	private int idUser;
	
	@Getter  @Setter 
	private String login;
	
	@Getter  @Setter 
	private String password;
	
	@Getter  @Setter 
	private int connectionNumber;
	
	@ManyToMany
    @JoinTable( name = "user_role_association",
			    joinColumns = @JoinColumn( name = "id_user" ),
			    inverseJoinColumns = @JoinColumn( name = "id_role" ) )
	private List<Role> roles;
	
	@OneToMany(targetEntity = Command.class, mappedBy = "user")
	private List<Command> commands;

}
