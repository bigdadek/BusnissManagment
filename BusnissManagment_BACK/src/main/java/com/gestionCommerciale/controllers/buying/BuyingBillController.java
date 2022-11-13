package com.gestionCommerciale.controllers.buying;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gestionCommerciale.entities.buying.BuyingBill;
import com.gestionCommerciale.services.buying.BuyingBillService;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class BuyingBillController {
	
	@Autowired
	private BuyingBillService buyingBillService;
	
	@GetMapping("/buyingBills")
	public List<BuyingBill> getAllBuyingBill(){
		return buyingBillService.getAll();
	}		
	
	@GetMapping("/buyingBill/{id}")
	public Optional<BuyingBill> getBuyingBillById(@PathVariable Long id) {
		return buyingBillService.getById(id);
	}
	
	@PostMapping("/buyingBill")
	public ResponseEntity<BuyingBill> createBuyingBill(@RequestBody BuyingBill buyingBill) {
		BuyingBill createdBuyingBill = buyingBillService.add(buyingBill); 
		 return ResponseEntity.ok(createdBuyingBill);
	}
	
	@PutMapping("/buyingBill/{id}")
	public ResponseEntity<BuyingBill> updateBuyingBill(@PathVariable Long id, @RequestBody BuyingBill buyingBillDetails){
		buyingBillDetails.setId(id);
		BuyingBill updatedBuyingBill = buyingBillService.update(buyingBillDetails);
		return ResponseEntity.ok(updatedBuyingBill);
	}
	
	@DeleteMapping("/buyingBill/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteBuyingBill(@PathVariable Long id){
		buyingBillService.delete(id);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}
