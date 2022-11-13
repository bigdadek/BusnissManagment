package com.gestionCommerciale.services.products;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestionCommerciale.entities.products.Categorie;
import com.gestionCommerciale.repositories.products.CategorieRepository;
import com.gestionCommerciale.services.ServiceInterface;


@Service
public class CategorieService implements ServiceInterface<Categorie>{

	@Autowired
	private CategorieRepository categorieRep;
	
	@Override
	public List<Categorie> getAll() {
		return categorieRep.findAll();
	}

	@Override
	public Optional<Categorie> getById(long id) {
		return categorieRep.findById(id);
	}
	
	@Override
	public Categorie add(Categorie categorie) {
		return categorieRep.save(categorie);
	}

	@Override
	public Categorie update(Categorie categorie) {
		return categorieRep.saveAndFlush(categorie);
	}

	@Override
	public boolean delete(long id) {
		try {
			categorieRep.deleteById(id);
			return true;
		}
		catch (Exception e){
			e.printStackTrace();
		}
		return false;
	}

}
