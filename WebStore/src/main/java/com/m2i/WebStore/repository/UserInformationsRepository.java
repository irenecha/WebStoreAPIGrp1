package com.m2i.WebStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.m2i.WebStore.entity.UserInformations;


public interface UserInformationsRepository extends JpaRepository<UserInformations, Integer>{
	

}