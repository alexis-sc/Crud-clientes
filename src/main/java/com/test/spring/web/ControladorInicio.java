package com.test.spring.web;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.test.spring.domain.Persona;
import com.test.spring.servicio.PersonaService;
import lombok.extern.slf4j.Slf4j;


@Controller
@Slf4j
public class ControladorInicio {
	
	@Autowired
	private PersonaService personaService;
	@GetMapping("/")
	public String inicio(Model model, @AuthenticationPrincipal User user) {
		var personas = personaService.listaPersonas();
		log.info("Ejecuntadno el controlador Spring MVC");
		log.info("Personas"+user);
		
		model.addAttribute("personas", personas);
		var saldoTotal=0;
		for(var p: personas) {
			saldoTotal += p.getSaldo();
		}
		model.addAttribute("saldoTotal",saldoTotal);
		model.addAttribute("totalClientes", personas.size());
		return "index";
	}
	
	@GetMapping("/agregar")
	public String agregar(Persona persona) {
		return "modificar";
	}
	
	@PostMapping("/guardar")
	public String guardar(Persona persona){
		personaService.guardar(persona);
		return "redirect:/";
	}
	
	@GetMapping("/editar/{id_persona}") 
	public String editar(Persona persona, Model model) {
		persona = personaService.encontrarPersona(persona);
		model.addAttribute("persona",persona);
		return "modificar";
	}
	
	@GetMapping("/eliminar/{id_persona}")
	public String eliminar(Persona persona) {
		personaService.eliminar(persona);
		return "redirect:/";
	}
	
	
}
