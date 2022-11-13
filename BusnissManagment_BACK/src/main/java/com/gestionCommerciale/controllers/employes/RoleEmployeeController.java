package com.gestionCommerciale.controllers.employes;

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

import com.gestionCommerciale.entities.employes.RoleEmployee;
import com.gestionCommerciale.services.employes.RoleEmployeeService;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class RoleEmployeeController {
	
	@Autowired
	private RoleEmployeeService roleEmployeeService;
	
	@GetMapping("/roleEmployees")
	public List<RoleEmployee> getAllRoleEmployee(){
		return roleEmployeeService.getAll();
	}		
	
	@GetMapping("/roleEmployee/{id}")
	public Optional<RoleEmployee> getRoleEmployeeById(@PathVariable Long id) {
		return roleEmployeeService.getById(id);
	}
	
	@PostMapping("/roleEmployee")
	public ResponseEntity<RoleEmployee> createRoleEmployee(@RequestBody RoleEmployee roleEmployee) {
		RoleEmployee createdRoleEmployee = roleEmployeeService.add(roleEmployee); 
		 return ResponseEntity.ok(createdRoleEmployee);
	}
	
	@PutMapping("/roleEmployee/{id}")
	public ResponseEntity<RoleEmployee> updateRoleEmployee(@PathVariable Long id, @RequestBody RoleEmployee roleEmployeeDetails){
		roleEmployeeDetails.setId(id);
		RoleEmployee updatedRoleEmployee = roleEmployeeService.update(roleEmployeeDetails);
		return ResponseEntity.ok(updatedRoleEmployee);
	}
	
	@DeleteMapping("/roleEmployee/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteRoleEmployee(@PathVariable Long id){
		roleEmployeeService.delete(id);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}
