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

import com.gestionCommerciale.entities.buying.BuyingPayment;
import com.gestionCommerciale.services.buying.BuyingPaymentService;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class BuyingPaymentController {
	
	@Autowired
	private BuyingPaymentService buyingPaymentService;
	
	@GetMapping("/buyingPayments")
	public List<BuyingPayment> getAllBuyingPayment(){
		return buyingPaymentService.getAll();
	}		
	
	@GetMapping("/buyingPayment/{id}")
	public Optional<BuyingPayment> getBuyingPaymentById(@PathVariable Long id) {
		return buyingPaymentService.getById(id);
	}
	
	@PostMapping("/buyingPayment")
	public ResponseEntity<BuyingPayment> createBuyingPayment(@RequestBody BuyingPayment buyingPayment) {
		BuyingPayment createdBuyingPayment = buyingPaymentService.add(buyingPayment); 
		 return ResponseEntity.ok(createdBuyingPayment);
	}
	
	@PutMapping("/buyingPayment/{id}")
	public ResponseEntity<BuyingPayment> updateBuyingPayment(@PathVariable Long id, @RequestBody BuyingPayment buyingPaymentDetails){
		buyingPaymentDetails.setId(id);
		BuyingPayment updatedBuyingPayment = buyingPaymentService.update(buyingPaymentDetails);
		return ResponseEntity.ok(updatedBuyingPayment);
	}
	
	@DeleteMapping("/buyingPayment/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteBuyingPayment(@PathVariable Long id){
		buyingPaymentService.delete(id);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}
