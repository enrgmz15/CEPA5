package com.ieseljust.CEPA5.service;

import java.util.List;

import com.ieseljust.CEPA5.dto.EspecieDTO;
import com.ieseljust.CEPA5.dto.PersonatgeDTO;

public interface PersonatgeService {
	
	void savePersonatge(PersonatgeDTO personatgeDTO);
	PersonatgeDTO getPersonatgebyId(Long id);
	List <PersonatgeDTO> listAllPersonatges(EspecieDTO especieDTO);
	void deletePersonatge(Long id);
	
}
