package com.gestionCommerciale.services.saling;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestionCommerciale.entities.saling.SalingBillDetails;
import com.gestionCommerciale.repositories.saling.SalingBillDetailsRepository;
import com.gestionCommerciale.services.ServiceInterface;

@Service
public class SalingBillDetailsService implements ServiceInterface<SalingBillDetails> {

	@Autowired
	private SalingBillDetailsRepository salingBillDetailsRep;
	
	@Override
	public List<SalingBillDetails> getAll() {
		return salingBillDetailsRep.findAll();
	}

	@Override
	public Optional<SalingBillDetails> getById(long id) {
		return salingBillDetailsRep.findById(id);
	}
	
	@Override
	public SalingBillDetails add(SalingBillDetails salingBillDetails) {
		return salingBillDetailsRep.save(salingBillDetails);
	}

	@Override
	public SalingBillDetails update(SalingBillDetails salingBillDetails) {
		return salingBillDetailsRep.saveAndFlush(salingBillDetails);
	}

	@Override
	public boolean delete(long id) {
		try {
			salingBillDetailsRep.deleteById(id);
			return true;
		}
		catch (Exception e){
			e.printStackTrace();
		}
		return false;
	}
}
