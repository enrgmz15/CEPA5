package com.ieseljust.CEPA5.service;

import java.util.List;

import javax.transaction.Transactional;

import com.ieseljust.CEPA5.dto.EspecieDTO;

@Transactional
public interface EspecieService {
	
	EspecieDTO saveEspecie(EspecieDTO especieDTO);
	EspecieDTO getEspeciebyId(Long id);
	List <EspecieDTO> listAllEspecies();
	void deleteEspecie(Long id);
	
}
