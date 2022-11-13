package com.gestionCommerciale.entities.saling;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Clients")

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID_Client")
	private Long id ;
	
	@Column(name="First_Name", nullable=false, length=50)
	private String firstName ;
	
	@Column(name="Last_Name", nullable=false, length=50)
	private String lastName ; 
	
	@Column(name="Phone", nullable=false, length=30)
	private  String phone ;
	
	@Column(name="Email", nullable=false, length=60)
	private  String email ;
	
	@Column(name="Adresse", nullable=false, length=60)
	private String adresse ;
	
	// *** Relations ***
	
	@OneToMany(mappedBy = "client")
	private List<SalingBill> salingBills;

	@OneToMany(mappedBy = "client")
	private List<SalingPayment> salingPayment;


}
