package ftn.informatika.org.test_app.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import ftn.informatika.org.test_app.model.Prijava;
import ftn.informatika.org.test_app.web.dto.PrijavaDTO;

@Component
public class PrijavaToPrijavaDto implements Converter<Prijava, PrijavaDTO>{
	
	@Override
	public PrijavaDTO convert(Prijava prijava) {
		PrijavaDTO prijavaDTO = new PrijavaDTO();
		prijavaDTO.setId(prijava.getId());
		prijavaDTO.setDrzTakmicara(prijava.getDrzTakmicara());
		prijavaDTO.seteMail(prijava.geteMail());
		prijavaDTO.setDatPrijave(prijava.getDatPrijave());
		
		if(prijava.getTakmicenje() != null) {
			prijavaDTO.setTakmicenjeId(prijava.getTakmicenje().getId());
		}
		
		return prijavaDTO;
	}
	
	public List<PrijavaDTO> convert(List<Prijava> prijave) {
		List<PrijavaDTO> prijaveDTO = new ArrayList<>();
		
		for(Prijava prijava : prijave) {
			prijaveDTO.add(convert(prijava));
		}
		return prijaveDTO;
	}

	
}
