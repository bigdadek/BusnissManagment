package com.gestionCommerciale.controllers.products;

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

import com.gestionCommerciale.entities.products.Categorie;
import com.gestionCommerciale.services.products.CategorieService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")

public class CategorieController {
	
	@Autowired
	private CategorieService categorieService;
	
	@GetMapping("/categories")
	public List<Categorie> getAllCategorie(){
		return categorieService.getAll();
	}		
	
	@GetMapping("/categorie/{id}")
	public Optional<Categorie> getCategorieById(@PathVariable Long id) {
		return categorieService.getById(id);
	}
	
	@PostMapping("/categorie")
	public ResponseEntity<Categorie> createCategorie(@RequestBody Categorie categorie) {
		Categorie createdCategorie = categorieService.add(categorie); 
		 return ResponseEntity.ok(createdCategorie);
	}
	
	@PutMapping("/categorie/{id}")
	public ResponseEntity<Categorie> updateCategorie(@PathVariable Long id, @RequestBody Categorie categorieDetails){
		categorieDetails.setId(id);
		Categorie updatedCategorie = categorieService.update(categorieDetails);
		return ResponseEntity.ok(updatedCategorie);
	}
	
	@DeleteMapping("/categorie/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteCategorie(@PathVariable Long id){
		categorieService.delete(id);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}
