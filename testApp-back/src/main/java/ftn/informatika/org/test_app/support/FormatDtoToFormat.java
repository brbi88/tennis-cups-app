package ftn.informatika.org.test_app.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import ftn.informatika.org.test_app.model.Format;

import ftn.informatika.org.test_app.service.FormatService;
import ftn.informatika.org.test_app.web.dto.FormatDTO;



@Component
public class FormatDtoToFormat implements Converter<FormatDTO, Format>{
	
	@Autowired
	private FormatService formatService;
	
	@Override
	public Format convert(FormatDTO dto) {
		
		Format format;
		
		if(dto.getId() == null) {
			format = new Format();
		}else {
			format = formatService.findOne(dto.getId()).get();
		}
		
		
		if(format !=null) {
			format.setId(dto.getId());
			format.setTipTakmicenja(dto.getTipTakmicenja());
			format.setBrUcesnika(dto.getBrUcesnika());
			
		}
		return format;
}
	
	public List<Format> convert(List<FormatDTO> formatiDTO) {
		List<Format> formati = new ArrayList<>();
		
		for(FormatDTO formatDTO : formatiDTO) {
			formati.add(convert(formatDTO));
		}
		return formati;
	}
	


}
