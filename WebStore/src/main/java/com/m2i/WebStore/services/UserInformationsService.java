package com.m2i.WebStore.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.m2i.WebStore.entity.UserInformations;
import com.m2i.WebStore.repository.UserInformationsRepository;

@Service
public class UserInformationsService {
	
	@Autowired
	UserInformationsRepository repo;
	
	public UserInformations getById(int id) {
		return repo.findById(id).orElse(null);
	}
	
	public List<UserInformations> getAll(){
		return repo.findAll();
	}
	
	public void delete(int id) {
		UserInformations ui = repo.findById(id).orElse(null);
		if(ui !=null) repo.delete(ui);;
	}
	
	public void create(UserInformations ui) {
		repo.save(ui);
	}
	
	public void update(int id, UserInformations ui) {
		UserInformations userInformationsInDB = repo.findById(id).orElse(null);
		if(ui!=null) {
			userInformationsInDB.setAdress(ui.getAdress());
			userInformationsInDB.setCity(ui.getCity());
			userInformationsInDB.setEmail(ui.getEmail());
			userInformationsInDB.setPhoneNumber(ui.getPhoneNumber());
			repo.save(userInformationsInDB);
		}
	}

}
