package com.test.spring.servicio;

import java.util.List;

import com.test.spring.domain.Persona;

public interface PersonaService {

	public List<Persona>listaPersonas();
	
	public void guardar(Persona persona);
	
	public void eliminar(Persona persona);
	
	public Persona encontrarPersona(Persona persona);
}
