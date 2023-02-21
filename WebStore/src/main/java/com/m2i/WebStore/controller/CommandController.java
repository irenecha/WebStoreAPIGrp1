package com.m2i.WebStore.controller;

import java.util.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.m2i.WebStore.entity.Article;
import com.m2i.WebStore.entity.Command;
import com.m2i.WebStore.entity.CommandLine;
import com.m2i.WebStore.entity.Payment;
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
	
	@GetMapping("/getArticles/{idCommande}")
	public List<Article> getAllArticleInCommand(@PathVariable("idCommande") int id){
		Command c = cService.getById(id);
		List<CommandLine> commandLines = c.getCommandLines();
		List<Article> articles = new ArrayList<>();
		for(int i = 0; i<commandLines.size(); i++) {
			CommandLine cl = commandLines.get(i);
			articles.add(cl.getArticle());		
		}
		return(articles);
	}
	
	@GetMapping("/ca/{dateStart}/{dateEnd}")
	public int getCAInPeriod(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateStart, @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateEnd ) {
		List <Command> commands = cService.getAll();
		int amount = 0;
		for(int i = 0; i<commands.size(); i++) {
			Command c = commands.get(i);
			Date d = c.getCommandDate();
			if(d.after(dateStart) && d.before(dateEnd)) {
				Payment p = c.getPayments();
				amount = amount + p.getAmount();
			}			
		}
		return(amount);
	}
}
