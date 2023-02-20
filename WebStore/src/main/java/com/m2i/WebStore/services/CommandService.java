package com.m2i.WebStore.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.m2i.WebStore.entity.Command;
import com.m2i.WebStore.repository.CommandRepository;


@Service
public class CommandService {

	@Autowired
	CommandRepository repo;
	
	public void create(Command c) {
		repo.save(c);
	}

	public Command getById(int id) {
		return repo.findById(id).orElse(null);
	}

	public List<Command> getAll() {
		return repo.findAll();
	}

	public void update(int id, Command c) {
		Command command = repo.findById(id).orElse(null);
		if (c!= null) {
			command.setCommandDate( c.getCommandDate() );
			repo.save(command);
		}
	}

	public void delete(int id) {
		Command command = repo.findById(id).orElse(null);
		if (command!= null) {
			repo.delete(command);
		}
		
	}
}
