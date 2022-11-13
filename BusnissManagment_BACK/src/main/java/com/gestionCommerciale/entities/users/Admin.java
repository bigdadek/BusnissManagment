package com.gestionCommerciale.entities.users;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Admins")

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Admin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID_Admin")
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
	
	@Column(name="Password", nullable=false, length=60)
	private String password ;
	
	// *** Relations ***
	
	@Enumerated(EnumType.ORDINAL)
	private Role role ;
	
}
