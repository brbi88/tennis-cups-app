package ftn.informatika.org.test_app.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ftn.informatika.org.test_app.model.Format;
import ftn.informatika.org.test_app.repository.FormatRepository;
import ftn.informatika.org.test_app.service.FormatService;

@Service 
public class JpaFormatService implements FormatService{
	
	@Autowired
	FormatRepository formatRepository;
	
	@Autowired
	FormatService formatService;
	
	@Override
	public Optional<Format> findOne(Long id) {
		return formatRepository.findById(id);
	}
	
	@Override
	public List<Format> findAll() {
		return formatRepository.findAll();
	}
	
	@Override
	public Format save(Format format) {
		return formatRepository.save(format);
	}
	
	@Override
	public Format update(Format format) {
		return formatRepository.save(format);
	}
	
	@Override
	public Format delete(Long id) {
		Optional<Format> format = formatRepository.findById(id);
		if(format.isPresent()) {
			formatRepository.deleteById(id);
			return format.get();
		}
		return null;
	}
	

}
