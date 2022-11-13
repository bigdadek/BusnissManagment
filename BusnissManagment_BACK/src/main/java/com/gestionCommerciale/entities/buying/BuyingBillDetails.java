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

import com.gestionCommerciale.entities.products.Product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Buying_Bill_Details")

@Data
@AllArgsConstructor
@NoArgsConstructor


public class BuyingBillDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID_BuyingBillDetails")
	private Long id ;
	
	@Column(name="price", nullable=false, length=20)
	private double price ;
	
	@Column(name="numbre_products", nullable=false, length=20)
	private Long numbre_products ;
	
	@Column(name="totale_price", nullable=false, length=20)
	private  double totale_price ;

	@Column(name="unity", nullable=false, length=20)
	private  String unity ;
	
	// *** Relations ***

	@ManyToOne(fetch=FetchType.LAZY)
		@JoinColumn(name="Product_ID")
	private Product product;
	
	@ManyToOne(fetch=FetchType.LAZY)
		@JoinColumn(name="BuyingBill_ID")
	private BuyingBill buyingBill;

}
