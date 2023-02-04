package com.ieseljust.CEPA5.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.ieseljust.CEPA5.model.Especie;
import com.ieseljust.CEPA5.model.Personatge;

import lombok.Data;
import lombok.ToString;

@Data
public class PersonatgeDTO implements Serializable {
	public static final long serialVersionUID = 15L;
	private Long idPersonatge;
    private String descripcio;
    
    @ToString.Exclude
    @JsonBackReference("personatges")
    private EspecieDTO especieDTO;
    
    
    
    public static PersonatgeDTO convertoToDTO(Personatge personatge, EspecieDTO especie) {
    	PersonatgeDTO personatgeDTO= new PersonatgeDTO();
    	personatgeDTO.setIdPersonatge(personatge.getIdPersonatge());
    	personatgeDTO.setDescripcio(personatge.getDescripcio());
    	personatgeDTO.setEspecieDTO(especie);
    	
    	return personatgeDTO;
    }
    
    public static Personatge toEntity(PersonatgeDTO personatgeDTO) {
    	Personatge personatge=new Personatge();
    	personatge.setIdPersonatge(personatgeDTO.getIdPersonatge());
    	personatge.setDescripcio(personatgeDTO.getDescripcio());
    	personatge.setEspecie(EspecieDTO.toEntity(personatgeDTO.getEspecieDTO()));
    	return personatge;
    }
    
}
