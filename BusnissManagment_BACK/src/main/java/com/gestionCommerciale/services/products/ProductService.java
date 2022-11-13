package com.gestionCommerciale.services.products;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestionCommerciale.entities.products.Product;
import com.gestionCommerciale.repositories.products.ProductRepository;
import com.gestionCommerciale.services.ServiceInterface;

@Service
public class ProductService implements ServiceInterface<Product>{

	@Autowired
	private ProductRepository productRep;
	
	@Override
	public List<Product> getAll() {
		return productRep.findAll();
	}

	@Override
	public Optional<Product> getById(long id) {
		return productRep.findById(id);
	}
	
	@Override
	public Product add(Product product) {
		return productRep.save(product);
	}

	@Override
	public Product update(Product product) {
		return productRep.saveAndFlush(product);
	}

	@Override
	public boolean delete(long id) {
		try {
			productRep.deleteById(id);
			return true;
		}
		catch (Exception e){
			e.printStackTrace();
		}
		return false;
	}
}
