package com.gestionCommerciale.services.employes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestionCommerciale.entities.employes.RoleEmployee;
import com.gestionCommerciale.repositories.employes.RoleEmployeeRepository;
import com.gestionCommerciale.services.ServiceInterface;

@Service
public class RoleEmployeeService implements ServiceInterface<RoleEmployee>{


	@Autowired
	private RoleEmployeeRepository roleEmployeeRep;
	
	@Override
	public List<RoleEmployee> getAll() {
		return roleEmployeeRep.findAll();
	}

	@Override
	public Optional<RoleEmployee> getById(long id) {
		return roleEmployeeRep.findById(id);
	}
	
	@Override
	public RoleEmployee add(RoleEmployee roleEmployee) {
		return roleEmployeeRep.save(roleEmployee);
	}

	@Override
	public RoleEmployee update(RoleEmployee roleEmployee) {
		return roleEmployeeRep.saveAndFlush(roleEmployee);
	}

	@Override
	public boolean delete(long id) {
		try {
			roleEmployeeRep.deleteById(id);
			return true;
		}
		catch (Exception e){
			e.printStackTrace();
		}
		return false;
	}
}
