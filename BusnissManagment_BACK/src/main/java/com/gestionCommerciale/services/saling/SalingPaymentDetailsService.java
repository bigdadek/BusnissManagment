package com.gestionCommerciale.services.saling;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestionCommerciale.entities.saling.SalingPaymentDetails;
import com.gestionCommerciale.repositories.saling.SalingPaymentDetailsRepository;
import com.gestionCommerciale.services.ServiceInterface;

@Service
public class SalingPaymentDetailsService implements ServiceInterface<SalingPaymentDetails> {

	@Autowired
	private SalingPaymentDetailsRepository salingPaymentDetailsRep;
	
	@Override
	public List<SalingPaymentDetails> getAll() {
		return salingPaymentDetailsRep.findAll();
	}

	@Override
	public Optional<SalingPaymentDetails> getById(long id) {
		return salingPaymentDetailsRep.findById(id);
	}
	
	@Override
	public SalingPaymentDetails add(SalingPaymentDetails salingPaymentDetails) {
		return salingPaymentDetailsRep.save(salingPaymentDetails);
	}

	@Override
	public SalingPaymentDetails update(SalingPaymentDetails salingPaymentDetails) {
		return salingPaymentDetailsRep.saveAndFlush(salingPaymentDetails);
	}

	@Override
	public boolean delete(long id) {
		try {
			salingPaymentDetailsRep.deleteById(id);
			return true;
		}
		catch (Exception e){
			e.printStackTrace();
		}
		return false;
	}
}
