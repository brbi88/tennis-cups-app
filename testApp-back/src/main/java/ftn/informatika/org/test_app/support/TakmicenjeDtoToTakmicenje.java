package ftn.informatika.org.test_app.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import ftn.informatika.org.test_app.model.Format;
import ftn.informatika.org.test_app.model.Takmicenje;

import ftn.informatika.org.test_app.service.FormatService;
import ftn.informatika.org.test_app.service.TakmicenjeService;

import ftn.informatika.org.test_app.web.dto.TakmicenjeDTO;


@Component
public class TakmicenjeDtoToTakmicenje implements Converter<TakmicenjeDTO, Takmicenje>{

	@Autowired 
	private TakmicenjeService takmicenjeService;
	
	@Autowired 
	private FormatService formatService;
	
	
	@Override
	public Takmicenje convert(TakmicenjeDTO dto) {
		Format format = null;
		if(dto.getFormatId() !=null) {
			format = formatService.findOne(dto.getFormatId()).get();
		}
		Takmicenje takmicenje;
		
		if(dto.getId() == null) {
			takmicenje = new Takmicenje();
		}else {
			takmicenje = takmicenjeService.findOne(dto.getId());
		}
		
		
		if(takmicenje !=null) {
			takmicenje.setId(dto.getId());
			takmicenje.setNaziv(dto.getNaziv());
			takmicenje.setMestoOdrz(dto.getMestoOdrz());
			takmicenje.setDatPocetka(dto.getDatPocetka());
			takmicenje.setDatZavrsetka(dto.getDatZavrsetka());
			takmicenje.setFormat(format);
			
		}
		return takmicenje;
}
}
