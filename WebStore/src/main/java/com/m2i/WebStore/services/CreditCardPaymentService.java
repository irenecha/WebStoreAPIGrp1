package com.m2i.WebStore.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.m2i.WebStore.entity.CreditCardPayment;
import com.m2i.WebStore.repository.CreditCardPaymentRepository;

@Service
public class CreditCardPaymentService {
	
	@Autowired
	CreditCardPaymentRepository repo;
	
	public void create(CreditCardPayment c) {
		repo.save(c);
	}

	public CreditCardPayment getById(int id) {
		return repo.findById(id).orElse(null);
	}

	public List<CreditCardPayment> getAll() {
		return repo.findAll();
	}

	public void update(int id, CreditCardPayment c) {
		CreditCardPayment credit = repo.findById(id).orElse(null);
		if (c!= null) {
			credit.setCardNumber(c.getCardNumber());
			credit.setDateExp(c.getDateExp());
			repo.save(credit);
		}
	}

	public void delete(int id) {
		CreditCardPayment credit = repo.findById(id).orElse(null);
		if (credit!= null) {
			repo.delete(credit);
		}
		
	}

}
