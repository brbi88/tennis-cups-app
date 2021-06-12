package ftn.informatika.org.test_app.service;

import org.springframework.data.domain.Page;

import ftn.informatika.org.test_app.model.Prijava;
import ftn.informatika.org.test_app.model.Takmicenje;

public interface TakmicenjeService {

	Takmicenje save(Takmicenje format);
	
	Takmicenje update(Takmicenje format);
	
	Takmicenje delete(Long id);
	
	Takmicenje findOne(Long id); 
	
	Takmicenje prijava(Long id, Prijava prijaviSe);
	
	Page<Takmicenje> findAll(int page);
	
	Page<Takmicenje> search(Long formatId, String mestoOdrz, int pageNo);
}
