package com.gestionCommerciale.services.saling;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestionCommerciale.entities.saling.SalingPayment;
import com.gestionCommerciale.repositories.saling.SalingPaymentRepository;
import com.gestionCommerciale.services.ServiceInterface;

@Service
public class SalingPaymentService implements ServiceInterface<SalingPayment> {

	@Autowired
	private SalingPaymentRepository salingPaymentRep;
	
	@Override
	public List<SalingPayment> getAll() {
		return salingPaymentRep.findAll();
	}

	@Override
	public Optional<SalingPayment> getById(long id) {
		return salingPaymentRep.findById(id);
	}
	
	@Override
	public SalingPayment add(SalingPayment salingPayment) {
		return salingPaymentRep.save(salingPayment);
	}

	@Override
	public SalingPayment update(SalingPayment salingPayment) {
		return salingPaymentRep.saveAndFlush(salingPayment);
	}

	@Override
	public boolean delete(long id) {
		try {
			salingPaymentRep.deleteById(id);
			return true;
		}
		catch (Exception e){
			e.printStackTrace();
		}
		return false;
	}
}
