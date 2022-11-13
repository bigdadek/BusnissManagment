package com.gestionCommerciale.repositories.employes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.gestionCommerciale.entities.employes.Employee;

@CrossOrigin("*")
@Repository

public interface EmployeeRepository extends JpaRepository<Employee,Long>{

}
