package com.m2i.WebStore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.m2i.WebStore.entity.Role;
import com.m2i.WebStore.entity.User;
import com.m2i.WebStore.entity.UserInformations;
import com.m2i.WebStore.services.RoleService;
import com.m2i.WebStore.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService uService;
	@Autowired
	RoleService rService;
	
	@GetMapping("/fake/{roles}")
	public User fakeUser(@PathVariable("roles") int nbRoles) {
		User u = new User();
		u.setInformations(new UserInformations(u));
		
		List<Role> roles = rService.getAll();		
		for (int i = 0; i < nbRoles; i++) {
			int nb = (int) Math.random()*roles.size();			
			u.getRoles().add(roles.get(nb));
		}
		
		uService.create(u);
		return u;
	}
	
	
	@GetMapping("/{id}")
	public User getUserById(@PathVariable("id") int id) {
		return uService.getById(id);
	}
	
	@GetMapping
	public List<User> getAll(){
		return uService.getAll();
	}
	
	@PostMapping
	public void postUser(@RequestBody User u) {
		uService.create(u);
	}
	
	@PutMapping("/{id}")
	public void putUser(@PathVariable("id") int id,@RequestBody User u) {
		uService.update(id, u);
	}
	
	@DeleteMapping("/{id}")
	public void deleteEleve(@PathVariable("id") int id) {
		uService.delete(id);
	}
}
