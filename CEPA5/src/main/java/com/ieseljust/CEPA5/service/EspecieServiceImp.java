package com.ieseljust.CEPA5.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ieseljust.CEPA5.dto.EspecieDTO;
import com.ieseljust.CEPA5.model.Especie;
import com.ieseljust.CEPA5.repository.EspecieRepository;

@Service
public class EspecieServiceImp implements EspecieService{
	
	@Autowired
	private EspecieRepository especieRepository;
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public EspecieDTO saveEspecie(EspecieDTO especieDTO) {
		Especie especie=EspecieDTO.toEntity(especieDTO);
		Especie novaEspecie=especieRepository.save(especie);
		return EspecieDTO.convertToDTO(novaEspecie);
	}

	@Override
	public EspecieDTO getEspeciebyId(Long id) {
		Optional<Especie>especie=especieRepository.findById(id);
		if(especie.isPresent()) {
			return EspecieDTO.convertToDTO(especie.get());
		}else {
			return null;
		}
		
	}

	@Override
	public List<EspecieDTO> listAllEspecies() {
		List <Especie> especies=especieRepository.findAll();
		List <EspecieDTO> dtos= new ArrayList<EspecieDTO>();
		for(int i =0; i<especies.size();i++) {
			dtos.add(EspecieDTO.convertToDTO(especies.get(i)));
		}
		return dtos;
	}

	@Override
	public void deleteEspecie(Long id) {
		especieRepository.deleteById(id);
	}

}
