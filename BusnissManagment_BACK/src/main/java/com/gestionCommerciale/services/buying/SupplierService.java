package com.gestionCommerciale.services.buying;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestionCommerciale.entities.buying.Supplier;
import com.gestionCommerciale.repositories.buying.SupplierRepository;
import com.gestionCommerciale.services.ServiceInterface;

@Service
public class SupplierService implements ServiceInterface<Supplier> {

	@Autowired
	private SupplierRepository supplierRep;
	
	@Override
	public List<Supplier> getAll() {
		return supplierRep.findAll();
	}

	@Override
	public Optional<Supplier> getById(long id) {
		return supplierRep.findById(id);
	}
	
	@Override
	public Supplier add(Supplier supplier) {
		return supplierRep.save(supplier);
	}

	@Override
	public Supplier update(Supplier supplier) {
		return supplierRep.saveAndFlush(supplier);
	}

	@Override
	public boolean delete(long id) {
		try {
			supplierRep.deleteById(id);
			return true;
		}
		catch (Exception e){
			e.printStackTrace();
		}
		return false;
	}
}
