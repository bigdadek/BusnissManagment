package com.gestionCommerciale.services.buying;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestionCommerciale.entities.buying.BuyingBill;
import com.gestionCommerciale.repositories.buying.BuyingBillRepository;
import com.gestionCommerciale.services.ServiceInterface;

@Service
public class BuyingBillService implements ServiceInterface<BuyingBill>{

	@Autowired
	private BuyingBillRepository buyingBillRep;
	
	@Override
	public List<BuyingBill> getAll() {
		return buyingBillRep.findAll();
	}

	@Override
	public Optional<BuyingBill> getById(long id) {
		return buyingBillRep.findById(id);
	}
	
	@Override
	public BuyingBill add(BuyingBill buyingBill) {
		return buyingBillRep.save(buyingBill);
	}

	@Override
	public BuyingBill update(BuyingBill buyingBill) {
		return buyingBillRep.saveAndFlush(buyingBill);
	}

	@Override
	public boolean delete(long id) {
		try {
			buyingBillRep.deleteById(id);
			return true;
		}
		catch (Exception e){
			e.printStackTrace();
		}
		return false;
	}
}
