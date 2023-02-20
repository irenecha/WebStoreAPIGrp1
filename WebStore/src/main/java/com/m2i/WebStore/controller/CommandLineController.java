package com.m2i.WebStore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.m2i.WebStore.entity.CommandLine;
import com.m2i.WebStore.services.CommandLineService;

public class CommandLineController {


	@Autowired
	CommandLineService cService;
	
	@GetMapping("/fake")
	public CommandLine fakeCommandLine() {
		CommandLine c = new CommandLine();
		cService.create(c);
		return c;
	}
	
	@GetMapping("/{id}")
	public CommandLine getCommandLineById(@PathVariable("id") int id) {
		return cService.getById(id);
	}
	
	@GetMapping
	public List<CommandLine> getAll(){
		return cService.getAll();
	}
	
	@PostMapping
	public void postCommandLine(@RequestBody CommandLine c) {
		cService.create(c);
	}
	
	@PutMapping("/{id}")
	public void putCommandLine(@PathVariable("id") int id,@RequestBody CommandLine c) {
		cService.update(id, c);
	}
	
	@DeleteMapping("/{id}")
	public void deleteCommandLine(@PathVariable("id") int id) {
		cService.delete(id);
	}
	
}
