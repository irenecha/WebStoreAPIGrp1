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

import com.m2i.WebStore.entity.PaypalPayment;
import com.m2i.WebStore.services.PaypalPaymentService;


@RestController
@RequestMapping("/paypalpayment")
public class PaypalController {
	
	@Autowired
	PaypalPaymentService pService;
	
	@GetMapping("/{id}")
	public PaypalPayment getUserInformationsById(@PathVariable("id") int id) {
		return pService.getById(id);
	}
	
	
	@GetMapping
	public List<PaypalPayment> getAllUserInformations(){
		return pService.getAll();
	}
	
	@PostMapping
	public void postUserInfomations(@RequestBody PaypalPayment pp) {
		pService.create(pp);
	}
	

	@PutMapping("/{id}")
	public void putUserInformations(@PathVariable("id") int id,@RequestBody PaypalPayment pp) {
		pService.update(id, pp);
	}
	
	@DeleteMapping("/{id}")
	public void deleteUserInformations(@PathVariable("id") int id) {
		pService.delete(id);
	}

}
