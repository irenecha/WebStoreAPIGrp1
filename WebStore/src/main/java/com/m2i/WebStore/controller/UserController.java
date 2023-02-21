package com.m2i.WebStore.controller;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.datatype.Duration;

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
import com.m2i.WebStore.entity.CreditCardPayment;
import com.m2i.WebStore.entity.Payment;
import com.m2i.WebStore.entity.PaypalPayment;
import com.m2i.WebStore.entity.Role;
import com.m2i.WebStore.entity.User;
import com.m2i.WebStore.entity.UserInformations;
import com.m2i.WebStore.services.ArticleService;
import com.m2i.WebStore.services.CommandLineService;
import com.m2i.WebStore.services.CommandService;
import com.m2i.WebStore.services.CreditCardPaymentService;
import com.m2i.WebStore.services.PaypalPaymentService;
import com.m2i.WebStore.services.RoleService;
import com.m2i.WebStore.services.UserInformationsService;
import com.m2i.WebStore.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService uService;
	@Autowired
	RoleService rService;
	@Autowired
	ArticleService aService;
	@Autowired
	UserInformationsService uiService;
	@Autowired
	CommandService cService;
	@Autowired
	CommandLineService clService;
	@Autowired
	PaypalPaymentService ppService;
	@Autowired
	CreditCardPaymentService ccService;
	
	@GetMapping("/fake/{roles}/{commands}/{commandLines}/{payment}")
	public User fakeUser(@PathVariable("roles") int nbRoles, @PathVariable("commands") int nbCommands, @PathVariable("commandLines") int nbCommandLines, @PathVariable("payment") int typePayment) {
		User u = new User();
		uService.create(u);
		UserInformations ui = new UserInformations();
		ui.setUser(u);
		u.setInformations(ui);
		uiService.create(ui);
		

		
		List<Command> newCommands= new ArrayList();
		for (int i =0; i<nbCommands; i++) {
			Command c = new Command(u);
			System.out.println(c);
			cService.create(c);
			if(typePayment==0) {
				PaypalPayment pp=new PaypalPayment();
				pp.setCommand(c);
				c.setPayments(pp);
				ppService.create(pp);
			}
			if(typePayment == 1) {
				CreditCardPayment cc= new CreditCardPayment();
				cc.setCommand(c);
				c.setPayments(cc);
				ccService.create(cc);
			}
			
			List<CommandLine> newCommandLines= new ArrayList();
			for(int j=0; j<nbCommandLines; j++) {
				List<Article> articles = aService.getAll();	
				int nb2 = (int) (Math.random()*articles.size());
				CommandLine cl=new CommandLine(articles.get(nb2));
				cl.setCommand(c);
				clService.create(cl);
				newCommandLines.add(cl);}
			c.setCommandLines(newCommandLines);
			newCommands.add(c);
			}
			u.setCommands(newCommands);
			
			List<Role> roles = rService.getAll();	
			List<Role> newRoles = new ArrayList();
			for (int i = 0; i < nbRoles; i++) {
				System.out.println(roles.size());
				int nb1 = (int) (Math.random()*roles.size());			
				newRoles.add(roles.get(nb1));
				roles.remove(nb1);
			}
			u.setRoles(newRoles);
			System.out.println(newRoles);
		return u;
		}
		
		
	
	
	@GetMapping("/{id}")
	public User getUserById(@PathVariable("id") int id) {
		return uService.getById(id);
	}
	
	@GetMapping
	public List<User> getAll(){
		return uService.getAll();
	}
	
	@PostMapping
	public void postUser(@RequestBody User u) {
		uService.create(u);
	}
	
	@PutMapping("/{id}")
	public void putUser(@PathVariable("id") int id,@RequestBody User u) {
		uService.update(id, u);
	}
	
	@DeleteMapping("/{id}")
	public void deleteEleve(@PathVariable("id") int id) {
		uService.delete(id);
	}
	
	@GetMapping("/total/{idUser}")
	public int getTotalAmountByUserId(@PathVariable("idUser") int id) {
		User u = uService.getById(id);
		List<Command> commands = u.getCommands();
		int amount = 0;
		for(int i = 0; i<commands.size(); i++) {
			Command c = commands.get(i);
			Payment p = c.getPayments();
			amount = amount + p.getAmount();
		}
		return(amount);
	}
	
	@GetMapping("/usercity")
	public List<User> getUserInCity(@RequestParam("city") String ville){
		List<User> users = uService.getAll();
		List<User> usersSameCity = new ArrayList<>();
		for(int i = 0; i<users.size(); i++) {
			User u = users.get(i);
			String c = u.getInformations().getCity();
			if(c.equals(ville)) {
				usersSameCity.add(u);
			}
		}
		return(usersSameCity);
	}
	
	
	@GetMapping("/?city={ville}&duree={date}")
	public List<User> getUserInCityInPeriod(@RequestParam("city") String ville, @RequestParam("duree") int date ){
		List<User> users = uService.getAll();
		List<User> usersSameCity = new ArrayList<>();
		LocalDateTime dateNow = LocalDateTime.now();
		
		for(int i = 0; i<users.size(); i++) {
			User u = users.get(i);
			String c = u.getInformations().getCity();
			if(c.equals(ville)) {
				List<Command> commands = u.getCommands();
				for(int j=0; j<commands.size(); j++) {
					Date d = commands.get(j).getCommandDate();
					Instant current = d.toInstant();
					LocalDateTime ldt = LocalDateTime.ofInstant(current, ZoneId.systemDefault());
					long daysBetween = java.time.Duration.between(ldt, dateNow).toDays();
					if(daysBetween < date) {
						usersSameCity.add(u);
						break;
					}
				}
			}
		}
		return(usersSameCity);
	}
	
}
