package com.gestionCommerciale.repositories.buying;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.gestionCommerciale.entities.buying.Supplier;

@CrossOrigin("*")
@Repository

public interface SupplierRepository  extends JpaRepository<Supplier,Long>{

}
