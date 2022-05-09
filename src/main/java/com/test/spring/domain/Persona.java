package com.test.spring.domain;
import java.io.Serializable;
import javax.persistence.*;
import com.sun.istack.NotNull;
import lombok.Data;



@Data
@Entity
@Table(name = "persona")
public class Persona implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_persona;
	private String nombre;
	private String apellido;
	private String email;
	private String telefono;
	@NotNull
	private double saldo;

}
