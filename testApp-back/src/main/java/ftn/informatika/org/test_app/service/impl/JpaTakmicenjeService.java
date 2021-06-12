package ftn.informatika.org.test_app.service.impl;


import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import ftn.informatika.org.test_app.model.Prijava;
import ftn.informatika.org.test_app.model.Takmicenje;
import ftn.informatika.org.test_app.repository.TakmicenjeRepository;
import ftn.informatika.org.test_app.service.PrijavaService;
import ftn.informatika.org.test_app.service.TakmicenjeService;

@Service
public class JpaTakmicenjeService implements TakmicenjeService{
	
	@Autowired
	private TakmicenjeRepository takmicenjeRepository;
	
	@Autowired
	private TakmicenjeService takmicenjeService;
	
	@Autowired
	private PrijavaService prijavaService;
	
	@Override
	public Takmicenje findOne(Long id) {
		return takmicenjeRepository.findOneById(id);
	}
	
	@Override
	public Takmicenje save(Takmicenje takmicenje) {
		return takmicenjeRepository.save(takmicenje);
	}
	
	@Override
	public Takmicenje update(Takmicenje takmicenje) {
		return takmicenjeRepository.save(takmicenje);
	}
	
	@Override
	public Takmicenje delete(Long id) {
		Takmicenje takmicenje = findOne(id);
		if(takmicenje != null) {
			takmicenje.getFormat().getTakmicenja().remove(takmicenje);
			takmicenje.setFormat(null);
			takmicenje = takmicenjeRepository.save(takmicenje);
			takmicenjeRepository.delete(takmicenje);
			return takmicenje;
		}
		return null;
	}
	
	@Override
	public Takmicenje prijava(Long id, Prijava prijaviSe) {
		
		Takmicenje takmicenje = takmicenjeRepository.getOne(id);
		
		if(takmicenje.getFormat().getBrUcesnika() > 0) {
			prijaviSe.setDatPrijave(LocalDate.now().toString());
			prijaviSe.setTakmicenje(takmicenje);
			prijavaService.save(prijaviSe);
			
			takmicenje.getFormat().setBrUcesnika(takmicenje.getFormat().getBrUcesnika() -1);
			takmicenjeService.update(takmicenje);
			
			return takmicenjeRepository.save(takmicenje);
		}
		return null;
			
		}
		
		
	
	@Override
	public Page<Takmicenje> findAll(int brojStranice) {
		return takmicenjeRepository.findAll(PageRequest.of(brojStranice, 2));
	}
	
	@Override
	public Page<Takmicenje> search(Long formatId, String mestoOdrz, int page) {
		
		if(mestoOdrz != null) {
			mestoOdrz = "%" + mestoOdrz + "%";
		}
		return takmicenjeRepository.search(formatId, mestoOdrz, PageRequest.of(page, 2));
	}
	
}
	
	


