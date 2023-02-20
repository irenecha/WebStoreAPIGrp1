package com.m2i.WebStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.m2i.WebStore.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Integer>{

}
