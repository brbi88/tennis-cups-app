package ftn.informatika.org.test_app.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import ftn.informatika.org.test_app.model.Prijava;
import ftn.informatika.org.test_app.model.Takmicenje;
import ftn.informatika.org.test_app.service.PrijavaService;
import ftn.informatika.org.test_app.service.TakmicenjeService;
import ftn.informatika.org.test_app.web.dto.PrijavaDTO;


@Component
public class PrijavaDtoToPrijava implements Converter<PrijavaDTO, Prijava>{

	@Autowired 
	PrijavaService prijavaService;
	
	@Autowired 
	TakmicenjeService takmicenjeService;
	
	
	@Override
	public Prijava convert(PrijavaDTO dto) {
		Takmicenje takmicenje = null;
		if(dto.getTakmicenjeId() !=null) {
			takmicenje = takmicenjeService.findOne(dto.getId());
		}
		Prijava prijava;
		
		if(dto.getId() == null) {
			prijava = new Prijava();
		}else {
			prijava = prijavaService.findOne(dto.getId()).get();
		}
		
		
		if(prijava !=null) {
			prijava.setId(dto.getId());
			prijava.setDrzTakmicara(dto.getDrzTakmicara());
			prijava.seteMail(dto.geteMail());
			prijava.setDatPrijave(dto.getDatPrijave());
			prijava.setTakmicenje(takmicenje);
			
		}
		return prijava;
}
}
