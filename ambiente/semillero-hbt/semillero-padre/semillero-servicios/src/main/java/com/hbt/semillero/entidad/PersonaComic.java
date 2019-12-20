package com.hbt.semillero.entidad;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * <b>Descripción:<b> Clase que determina la entidad que permite representar la
 * tabla "DB_SEMILLERO"."PERSONA_COMIC"
 * 
 * @author Tulio Estrella
 * @version
 */
@Entity
@Table(name = "PERSONA_COMIC")
public class PersonaComic implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(allocationSize = 1, name = "PERSONA_C_ID_GENERATOR", sequenceName = "SEC_PERSONA_COMIC")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PERSONA_C_ID_GENERATOR")
	@Column(name = "PC_ID")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "PC_ID_PERSONA")
	private Persona idPersona;
	
	@ManyToOne
	@JoinColumn(name = "PC_ID_COMIC")
	private Comic idComic;
	
	@Column(name = "PC_FECHA_VENTA")
	private LocalDateTime fechaVenta;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Persona getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(Persona idPersona) {
		this.idPersona = idPersona;
	}

	public Comic getIdComic() {
		return idComic;
	}

	public void setIdComic(Comic idComic) {
		this.idComic = idComic;
	}

	public LocalDateTime getFechaVenta() {
		return fechaVenta;
	}

	public void setFechaVenta(LocalDateTime fechaVenta) {
		this.fechaVenta = fechaVenta;
	}
	
	

}
