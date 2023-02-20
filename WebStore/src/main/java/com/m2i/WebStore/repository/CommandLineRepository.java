package com.m2i.WebStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.m2i.WebStore.entity.Role;

public interface CommandLineRepository extends JpaRepository<Role, Integer>{

}