package com.gestionCommerciale.services.buying;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestionCommerciale.entities.buying.BuyingPayment;
import com.gestionCommerciale.repositories.buying.BuyingPaymentRepository;
import com.gestionCommerciale.services.ServiceInterface;

@Service
public class BuyingPaymentService implements ServiceInterface<BuyingPayment> {

	@Autowired
	private BuyingPaymentRepository buyingPaymentRep;
	
	@Override
	public List<BuyingPayment> getAll() {
		return buyingPaymentRep.findAll();
	}

	@Override
	public Optional<BuyingPayment> getById(long id) {
		return buyingPaymentRep.findById(id);
	}
	
	@Override
	public BuyingPayment add(BuyingPayment buyingPayment) {
		return buyingPaymentRep.save(buyingPayment);
	}

	@Override
	public BuyingPayment update(BuyingPayment buyingPayment) {
		return buyingPaymentRep.saveAndFlush(buyingPayment);
	}

	@Override
	public boolean delete(long id) {
		try {
			buyingPaymentRep.deleteById(id);
			return true;
		}
		catch (Exception e){
			e.printStackTrace();
		}
		return false;
	}
}
