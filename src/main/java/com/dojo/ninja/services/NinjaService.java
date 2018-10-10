package com.dojo.ninja.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.dojo.ninja.models.Ninja;
import com.dojo.ninja.repositories.NinjaRepository;

@Service
public class NinjaService {
	private final NinjaRepository ninjaRepo;
	
	public NinjaService(NinjaRepository ninjaRepo) { this.ninjaRepo = ninjaRepo; }
	
	// Create a Ninja
	public Ninja createNinja(Ninja ninja) { return this.ninjaRepo.save(ninja); }
	
	// retrieve all ninja
	public List<Ninja> findAllNinjas(){ return this.ninjaRepo.findAll(); }
	
	// retrieve a ninja
	public Ninja findNinjaById(Long id) {
		Optional<Ninja> response = this.ninjaRepo.findById(id);
		if(response.isPresent()) {
			return response.get();
		}
		else {
			return null;
		}
	}
}
