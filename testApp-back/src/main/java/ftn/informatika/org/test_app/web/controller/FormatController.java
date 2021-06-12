package ftn.informatika.org.test_app.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ftn.informatika.org.test_app.model.Format;
import ftn.informatika.org.test_app.service.FormatService;
import ftn.informatika.org.test_app.support.FormatToFormatDto;
import ftn.informatika.org.test_app.web.dto.FormatDTO;


@RestController
@RequestMapping(value = "/api/formati", produces = MediaType.APPLICATION_JSON_VALUE)
public class FormatController {
	
	@Autowired
	private FormatService formatService;
	
	@Autowired
	private FormatToFormatDto toFormatDto;
	
	
	@GetMapping
    public ResponseEntity<List<FormatDTO>> getAll(){

        List<Format> formati = formatService.findAll();

        return new ResponseEntity<>(toFormatDto.convert(formati), HttpStatus.OK);
    }

}
