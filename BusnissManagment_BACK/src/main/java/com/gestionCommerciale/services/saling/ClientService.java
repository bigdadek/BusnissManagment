package com.gestionCommerciale.services.saling;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestionCommerciale.entities.saling.Client;
import com.gestionCommerciale.repositories.saling.ClientRepository;
import com.gestionCommerciale.services.ServiceInterface;

@Service
public class ClientService implements ServiceInterface<Client>{


	@Autowired
	private ClientRepository clientRep;
	
	@Override
	public List<Client> getAll() {
		return clientRep.findAll();
	}

	@Override
	public Optional<Client> getById(long id) {
		return clientRep.findById(id);
	}
	
	@Override
	public Client add(Client client) {
		return clientRep.save(client);
	}

	@Override
	public Client update(Client client) {
		return clientRep.saveAndFlush(client);
	}

	@Override
	public boolean delete(long id) {
		try {
			clientRep.deleteById(id);
			return true;
		}
		catch (Exception e){
			e.printStackTrace();
		}
		return false;
	}
}
