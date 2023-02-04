package com.ieseljust.CEPA5.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ieseljust.CEPA5.Cepa5Application;
import com.ieseljust.CEPA5.service.PersonatgeService;
import com.ieseljust.CEPA5.service.EspecieService;
import com.ieseljust.CEPA5.dto.EspecieDTO;
import com.ieseljust.CEPA5.dto.PersonatgeDTO;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PersonatgeController {
	
	private static final Logger myLog=LoggerFactory.getLogger(Cepa5Application.class);
	
	@Autowired
	private HttpServletRequest context;
	
	@Autowired
	private PersonatgeService personatgeService;
	
	@Autowired
	private EspecieService especieService;
	
	@GetMapping("/especies/{idEspecie}/personatges")
	public ResponseEntity<List<PersonatgeDTO>> listPersonatges(@PathVariable Long idEspecie){
		EspecieDTO espDTO = especieService.getEspeciebyId(idEspecie);
		if(espDTO==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			List <PersonatgeDTO> personatges = personatgeService.listAllPersonatges(espDTO);
			if(personatges==null || personatges.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}else {
				return new ResponseEntity<>(personatges,HttpStatus.OK);
			}
		}
	}
	@PostMapping("/especies/{idEspecie}/personatge")
	public ResponseEntity<String> addPersonatge(@RequestBody PersonatgeDTO newPersonatge, @PathVariable Long idEspecie){
		EspecieDTO especie= especieService.getEspeciebyId(idEspecie);
		if(especie==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
		newPersonatge.setEspecieDTO(especie);
		personatgeService.savePersonatge(newPersonatge);
		return new ResponseEntity<>("Personatge Guardat",HttpStatus.OK);
	}
	}
	
	
	@PutMapping("/especies/{idEspecie}/personatge")
	public ResponseEntity<EspecieDTO> addPersonatgeToEspecie (@RequestBody PersonatgeDTO editPersonatge, @PathVariable Long idEspecie){
		EspecieDTO especie= especieService.getEspeciebyId(idEspecie);
		if(especie==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
		editPersonatge.setEspecieDTO(especie);
		personatgeService.savePersonatge(editPersonatge);
		EspecieDTO especieUpd=especieService.getEspeciebyId(idEspecie);
		return new ResponseEntity<>(especieUpd,HttpStatus.OK);}
	}
	
	
	@DeleteMapping("/personatge/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id){
		personatgeService.deletePersonatge(id);
		return new ResponseEntity("Personatge eliminat", HttpStatus.OK);
	}
}
