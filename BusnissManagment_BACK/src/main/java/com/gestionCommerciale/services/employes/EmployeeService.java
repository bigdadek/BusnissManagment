package com.gestionCommerciale.services.employes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestionCommerciale.entities.employes.Employee;
import com.gestionCommerciale.repositories.employes.EmployeeRepository;
import com.gestionCommerciale.services.ServiceInterface;

@Service
public class EmployeeService implements ServiceInterface<Employee>{


	@Autowired
	private EmployeeRepository employeeRep;
	
	@Override
	public List<Employee> getAll() {
		return employeeRep.findAll();
	}

	@Override
	public Optional<Employee> getById(long id) {
		return employeeRep.findById(id);
	}
	
	@Override
	public Employee add(Employee employee) {
		return employeeRep.save(employee);
	}

	@Override
	public Employee update(Employee employee) {
		return employeeRep.saveAndFlush(employee);
	}

	@Override
	public boolean delete(long id) {
		try {
			employeeRep.deleteById(id);
			return true;
		}
		catch (Exception e){
			e.printStackTrace();
		}
		return false;
	}
	
}
