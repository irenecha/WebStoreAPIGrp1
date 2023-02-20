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

import com.m2i.WebStore.entity.Article;
import com.m2i.WebStore.entity.CreditCardPayment;
import com.m2i.WebStore.services.CreditCardPaymentService;

@RestController
@RequestMapping("/creditcardpayment")
public class CreditCardController {

	@Autowired
	CreditCardPaymentService ccService;
	
	@GetMapping("/{id}")
	public CreditCardPayment getCreditCardPaymentById(@PathVariable("id") int id) {
		return ccService.getById(id);
	}
	
	@GetMapping
	public List<CreditCardPayment> getAllCreditCardPayments(){
		return ccService.getAll();
	}
	
	@PostMapping
	public void postCreditCardPayment(@RequestBody CreditCardPayment c) {
		ccService.create(c);
	}
	
	@PutMapping("/{id}")
	public void putCreditCardPayment(@PathVariable("id") int id,@RequestBody CreditCardPayment c) {
		ccService.update(id, c);
	}
	
	@DeleteMapping("/{id}")
	public void deleteCreditCardPayment(@PathVariable("id") int id) {
		ccService.delete(id);
	}
}