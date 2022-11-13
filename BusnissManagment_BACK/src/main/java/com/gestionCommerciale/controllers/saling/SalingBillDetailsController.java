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

import com.gestionCommerciale.entities.saling.SalingBillDetails;
import com.gestionCommerciale.services.saling.SalingBillDetailsService;


@RestController
@CrossOrigin(origins = "http://localhost:4200")

public class SalingBillDetailsController {

	@Autowired
	private SalingBillDetailsService salingBillDetailsService;
	
	@GetMapping("/salingBillDetailss")
	public List<SalingBillDetails> getAllSalingBillDetails(){
		return salingBillDetailsService.getAll();
	}		
	
	@GetMapping("/salingBillDetails/{id}")
	public Optional<SalingBillDetails> getSalingBillDetailsById(@PathVariable Long id) {
		return salingBillDetailsService.getById(id);
	}
	
	@PostMapping("/salingBillDetails")
	public ResponseEntity<SalingBillDetails> createSalingBillDetails(@RequestBody SalingBillDetails salingBillDetails) {
		SalingBillDetails createdSalingBillDetails = salingBillDetailsService.add(salingBillDetails); 
		 return ResponseEntity.ok(createdSalingBillDetails);
	}
	
	@PutMapping("/salingBillDetails/{id}")
	public ResponseEntity<SalingBillDetails> updateSalingBillDetails(@PathVariable Long id, @RequestBody SalingBillDetails salingBillDetailsDetails){
		salingBillDetailsDetails.setId(id);
		SalingBillDetails updatedSalingBillDetails = salingBillDetailsService.update(salingBillDetailsDetails);
		return ResponseEntity.ok(updatedSalingBillDetails);
	}
	
	@DeleteMapping("/salingBillDetails/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteSalingBillDetails(@PathVariable Long id){
		salingBillDetailsService.delete(id);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}
