package com.gestionCommerciale.entities.saling;

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
@Table(name = "Saling_Payments")

@Data
@AllArgsConstructor
@NoArgsConstructor


public class SalingPayment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID_Categorie")
	private Long id ;
	
	@Column(name="Type", nullable=false, length=20)
	private String type ;

	@Column(name="amount", nullable=false, length=20)
	private  double amount ;

	@Column(name="Description", nullable=false, length=20)
	private  String description ;
	
	// *** Relations ***
	
	@ManyToOne(fetch=FetchType.LAZY)
		@JoinColumn(name="Client_ID")
	private Client client;

	@OneToMany(mappedBy = "salingPayment")
		private List<SalingPaymentDetails> salingPaymentDetails;

	
	
}
