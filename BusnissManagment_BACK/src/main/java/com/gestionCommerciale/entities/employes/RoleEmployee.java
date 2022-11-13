package com.gestionCommerciale.entities.employes;

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
@Table(name = "Roles_Employee")

@Data
@AllArgsConstructor
@NoArgsConstructor

public class RoleEmployee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID_Categorie")
	private Long id ;
	
	@Column(name="Role_Name", nullable=false, length=512)
	private String name ;
	
	// *** Relations ***
	
	@OneToMany(mappedBy = "roleEmployee")
	private List<Employee> employes;

}
