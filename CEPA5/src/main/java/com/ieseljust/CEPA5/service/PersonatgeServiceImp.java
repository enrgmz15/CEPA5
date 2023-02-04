package com.ieseljust.CEPA5.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ieseljust.CEPA5.dto.EspecieDTO;
import com.ieseljust.CEPA5.dto.PersonatgeDTO;
import com.ieseljust.CEPA5.model.Especie;
import com.ieseljust.CEPA5.model.Personatge;
import com.ieseljust.CEPA5.repository.PersonatgeRepository;
import com.ieseljust.CEPA5.repository.EspecieRepository;

@Service
public class PersonatgeServiceImp implements PersonatgeService{
	
	@Autowired
	private PersonatgeRepository personatgeRepository;
	
	@PersistenceContext
    private EntityManager em;
	
	@Autowired
	private EspecieRepository especieRepo;
	

	@Override
	public void savePersonatge(PersonatgeDTO personatgeDTO) {
		Optional <Especie> especie= especieRepo.findById(personatgeDTO.getEspecieDTO().getIdEspecie());
		Personatge personatge=PersonatgeDTO.toEntity(personatgeDTO);
		personatge.setEspecie(especie.get());
		
		especie.get().getPersonatges().add(personatge);
		personatgeRepository.save(personatge);
		// em.persist(personatge);
	}

	@Override
	public List<PersonatgeDTO> listAllPersonatges(EspecieDTO especieDTO) {
		List<Personatge> personatges=(List<Personatge>) personatgeRepository.getPersonatgesByEspecie(especieDTO.getIdEspecie());
		List<PersonatgeDTO> llistaResultat=new ArrayList<PersonatgeDTO>();
		for (int i = 0; i < personatges.size(); ++i) {
			llistaResultat.add(PersonatgeDTO.convertoToDTO(personatges.get(i), especieDTO));
		}
		return llistaResultat;
	}

	@Override
	public void deletePersonatge(Long id) {
		personatgeRepository.deleteById(id);
		
	}

	@Override
	public PersonatgeDTO getPersonatgebyId(Long id) {
		Optional<Personatge>personatge=personatgeRepository.findById(id);
		if(personatge.isPresent()) {
			return PersonatgeDTO.convertoToDTO(personatge.get(),null);
		}else {
			return null;
		}
	}
	
}
