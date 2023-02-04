package com.ieseljust.CEPA5.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ieseljust.CEPA5.model.Especie;

@Repository
@Transactional
public interface EspecieRepository extends JpaRepository<Especie, Long>{
	
	List<Especie> findByTipus(String tipus);

}
