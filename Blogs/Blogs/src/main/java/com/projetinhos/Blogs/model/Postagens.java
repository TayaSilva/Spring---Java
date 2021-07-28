package com.projetinhos.Blogs.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity

@Table(name = "Postagens")
public class Postagens {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	//ESSE ATRIBUTO VIRA CHAVE PRIMARIA
	
	@NotNull
	@Size (min = 5, max = 150)
	private String titulo;
	// O titulo não pode ser nulo e tem até no maximo 150 linhas de titulo
	
	@NotNull
	@Size (min = 5, max = 550)
	private String texto;
	/* O titulo não pode ser nulo e tem até no maximo 550 linhas de titulo*/
	
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date data = new java.sql.Date(System.currentTimeMillis());
	//Indicar que estamos trabalhando com tempo
	
	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
	
	
	
	
	
	
	
	
	
}
