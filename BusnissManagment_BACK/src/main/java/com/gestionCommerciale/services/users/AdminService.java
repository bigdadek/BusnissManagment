package com.gestionCommerciale.services.users;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestionCommerciale.entities.users.Admin;
import com.gestionCommerciale.repositories.users.AdminRepository;
import com.gestionCommerciale.services.ServiceInterface;

@Service
public class AdminService implements ServiceInterface<Admin>{

	@Autowired
	private AdminRepository adminRep;
	
	@Override
	public List<Admin> getAll() {
		return adminRep.findAll();
	}

	@Override
	public Optional<Admin> getById(long id) {
		return adminRep.findById(id);
	}
	
	@Override
	public Admin add(Admin admin) {
		return adminRep.save(admin);
	}

	@Override
	public Admin update(Admin admin) {
		return adminRep.saveAndFlush(admin);
	}

	@Override
	public boolean delete(long id) {
		try {
			adminRep.deleteById(id);
			return true;
		}
		catch (Exception e){
			e.printStackTrace();
		}
		return false;
	}


}
