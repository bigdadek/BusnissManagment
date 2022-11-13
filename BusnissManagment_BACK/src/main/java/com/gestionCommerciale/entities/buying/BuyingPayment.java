package com.gestionCommerciale.entities.buying;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Buying_Bill_Payments")

@Data
@AllArgsConstructor
@NoArgsConstructor


public class BuyingPayment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID_Categorie")
	private Long id ;
	
	@Column(name="Payment_Type", nullable=false, length=20)
	private String type ;

	@Column(name="amount", nullable=false, length=20)
	private  double amount ;

	@Column(name="Description", nullable=false, length=20)
	private  String description ;
	
	// *** Relations ***
	
	@ManyToOne(fetch=FetchType.LAZY)
		@JoinColumn(name="Supplier_ID")
	private Supplier supplier;

	@OneToMany(mappedBy = "buyingPayment")
		private List<BuyingPaymentDetails> buyingPaymentDetails;

}
