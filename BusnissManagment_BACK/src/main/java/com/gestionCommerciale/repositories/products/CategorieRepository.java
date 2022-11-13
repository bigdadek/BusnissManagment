package com.gestionCommerciale.repositories.products;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.gestionCommerciale.entities.products.Categorie;

@CrossOrigin("*")
@Repository

public interface CategorieRepository  extends JpaRepository<Categorie,Long>{

}
