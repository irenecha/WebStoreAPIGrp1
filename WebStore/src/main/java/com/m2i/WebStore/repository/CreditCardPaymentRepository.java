package com.m2i.WebStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.m2i.WebStore.entity.CreditCardPayment;

public interface CreditCardPaymentRepository extends JpaRepository<CreditCardPayment, Integer>{

}
