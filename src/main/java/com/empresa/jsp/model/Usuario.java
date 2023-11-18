package com.empresa.jsp.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Usuario implements Serializable {
	
	private Integer id;
	
	private String nombre;
	
	private String email;
	
	private String pais;

	public Usuario(String nombre, String email, String pais) {
		this.nombre = nombre;
		this.email = email;
		this.pais = pais;
	}

	
}
