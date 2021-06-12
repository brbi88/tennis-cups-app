package ftn.informatika.org.test_app.service;

import java.util.List;
import java.util.Optional;

import ftn.informatika.org.test_app.model.Prijava;



public interface PrijavaService {
	
	Prijava save(Prijava format);
	
	Prijava update(Prijava format);
	
	Prijava delete(Long id);
	
	Optional<Prijava> findOne(Long id); 
	
	List<Prijava> findAll();

}
