package com.ieseljust.CEPA5.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ieseljust.CEPA5.model.Personatge;

@Repository
@Transactional
public interface PersonatgeRepository extends JpaRepository<Personatge, Long>{
	
	@Query(value = "select p from Personatge p where p.especie.idEspecie = :idespecie")
	public List <Personatge> getPersonatgesByEspecie(@Param("idespecie")Long idEspecie);

}
