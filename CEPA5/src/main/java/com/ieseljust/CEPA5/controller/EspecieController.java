package com.ieseljust.CEPA5.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ieseljust.CEPA5.service.EspecieService;
import com.ieseljust.CEPA5.service.PersonatgeService;
import com.ieseljust.CEPA5.Cepa5Application;
import com.ieseljust.CEPA5.dto.EspecieDTO;
import com.ieseljust.CEPA5.dto.PersonatgeDTO;

@RestController
public class EspecieController {
	
	private static final Logger myLog=LoggerFactory.getLogger(Cepa5Application.class);
	
	@Autowired
	private HttpServletRequest context;
	
	@Autowired
	private PersonatgeService personatgeService;
	
	@Autowired
	private EspecieService especieService;
	
	@GetMapping("/especies")
	public ResponseEntity<List<EspecieDTO>> listEspecies(){
		myLog.info(context.getMethod() + " from "+ context.getRemoteHost());
		List<EspecieDTO> especies= especieService.listAllEspecies();
		if(especies==null || especies.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);}
	        else {
	        	return new ResponseEntity<>(especies,HttpStatus.OK);}
	         
	}
	
	@GetMapping("/")
	public String index() {
		return "Welcome";
	}
	
	@PostMapping("/especies")
	public ResponseEntity<EspecieDTO> addEspecie(@RequestBody EspecieDTO newEspecie){
		EspecieDTO especie=especieService.saveEspecie(newEspecie);
		if(especie==null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}else return new ResponseEntity<>(especie,HttpStatus.OK);
	}
	
	 @PutMapping("/especies")
	public ResponseEntity<EspecieDTO> updateEspecie (@RequestBody EspecieDTO editEspecie){
		EspecieDTO especie =especieService.getEspeciebyId(editEspecie.getIdEspecie());
		if(especie==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
		EspecieDTO EditedEspecie=especieService.saveEspecie(editEspecie);
		return new ResponseEntity<>(EditedEspecie,HttpStatus.OK);}
	}
	 @DeleteMapping("/especies/{id}")
	 public ResponseEntity<String> delete (@PathVariable Long id){
		 especieService.deleteEspecie(id);
		 return new ResponseEntity<>("Especie Eliminada",HttpStatus.OK);
	 }
}
