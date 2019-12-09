package com.hbt.semillero.entidad;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "ROLES")
public class Rol implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(allocationSize = 1, name = "ROL_ID_GENERATOR", sequenceName = "SEC_ROL")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ROL_ID_GENERATOR")
	@Column(name = "ROL_ID")
	private Long id;
	
	@Column(name = "ROL_NOMBRE")
	private String nombre;
	
	@Column(name = "ROL_ESTADO")
	private String estado;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}