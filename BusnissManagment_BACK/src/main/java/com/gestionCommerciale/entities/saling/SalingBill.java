package com.gestionCommerciale.entities.saling;

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
@Table(name = "Saling_Bills")

@Data
@AllArgsConstructor
@NoArgsConstructor

public class SalingBill {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID_SalingBill")
	private Long id ;
	
	@Column(name="billNumber", nullable=false, length=20)
	private Long bill_number;
	
	@Column(name="date", nullable=false, length=50)
	private Date date ;
	
	@Column(name="description", nullable=false, length=512)
	private String description ;
	
	// *** Relations ***

	@ManyToOne(fetch=FetchType.LAZY)
		@JoinColumn(name="Client_ID")
	private Client client;


	@OneToMany(mappedBy = "salingBill")
		private List<SalingBillDetails> salingBillDetails;

}
