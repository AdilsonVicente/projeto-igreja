package com.projeto.igreja.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.projeto.igreja.api.model.Pastoral;

public interface PastoralRepository extends JpaRepository<Pastoral, Long>{
	
	@Query("from Pastoral p JOIN FETCH p.igreja")
	List<Pastoral> findAll();
}
