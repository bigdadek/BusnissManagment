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

import com.gestionCommerciale.entities.buying.Supplier;
import com.gestionCommerciale.services.buying.SupplierService;



@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class SupplierController {
	
	@Autowired
	private SupplierService supplierService;
	
	@GetMapping("/suppliers")
	public List<Supplier> getAllSupplier(){
		return supplierService.getAll();
	}		
	
	@GetMapping("/supplier/{id}")
	public Optional<Supplier> getSupplierById(@PathVariable Long id) {
		return supplierService.getById(id);
	}
	
	@PostMapping("/supplier")
	public ResponseEntity<Supplier> createSupplier(@RequestBody Supplier supplier) {
		Supplier createdSupplier = supplierService.add(supplier); 
		 return ResponseEntity.ok(createdSupplier);
	}
	
	@PutMapping("/supplier/{id}")
	public ResponseEntity<Supplier> updateSupplier(@PathVariable Long id, @RequestBody Supplier supplierDetails){
		supplierDetails.setId(id);
		Supplier updatedSupplier = supplierService.update(supplierDetails);
		return ResponseEntity.ok(updatedSupplier);
	}
	
	@DeleteMapping("/supplier/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteSupplier(@PathVariable Long id){
		supplierService.delete(id);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}
