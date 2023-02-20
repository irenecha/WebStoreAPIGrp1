package com.m2i.WebStore.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.m2i.WebStore.entity.CommandLine;
import com.m2i.WebStore.repository.CommandLineRepository;

@Service
public class CommandLineService {

	@Autowired
	CommandLineRepository repo;
	
	public void create(CommandLine c) {
		repo.save(c);
	}

	public CommandLine getById(int id) {
		return repo.findById(id).orElse(null);
	}

	public List<CommandLine> getAll() {
		return repo.findAll();
	}

	public void update(int id, CommandLine c) {
		CommandLine commandLine = repo.findById(id).orElse(null);
		if (c!= null) {
			commandLine.setQuantity(c.getQuantity());
			commandLine.setArticle(c.getArticle());
			commandLine.setCommand(c.getCommand());
			repo.save(commandLine);
		}
	}

	public void delete(int id) {
		CommandLine commandLine = repo.findById(id).orElse(null);
		if (commandLine!= null) {
			repo.delete(commandLine);
		}	
	}
}
