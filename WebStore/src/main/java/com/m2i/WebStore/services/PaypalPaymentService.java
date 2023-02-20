package com.m2i.WebStore.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.m2i.WebStore.entity.PaypalPayment;
import com.m2i.WebStore.repository.PaypalPaymentRepository;

@Service
public class PaypalPaymentService {
	
	@Autowired
	PaypalPaymentRepository repo;
	
	public void create(PaypalPayment paypal) {
		repo.save(paypal);
	}

	public PaypalPayment getById(int id) {
		return repo.findById(id).orElse(null);
	}

	public List<PaypalPayment> getAll() {
		return repo.findAll();
	}

	public void update(int id, PaypalPayment p) {
		PaypalPayment paypal = repo.findById(id).orElse(null);
		if (p!= null) {
			paypal.setAccountNumber(p.getAccountNumber());
			repo.save(paypal);
		}
	}

	public void delete(int id) {
		PaypalPayment paypal = repo.findById(id).orElse(null);
		if (paypal!= null) {
			repo.delete(paypal);
		}
		
	}

}
