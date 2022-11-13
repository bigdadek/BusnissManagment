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

import com.gestionCommerciale.entities.saling.SalingPayment;
import com.gestionCommerciale.services.saling.SalingPaymentService;


@RestController
@CrossOrigin(origins = "http://localhost:4200")

public class SalingPaymentController {
	@Autowired
	private SalingPaymentService salingPaymentService;
	
	@GetMapping("/salingPayments")
	public List<SalingPayment> getAllSalingPayment(){
		return salingPaymentService.getAll();
	}		
	
	@GetMapping("/salingPayment/{id}")
	public Optional<SalingPayment> getSalingPaymentById(@PathVariable Long id) {
		return salingPaymentService.getById(id);
	}
	
	@PostMapping("/salingPayment")
	public ResponseEntity<SalingPayment> createSalingPayment(@RequestBody SalingPayment salingPayment) {
		SalingPayment createdSalingPayment = salingPaymentService.add(salingPayment); 
		 return ResponseEntity.ok(createdSalingPayment);
	}
	
	@PutMapping("/salingPayment/{id}")
	public ResponseEntity<SalingPayment> updateSalingPayment(@PathVariable Long id, @RequestBody SalingPayment salingPaymentDetails){
		salingPaymentDetails.setId(id);
		SalingPayment updatedSalingPayment = salingPaymentService.update(salingPaymentDetails);
		return ResponseEntity.ok(updatedSalingPayment);
	}
	
	@DeleteMapping("/salingPayment/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteSalingPayment(@PathVariable Long id){
		salingPaymentService.delete(id);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

}
