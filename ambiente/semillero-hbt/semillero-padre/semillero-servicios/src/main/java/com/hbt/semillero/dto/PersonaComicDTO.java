package com.hbt.semillero.dto;

import java.io.Serializable;
import java.time.LocalDate;

import com.hbt.semillero.entidad.Comic;
import com.hbt.semillero.entidad.Persona;

public class PersonaComicDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Long idPersona;
	private Long idComic;
	private LocalDate fechaVenta;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getIdPersona() {
		return idPersona;
	}
	public void setIdPersona(Long idPersona) {
		this.idPersona = idPersona;
	}
	public Long getIdComic() {
		return idComic;
	}
	public void setIdComic(Long idComic) {
		this.idComic = idComic;
	}
	public LocalDate getFechaVenta() {
		return fechaVenta;
	}
	public void setFechaVenta(LocalDate fechaVenta) {
		this.fechaVenta = fechaVenta;
	}

}
