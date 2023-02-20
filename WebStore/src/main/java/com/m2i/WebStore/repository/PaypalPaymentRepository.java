package com.m2i.WebStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.m2i.WebStore.entity.PaypalPayment;

public interface PaypalPaymentRepository extends JpaRepository<PaypalPayment, Integer>{

}
