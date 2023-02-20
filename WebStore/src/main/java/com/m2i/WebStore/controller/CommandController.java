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

import com.m2i.WebStore.entity.Command;
import com.m2i.WebStore.services.CommandService;


@RestController
@RequestMapping("/command")
public class CommandController {

	@Autowired
	CommandService cService;

	@GetMapping("/{id}")
	public Command getCommandById(@PathVariable("id") int id) {
		return cService.getById(id);
	}
	
	@GetMapping
	public List<Command> getAll(){
		return cService.getAll();
	}
	
	@PostMapping
	public void postCommand(@RequestBody Command c) {
		cService.create(c);
	}
	
	@PutMapping("/{id}")
	public void putCommand(@PathVariable("id") int id,@RequestBody Command c) {
		cService.update(id, c);
	}
	
	@DeleteMapping("/{id}")
	public void deleteCommand(@PathVariable("id") int id) {
		cService.delete(id);
	}
}
