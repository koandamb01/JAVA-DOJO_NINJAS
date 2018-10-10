package com.dojo.ninja.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.dojo.ninja.models.Dojo;
import com.dojo.ninja.repositories.DojoRepository;

@Service
public class DojoService {
	private final DojoRepository dojoRepo;
	
	public DojoService(DojoRepository dojoRepo) { this.dojoRepo = dojoRepo; }
	
	// retrieves all dojo
	public List<Dojo> findAllDojos(){ return this.dojoRepo.findAll(); }
	
	// retrieve a dojo
	public Dojo findDojoById(Long id) {
		Optional<Dojo> response = this.dojoRepo.findById(id);
		if(response.isPresent()) { 
			return response.get(); 
		}
		else { 
			return null; 
		}
	}
	// Create a Dojo
	public Dojo createDojo(Dojo dojo) { return this.dojoRepo.save(dojo); }
}
