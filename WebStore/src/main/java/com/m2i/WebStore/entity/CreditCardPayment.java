package com.m2i.WebStore.entity;

import java.util.Date;

import com.github.javafaker.Faker;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="credit_card_payments")
@Getter @Setter @ToString @AllArgsConstructor
public class CreditCardPayment extends Payment {
		
		@Column(name="card_number")
		private String cardNumber;
		
		@Column(name="expiration_date")
		private Date dateExp;
		
		public CreditCardPayment() {
			super();
			
			Faker faker = new Faker();
		
			this.cardNumber = faker.toString();
			this.dateExp = faker.date().birthday();
			
		}

}
