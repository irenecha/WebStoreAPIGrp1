package com.m2i.WebStore.entity;

import com.github.javafaker.Faker;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="paypal_payments")
@Getter @Setter @AllArgsConstructor @ToString
public class PaypalPayment extends Payment {
		
		@Column(name="account_number")
		private String AccountNumber;
		
		public PaypalPayment() {
			super();
			Faker faker = new Faker();
			
			this.AccountNumber = faker.toString();
		}

}