package com.gestionCommerciale.services.saling;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestionCommerciale.entities.saling.SalingBill;
import com.gestionCommerciale.repositories.saling.SalingBillRepository;
import com.gestionCommerciale.services.ServiceInterface;

@Service
public class SalingBillService implements ServiceInterface<SalingBill> {

	@Autowired
	private SalingBillRepository salingBillRep;
	
	@Override
	public List<SalingBill> getAll() {
		return salingBillRep.findAll();
	}

	@Override
	public Optional<SalingBill> getById(long id) {
		return salingBillRep.findById(id);
	}
	
	@Override
	public SalingBill add(SalingBill salingBill) {
		return salingBillRep.save(salingBill);
	}

	@Override
	public SalingBill update(SalingBill salingBill) {
		return salingBillRep.saveAndFlush(salingBill);
	}

	@Override
	public boolean delete(long id) {
		try {
			salingBillRep.deleteById(id);
			return true;
		}
		catch (Exception e){
			e.printStackTrace();
		}
		return false;
	}
}
