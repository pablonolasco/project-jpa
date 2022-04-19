package com.udemy.jpa.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "subgenero")
public class Subgenero {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="idSubgenero" )
	private Long id;
	
	private String descripcion;
	
	// cuando se especifica el tipo de consulta se coloca automaticamente como eager
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idGenero", referencedColumnName = "idGenero")
	@Cascade(CascadeType.REMOVE)
	// PERSIST obliga a que cuando solo se haga un INSERT de un subgenero solicitara un guardado de genero 
	// MERGE obliga a que todas las transaciones UPDATE que se hagan afecten a la tabla genero tambien
	// REMOVE obliga a que todas las transaciones DELETE que se hagan afecten a la tabla genero tambien
	// ALL obliga a que todas las transaciones INSERT UPDATE DELETE que se hagan afecten a la tabla genero tambien
	private Genero genero;
	
	private LocalDateTime fechaCreacion;

	private LocalDateTime fechaModificacion;
	
	private Boolean estatus;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public LocalDateTime getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(LocalDateTime fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public LocalDateTime getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(LocalDateTime fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public Boolean getEstatus() {
		return estatus;
	}

	public void setEstatus(Boolean estatus) {
		this.estatus = estatus;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}
	
	
}
