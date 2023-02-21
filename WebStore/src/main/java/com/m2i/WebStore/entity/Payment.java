package com.m2i.WebStore.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.javafaker.Faker;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Getter @Setter @AllArgsConstructor @ToString
public abstract class Payment {
	
		@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
		@JoinColumn(name="id_payment")
		private int idPayment;
		
		private int amount;
		
		@Column(name="payment_date")
		private Date paymentDate;		
		
		@OneToOne( cascade = CascadeType.ALL ) 
	    @JoinColumn( name="id_command" )
		@JsonIgnore
	    private Command command;
		
		public Payment() {
			super();
			
			Faker faker = new Faker();
		
			this.amount = faker.number().randomDigit();
			this.paymentDate = faker.date().birthday();
			
		}
	

}
