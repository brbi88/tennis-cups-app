package ftn.informatika.org.test_app.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ftn.informatika.org.test_app.model.Prijava;
import ftn.informatika.org.test_app.model.Takmicenje;
import ftn.informatika.org.test_app.service.TakmicenjeService;
import ftn.informatika.org.test_app.support.PrijavaDtoToPrijava;
import ftn.informatika.org.test_app.support.TakmicenjeDtoToTakmicenje;
import ftn.informatika.org.test_app.support.TakmicenjeToTakmicenjeDto;
import ftn.informatika.org.test_app.web.dto.PrijavaDTO;
import ftn.informatika.org.test_app.web.dto.TakmicenjeDTO;

@RestController
@RequestMapping(value = "/api/takmicenja", produces = MediaType.APPLICATION_JSON_VALUE)	
public class TakmicenjeController {
	
	@Autowired
	private TakmicenjeService takmicenjeService;
	
	@Autowired
	private TakmicenjeDtoToTakmicenje toTakmicenje;
	
	@Autowired
	private TakmicenjeToTakmicenjeDto toTakmicenjeDto;
	
	@Autowired
	private PrijavaDtoToPrijava toPrijava;
	
	@PreAuthorize("hasAnyRole('KORISNIK', 'ADMIN')")
	@GetMapping
	ResponseEntity<List<TakmicenjeDTO>> get(@RequestParam(value = "formatId", required = false)	Long formatId,
			@RequestParam(value = "mestoOdrz", required = false) String mestoOdrz,
			@RequestParam(value = "pageNo", defaultValue = "0") int pageNo) {
				
		Page<Takmicenje> page = null;
		
		if(formatId != null || mestoOdrz != null) {
			page = takmicenjeService.search(formatId, mestoOdrz, pageNo);
		}else {
			page = takmicenjeService.findAll(pageNo);
		}
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Total-Pages", Integer.toString(page.getTotalPages()));
		
		return new ResponseEntity<>(toTakmicenjeDto.convert(page.getContent()), headers, HttpStatus.OK);
		
		}
	
	@PreAuthorize("hasAnyRole('KORISNIK', 'ADMIN')")
	@GetMapping(value = "/{id}")
	public ResponseEntity<TakmicenjeDTO> getOne(@PathVariable Long id) {
		Takmicenje takmicenje = takmicenjeService.findOne(id);
		
		if(takmicenje != null) {
			return new ResponseEntity<>(toTakmicenjeDto.convert(takmicenje), HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TakmicenjeDTO> create(@Valid @RequestBody TakmicenjeDTO takmicenjeDTO) {
		Takmicenje takmicenje = toTakmicenje.convert(takmicenjeDTO);
		
		if(takmicenje.getFormat() == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		
		Takmicenje sacuvanoTakmicenje = takmicenjeService.save(takmicenje);
		
		return new ResponseEntity<>(toTakmicenjeDto.convert(sacuvanoTakmicenje), HttpStatus.CREATED);
	}
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TakmicenjeDTO> update(@PathVariable Long id, @Valid @RequestBody TakmicenjeDTO takmicenjeDTO) {
		
		if (!id.equals(takmicenjeDTO.getId())) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		Takmicenje takmicenje = toTakmicenje.convert(takmicenjeDTO);
		
		if(takmicenje.getFormat() == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		Takmicenje sacuvanoTakmicenje = takmicenjeService.update(takmicenje);
		
		return new ResponseEntity<>(toTakmicenjeDto.convert(sacuvanoTakmicenje), HttpStatus.OK);
	}
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		Takmicenje obrisanoTakmicenje = takmicenjeService.delete(id);
		
		if(obrisanoTakmicenje != null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PreAuthorize("hasRole('KORISNIK')")
	@PostMapping(value = "/{id}/prijavi_se")
	public ResponseEntity<Takmicenje> prijava(@PathVariable Long id, @Validated @RequestBody PrijavaDTO prijavaDTO) {
		Prijava prijava = toPrijava.convert(prijavaDTO);
		
		Takmicenje takmicenje = takmicenjeService.prijava(id, prijava);
		
		if(takmicenje != null) {
			return new ResponseEntity<>(HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@ExceptionHandler(value = DataIntegrityViolationException.class)
	public ResponseEntity<Void> handle() {
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

}
