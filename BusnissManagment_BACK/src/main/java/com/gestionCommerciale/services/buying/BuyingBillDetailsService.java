package com.gestionCommerciale.services.buying;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestionCommerciale.entities.buying.BuyingBillDetails;
import com.gestionCommerciale.repositories.buying.BuyingBillDetailsRepository;
import com.gestionCommerciale.services.ServiceInterface;

@Service
public class BuyingBillDetailsService implements ServiceInterface<BuyingBillDetails>{

	@Autowired
	private BuyingBillDetailsRepository buyingBillDetailsRep;
	
	@Override
	public List<BuyingBillDetails> getAll() {
		return buyingBillDetailsRep.findAll();
	}

	@Override
	public Optional<BuyingBillDetails> getById(long id) {
		return buyingBillDetailsRep.findById(id);
	}
	
	@Override
	public BuyingBillDetails add(BuyingBillDetails buyingBillDetails) {
		return buyingBillDetailsRep.save(buyingBillDetails);
	}

	@Override
	public BuyingBillDetails update(BuyingBillDetails buyingBillDetails) {
		return buyingBillDetailsRep.saveAndFlush(buyingBillDetails);
	}

	@Override
	public boolean delete(long id) {
		try {
			buyingBillDetailsRep.deleteById(id);
			return true;
		}
		catch (Exception e){
			e.printStackTrace();
		}
		return false;
	}
}
