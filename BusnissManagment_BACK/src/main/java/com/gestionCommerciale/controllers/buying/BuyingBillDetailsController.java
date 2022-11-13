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

import com.gestionCommerciale.entities.buying.BuyingBillDetails;
import com.gestionCommerciale.services.buying.BuyingBillDetailsService;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class BuyingBillDetailsController {
	
	@Autowired
	private BuyingBillDetailsService buyingBillDetailsService;
	
	@GetMapping("/buyingBillDetailss")
	public List<BuyingBillDetails> getAllBuyingBillDetails(){
		return buyingBillDetailsService.getAll();
	}		
	
	@GetMapping("/buyingBillDetails/{id}")
	public Optional<BuyingBillDetails> getBuyingBillDetailsById(@PathVariable Long id) {
		return buyingBillDetailsService.getById(id);
	}
	
	@PostMapping("/buyingBillDetails")
	public ResponseEntity<BuyingBillDetails> createBuyingBillDetails(@RequestBody BuyingBillDetails buyingBillDetails) {
		BuyingBillDetails createdBuyingBillDetails = buyingBillDetailsService.add(buyingBillDetails); 
		 return ResponseEntity.ok(createdBuyingBillDetails);
	}
	
	@PutMapping("/buyingBillDetails/{id}")
	public ResponseEntity<BuyingBillDetails> updateBuyingBillDetails(@PathVariable Long id, @RequestBody BuyingBillDetails buyingBillDetailsDetails){
		buyingBillDetailsDetails.setId(id);
		BuyingBillDetails updatedBuyingBillDetails = buyingBillDetailsService.update(buyingBillDetailsDetails);
		return ResponseEntity.ok(updatedBuyingBillDetails);
	}
	
	@DeleteMapping("/buyingBillDetails/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteBuyingBillDetails(@PathVariable Long id){
		buyingBillDetailsService.delete(id);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}
