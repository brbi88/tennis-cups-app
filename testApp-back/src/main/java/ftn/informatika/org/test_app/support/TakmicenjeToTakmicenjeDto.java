package ftn.informatika.org.test_app.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;


import ftn.informatika.org.test_app.model.Takmicenje;

import ftn.informatika.org.test_app.web.dto.TakmicenjeDTO;

@Component
public class TakmicenjeToTakmicenjeDto implements Converter<Takmicenje, TakmicenjeDTO>{

	@Override
	public TakmicenjeDTO convert(Takmicenje takmicenje) {
		TakmicenjeDTO takmicenjeDTO = new TakmicenjeDTO();
		takmicenjeDTO.setId(takmicenje.getId());
		takmicenjeDTO.setNaziv(takmicenje.getNaziv());
		takmicenjeDTO.setMestoOdrz(takmicenje.getMestoOdrz());
		takmicenjeDTO.setDatPocetka(takmicenje.getDatPocetka());
		takmicenjeDTO.setDatZavrsetka(takmicenje.getDatZavrsetka());
		takmicenjeDTO.setFormatId(takmicenje.getFormat().getId());
		takmicenjeDTO.setFormatTip(takmicenje.getFormat().getTipTakmicenja());
		
		
		
		return takmicenjeDTO;
	}
	
	public List<TakmicenjeDTO> convert(List<Takmicenje> takmicenja) {
		List<TakmicenjeDTO> takmicenjaDTO = new ArrayList<>();
		
		for(Takmicenje takmicenje : takmicenja) {
			takmicenjaDTO.add(convert(takmicenje));
		}
		return takmicenjaDTO;
	}
}
