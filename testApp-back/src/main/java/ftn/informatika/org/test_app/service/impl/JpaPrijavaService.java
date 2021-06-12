package ftn.informatika.org.test_app.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ftn.informatika.org.test_app.model.Format;
import ftn.informatika.org.test_app.model.Prijava;
import ftn.informatika.org.test_app.repository.PrijavaRepository;
import ftn.informatika.org.test_app.service.FormatService;
import ftn.informatika.org.test_app.service.PrijavaService;



@Service
public class JpaPrijavaService implements PrijavaService{
	
	@Autowired
	PrijavaRepository prijavaRepository;
	
	@Autowired
	PrijavaService prijavaService;
	
	@Autowired
	private FormatService formatService;
	
	@Override
	public Optional<Prijava> findOne(Long id) {
		return prijavaRepository.findById(id);
	}
	
	@Override
	public Prijava save(Prijava prijava) {
		return prijavaRepository.save(prijava);
	}
	
	@Override
	public Prijava update(Prijava prijava) {
		return prijavaRepository.save(prijava);
	}
	
	@Override
	public Prijava delete(Long id) {
		Optional<Prijava> prijava = prijavaRepository.findById(id);
		if(prijava.isPresent()) {
			prijavaRepository.deleteById(id);
			return prijava.get();
		}
		return null;
	}
	
	@Override
	public List<Prijava> findAll() {
		return prijavaRepository.findAll();
	}
}
