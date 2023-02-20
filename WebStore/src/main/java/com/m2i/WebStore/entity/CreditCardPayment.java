package com.m2i.WebStore.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="credit_card_payments")
@PrimaryKeyJoinColumn(name="id_payment")
@Getter @Setter @NoArgsConstructor @ToString @AllArgsConstructor
public class CreditCardPayment extends Payment {
		
		@Column(name="card_number")
		private String cardNumber;
		
		@Column(name="expiration_date")
		private String dateExp;

}
