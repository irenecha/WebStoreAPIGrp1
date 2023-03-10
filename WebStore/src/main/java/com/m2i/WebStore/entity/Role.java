package com.m2i.WebStore.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;

import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity @Table(name="role")
@Getter @Setter @NoArgsConstructor
public class Role {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idRole;
	
	private String roleName;
	
	@ManyToMany
    @JoinTable( name = "user_role_association",
			    joinColumns = @JoinColumn( name = "id_role" ),
			    inverseJoinColumns = @JoinColumn( name = "id_user" ) )
	private List<User> users;

	public Role(String roleName) {
		super();
		this.roleName = roleName;
	}

	@Override
	public String toString() {
		return "Role [idRole=" + idRole + ", roleName=" + roleName + "]";
	}

	
	

}
