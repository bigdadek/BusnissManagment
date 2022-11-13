package com.gestionCommerciale.controllers.saling;

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

import com.gestionCommerciale.entities.saling.SalingPaymentDetails;
import com.gestionCommerciale.services.saling.SalingPaymentDetailsService;


@RestController
@CrossOrigin(origins = "http://localhost:4200")

public class SalingPaymentDetailsController {
	@Autowired
	private SalingPaymentDetailsService salingPaymentDetailsService;
	
	@GetMapping("/salingPaymentDetailss")
	public List<SalingPaymentDetails> getAllSalingPaymentDetails(){
		return salingPaymentDetailsService.getAll();
	}		
	
	@GetMapping("/salingPaymentDetails/{id}")
	public Optional<SalingPaymentDetails> getSalingPaymentDetailsById(@PathVariable Long id) {
		return salingPaymentDetailsService.getById(id);
	}
	
	@PostMapping("/salingPaymentDetails")
	public ResponseEntity<SalingPaymentDetails> createSalingPaymentDetails(@RequestBody SalingPaymentDetails salingPaymentDetails) {
		SalingPaymentDetails createdSalingPaymentDetails = salingPaymentDetailsService.add(salingPaymentDetails); 
		 return ResponseEntity.ok(createdSalingPaymentDetails);
	}
	
	@PutMapping("/salingPaymentDetails/{id}")
	public ResponseEntity<SalingPaymentDetails> updateSalingPaymentDetails(@PathVariable Long id, @RequestBody SalingPaymentDetails salingPaymentDetailsDetails){
		salingPaymentDetailsDetails.setId(id);
		SalingPaymentDetails updatedSalingPaymentDetails = salingPaymentDetailsService.update(salingPaymentDetailsDetails);
		return ResponseEntity.ok(updatedSalingPaymentDetails);
	}
	
	@DeleteMapping("/salingPaymentDetails/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteSalingPaymentDetails(@PathVariable Long id){
		salingPaymentDetailsService.delete(id);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

}
