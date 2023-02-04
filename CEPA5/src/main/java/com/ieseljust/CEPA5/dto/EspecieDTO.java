package com.ieseljust.CEPA5.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.ieseljust.CEPA5.model.Especie;
import com.ieseljust.CEPA5.model.Personatge;

import lombok.ToString;
import lombok.Data;


@Data
public class EspecieDTO implements Serializable {
	public static final long serialVersionUID = 15L;
	private Long idEspecie;
    private Integer puntsVida;
    private String tipus;
    
    @ToString.Exclude
	@JsonManagedReference("personatges")
    private List <PersonatgeDTO> personatges=new ArrayList<PersonatgeDTO>();
    
    public static EspecieDTO convertToDTO(Especie especie) {
    	EspecieDTO especieDTO=new EspecieDTO();
    	especieDTO.setIdEspecie(especie.getIdEspecie());
    	especieDTO.setPuntsVida(especie.getPuntsVida());
    	especieDTO.setTipus(especie.getTipus());
    	
    	for(Personatge p:especie.getPersonatges()) {
    		PersonatgeDTO pDTO=PersonatgeDTO.convertoToDTO(p,especieDTO);
    		especieDTO.getPersonatges().add(pDTO);
    	}
    	return especieDTO;
    }
    
    public static Especie toEntity(EspecieDTO especieDTO) {
    	Especie especie= new Especie();
    	especie.setIdEspecie(especieDTO.getIdEspecie());
    	especie.setPuntsVida(especieDTO.getPuntsVida());
    	especie.setTipus(especieDTO.getTipus());
    	
    	for (int i=0;i<especieDTO.getPersonatges().size();i++) {
    		Personatge p=PersonatgeDTO.toEntity(especieDTO.getPersonatges().get(i));
    		especie.getPersonatges().add(p);
    	}
    	return especie;
    }
}
