package com.test.spring.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.spring.domain.Persona;

public interface PersonaDao extends JpaRepository<Persona, Long>{
	

}
