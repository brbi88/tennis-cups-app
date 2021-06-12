package ftn.informatika.org.test_app.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



import ftn.informatika.org.test_app.model.Prijava;
import ftn.informatika.org.test_app.service.PrijavaService;
import ftn.informatika.org.test_app.support.PrijavaDtoToPrijava;
import ftn.informatika.org.test_app.support.PrijavaToPrijavaDto;
import ftn.informatika.org.test_app.web.dto.PrijavaDTO;

@RestController
@RequestMapping(value = "/api/prijave", produces = MediaType.APPLICATION_JSON_VALUE)	
public class PrijavaController {
	
	@Autowired
	PrijavaService prijavaService;
	
	@Autowired
	private PrijavaDtoToPrijava toPrijava;
	
	@Autowired
	private PrijavaToPrijavaDto toPrijavaDto;
	
	@GetMapping
    public ResponseEntity<List<PrijavaDTO>> getAll(){

        List<Prijava> prijave = prijavaService.findAll();

        return new ResponseEntity<>(toPrijavaDto.convert(prijave), HttpStatus.OK);
    }

}
