package com.m2i.WebStore.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.m2i.WebStore.entity.Payment;
import com.m2i.WebStore.repository.PaymentRepository;

@Service
public class PaymentService {
	
	@Autowired
	PaymentRepository repo;
	
	public void create(Payment payment) {
		repo.save(payment);
	}

	public Payment getById(int id) {
		return repo.findById(id).orElse(null);
	}

	public List<Payment> getAll() {
		return repo.findAll();
	}

	public void update(int id, Payment p) {
		Payment payment = repo.findById(id).orElse(null);
		if (p!= null) {
			payment.setAmount(p.getAmount());
			payment.setPaymentDate( p.getPaymentDate() );
			repo.save(payment);
		}
	}

	public void delete(int id) {
		Payment payment = repo.findById(id).orElse(null);
		if (payment!= null) {
			repo.delete(payment);
		}
		
	}

}
