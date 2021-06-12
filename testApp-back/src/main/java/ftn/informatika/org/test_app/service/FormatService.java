package ftn.informatika.org.test_app.service;

import java.util.List;
import java.util.Optional;


import ftn.informatika.org.test_app.model.Format;

public interface FormatService {

	Format save(Format format);
	
	Format update(Format format);
	
	Format delete(Long id);
	
	Optional<Format> findOne(Long id); 
	
	List<Format> findAll();
}
