package com.gestionCommerciale.services.buying;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestionCommerciale.entities.buying.BuyingPaymentDetails;
import com.gestionCommerciale.repositories.buying.BuyingPaymentDetailsRepository;
import com.gestionCommerciale.services.ServiceInterface;

@Service
public class BuyingPaymentDetailsService implements ServiceInterface<BuyingPaymentDetails>{

	@Autowired
	private BuyingPaymentDetailsRepository buyingPaymentDetailsRep;
	
	@Override
	public List<BuyingPaymentDetails> getAll() {
		return buyingPaymentDetailsRep.findAll();
	}

	@Override
	public Optional<BuyingPaymentDetails> getById(long id) {
		return buyingPaymentDetailsRep.findById(id);
	}
	
	@Override
	public BuyingPaymentDetails add(BuyingPaymentDetails buyingPaymentDetails) {
		return buyingPaymentDetailsRep.save(buyingPaymentDetails);
	}

	@Override
	public BuyingPaymentDetails update(BuyingPaymentDetails buyingPaymentDetails) {
		return buyingPaymentDetailsRep.saveAndFlush(buyingPaymentDetails);
	}

	@Override
	public boolean delete(long id) {
		try {
			buyingPaymentDetailsRep.deleteById(id);
			return true;
		}
		catch (Exception e){
			e.printStackTrace();
		}
		return false;
	}
}
