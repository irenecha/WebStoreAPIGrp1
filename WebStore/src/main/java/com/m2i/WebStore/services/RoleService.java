package com.m2i.WebStore.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.m2i.WebStore.entity.Role;
import com.m2i.WebStore.repository.RoleRepository;

@Service
public class RoleService {
	
	@Autowired
	RoleRepository repo;
	
	public Role getById(int id) {
		return repo.findById(id).orElse(null);
	}
	
	public List<Role> getAll(){
		return repo.findAll();
	}
	
	public void delete(int id) {
		Role r = repo.findById(id).orElse(null);
		if(r !=null) repo.delete(r);;
	}
	
	public void create(Role r) {
		repo.save(r);
	}
	
	public void update(int id, Role r) {
		Role RoleInDB = repo.findById(id).orElse(null);
		if(r!=null) {
			RoleInDB.setRoleName(r.getRoleName());
			repo.save(RoleInDB);
		}
	}

}
