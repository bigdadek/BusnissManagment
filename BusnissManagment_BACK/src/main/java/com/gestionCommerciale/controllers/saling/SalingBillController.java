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

import com.gestionCommerciale.entities.saling.SalingBill;
import com.gestionCommerciale.services.saling.SalingBillService;


@RestController
@CrossOrigin(origins = "http://localhost:4200")

public class SalingBillController {

	@Autowired
	private SalingBillService salingBillService;
	
	@GetMapping("/salingBills")
	public List<SalingBill> getAllSalingBill(){
		return salingBillService.getAll();
	}		
	
	@GetMapping("/salingBill/{id}")
	public Optional<SalingBill> getSalingBillById(@PathVariable Long id) {
		return salingBillService.getById(id);
	}
	
	@PostMapping("/salingBill")
	public ResponseEntity<SalingBill> createSalingBill(@RequestBody SalingBill salingBill) {
		SalingBill createdSalingBill = salingBillService.add(salingBill); 
		 return ResponseEntity.ok(createdSalingBill);
	}
	
	@PutMapping("/salingBill/{id}")
	public ResponseEntity<SalingBill> updateSalingBill(@PathVariable Long id, @RequestBody SalingBill salingBillDetails){
		salingBillDetails.setId(id);
		SalingBill updatedSalingBill = salingBillService.update(salingBillDetails);
		return ResponseEntity.ok(updatedSalingBill);
	}
	
	@DeleteMapping("/salingBill/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteSalingBill(@PathVariable Long id){
		salingBillService.delete(id);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}
