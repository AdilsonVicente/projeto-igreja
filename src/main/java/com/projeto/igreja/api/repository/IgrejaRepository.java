package com.projeto.igreja.api.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.projeto.igreja.api.model.Igreja;

@Repository
public interface IgrejaRepository extends JpaRepository<Igreja, Long> {
	
	@Query("from Igreja i")
	List<Igreja> findAll();
}
