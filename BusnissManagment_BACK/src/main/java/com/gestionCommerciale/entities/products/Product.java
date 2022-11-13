package com.gestionCommerciale.entities.products;

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

import com.gestionCommerciale.entities.saling.SalingBillDetails;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Products")

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID_Product")
	private Long id ;
	
	@Column(name="Product_Name", nullable=false, length=50)
	private String name ;

	@Column(name="description", nullable=false, length=512)
	private String description ;
	
	@Column(name="price_buy", nullable=false, length=20)
	private double price_buy  ;
	
	@Column(name="price_sale", nullable=false, length=20)
	private double price_sale ;
	
	@Column(name="stock_in", nullable=false, length=20) 
	private Long stock_in ;
	
	@Column(name="stock_out", nullable=false, length=20)
	private Long stock_out ;
	
	@Column(name="stock", nullable=false, length=20)
	private Long stock ;
	
	@Column(name="unity", nullable=false, length=20)
	private Long unity ;
	
	// *** Relations *** 
	
	@ManyToOne(fetch=FetchType.LAZY)
		@JoinColumn(name="Categorie_ID")
	private Categorie categorie ; 
	
	@OneToMany(mappedBy = "product")
	private List<SalingBillDetails> salingBillDetails;

}
