package com.m2i.WebStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.m2i.WebStore.entity.Command;

public interface CommandRepository extends JpaRepository<Command, Integer>{

}
