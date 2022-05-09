package com.test.spring.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.spring.domain.Usuario;

public interface UsuarioDao extends JpaRepository<Usuario, Long>{
	Usuario findByUsername(String username);
}
