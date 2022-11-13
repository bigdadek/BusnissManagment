package com.gestionCommerciale.entities.products;

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
@Table(name = "Categories")

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Categorie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID_Categorie")
	private Long id ;
	
	@Column(name="Categorie_Name", nullable=false, length=20)
	private String name ;
	
	// *** Relations ***
	
	@OneToMany(mappedBy = "categorie")
	private List<Product> products;

}
