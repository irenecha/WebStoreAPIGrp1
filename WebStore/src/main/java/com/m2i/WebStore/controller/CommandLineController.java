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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.m2i.WebStore.entity.Article;
import com.m2i.WebStore.entity.Command;
import com.m2i.WebStore.entity.CommandLine;
import com.m2i.WebStore.repository.CommandRepository;
import com.m2i.WebStore.services.ArticleService;
import com.m2i.WebStore.services.CommandLineService;
import com.m2i.WebStore.services.CommandService;

@RestController
@RequestMapping("/commandline")
public class CommandLineController {


	@Autowired
	CommandLineService clService;
	@Autowired
	ArticleService aService;
	@Autowired
	CommandService cService;
	@Autowired
	CommandRepository repo;
	
	
	@GetMapping("/{id}")
	public CommandLine getCommandLineById(@PathVariable("id") int id) {
		return clService.getById(id);
	}
	
	@GetMapping
	public List<CommandLine> getAllCommandLines(){
		return clService.getAll();
	}
	
	@PostMapping
	public void postCommandLine(@RequestBody CommandLine c) {
		clService.create(c);
	}
	
	@PutMapping("/{id}")
	public void putCommandLine(@PathVariable("id") int id,@RequestBody CommandLine c) {
		clService.update(id, c);
	}
	
	@DeleteMapping("/{id}")
	public void deleteCommandLine(@PathVariable("id") int id) {
		clService.delete(id);
	}
	
	@PostMapping("/newarticle")
	public Command addArticleCommandById(@RequestParam ("idCommand") int id ) {
		Article a = new Article();
		aService.create(a);
		CommandLine cl = new CommandLine(a);
		clService.create(cl);
		Command c = cService.getById(id);
		cl.setCommand(c);
		List<CommandLine> commandLines = c.getCommandLines();
		commandLines.add(cl);
		c.setCommandLines(commandLines);
		repo.save(c);
		return c;
		
		
		
		
		
	}
	
}
