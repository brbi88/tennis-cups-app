package ftn.informatika.org.test_app.support;

import java.util.ArrayList;
import java.util.List;


import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import ftn.informatika.org.test_app.model.Format;

import ftn.informatika.org.test_app.web.dto.FormatDTO;

@Component
public class FormatToFormatDto implements Converter<Format, FormatDTO>{
	
	
	@Override
	public FormatDTO convert(Format format) {
		FormatDTO dto = new FormatDTO();
			dto.setId(format.getId());
			dto.setBrUcesnika(format.getBrUcesnika());
			dto.setTipTakmicenja(format.getTipTakmicenja());
		return dto;
	
}


	public List<FormatDTO> convert(List<Format> formati) {
		List<FormatDTO> formatiDTO = new ArrayList<>();
		
		for(Format format : formati) {
			formatiDTO.add(convert(format));
		}
		return formatiDTO;
	}
}
