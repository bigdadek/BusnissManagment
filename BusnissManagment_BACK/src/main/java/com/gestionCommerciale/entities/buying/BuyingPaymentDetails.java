package com.gestionCommerciale.entities.buying;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Buying_Payment_Details")

@Data
@AllArgsConstructor
@NoArgsConstructor

public class BuyingPaymentDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID_BuyingBill")
	private Long id ;
	
	@Column(name="paid_amount", nullable=false, length=20)
	private double paid_amount ;

	// *** Relations ***
	
	@ManyToOne(fetch=FetchType.LAZY)
		@JoinColumn(name="Payment_ID")
	private BuyingPayment buyingPayment;

	@ManyToOne(fetch=FetchType.LAZY)
		@JoinColumn(name="Bill_ID")
	private BuyingBill buyingBill;

}