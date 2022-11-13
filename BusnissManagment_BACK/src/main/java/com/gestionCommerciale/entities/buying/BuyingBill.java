package com.gestionCommerciale.entities.buying;

import java.util.Date;
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
@Table(name = "Buying_Bills")

@Data
@AllArgsConstructor
@NoArgsConstructor

public class BuyingBill {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID_BuyingBill")
	private Long id ;
	
	@Column(name="billNumber", nullable=false, length=20)
	private Long bill_number;
	
	@Column(name="bill_date", nullable=false, length=50)
	private Date date ;
	
	@Column(name="description", nullable=false, length=512)
	private String description ;
	
	// *** Relations ***

	@ManyToOne(fetch=FetchType.LAZY)
		@JoinColumn(name="Supplier_ID")
	private Supplier supplier;

	@OneToMany(mappedBy = "buyingBill")
		private List<BuyingBillDetails> buyingBillDetails;

}

