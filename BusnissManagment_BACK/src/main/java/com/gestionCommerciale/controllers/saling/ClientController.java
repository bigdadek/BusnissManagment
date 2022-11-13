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

import com.gestionCommerciale.entities.saling.Client;
import com.gestionCommerciale.services.saling.ClientService;


@RestController
@CrossOrigin(origins = "http://localhost:4200")

public class ClientController {
	
	@Autowired
	private ClientService clientService;
	
	@GetMapping("/clients")
	public List<Client> getAllClient(){
		return clientService.getAll();
	}		
	
	@GetMapping("/client/{id}")
	public Optional<Client> getClientById(@PathVariable Long id) {
		return clientService.getById(id);
	}
	
	@PostMapping("/client")
	public ResponseEntity<Client> createClient(@RequestBody Client client) {
		Client createdClient = clientService.add(client); 
		 return ResponseEntity.ok(createdClient);
	}
	
	@PutMapping("/client/{id}")
	public ResponseEntity<Client> updateClient(@PathVariable Long id, @RequestBody Client clientDetails){
		clientDetails.setId(id);
		Client updatedClient = clientService.update(clientDetails);
		return ResponseEntity.ok(updatedClient);
	}
	
	@DeleteMapping("/client/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteClient(@PathVariable Long id){
		clientService.delete(id);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}
