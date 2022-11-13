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

import com.gestionCommerciale.entities.buying.BuyingPaymentDetails;
import com.gestionCommerciale.services.buying.BuyingPaymentDetailsService;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class BuyingPaymentDetailsController {
	
	@Autowired
	private BuyingPaymentDetailsService buyingPaymentDetailsService;
	
	@GetMapping("/buyingPaymentDetailss")
	public List<BuyingPaymentDetails> getAllBuyingPaymentDetails(){
		return buyingPaymentDetailsService.getAll();
	}		
	
	@GetMapping("/buyingPaymentDetails/{id}")
	public Optional<BuyingPaymentDetails> getBuyingPaymentDetailsById(@PathVariable Long id) {
		return buyingPaymentDetailsService.getById(id);
	}
	
	@PostMapping("/buyingPaymentDetails")
	public ResponseEntity<BuyingPaymentDetails> createBuyingPaymentDetails(@RequestBody BuyingPaymentDetails buyingPaymentDetails) {
		BuyingPaymentDetails createdBuyingPaymentDetails = buyingPaymentDetailsService.add(buyingPaymentDetails); 
		 return ResponseEntity.ok(createdBuyingPaymentDetails);
	}
	
	@PutMapping("/buyingPaymentDetails/{id}")
	public ResponseEntity<BuyingPaymentDetails> updateBuyingPaymentDetails(@PathVariable Long id, @RequestBody BuyingPaymentDetails buyingPaymentDetailsDetails){
		buyingPaymentDetailsDetails.setId(id);
		BuyingPaymentDetails updatedBuyingPaymentDetails = buyingPaymentDetailsService.update(buyingPaymentDetailsDetails);
		return ResponseEntity.ok(updatedBuyingPaymentDetails);
	}
	
	@DeleteMapping("/buyingPaymentDetails/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteBuyingPaymentDetails(@PathVariable Long id){
		buyingPaymentDetailsService.delete(id);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}
