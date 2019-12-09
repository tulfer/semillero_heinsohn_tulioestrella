package com.hbt.semillero.ejb;

import java.util.List;

import javax.ejb.Local;

import com.hbt.semillero.dto.RolDTO;


/**
 * Expone los métodos del EJB Roles
 * 
 * @author Tulio Estrella
 *
 */
@Local
public interface IGestionarRolesLocal {

	/**
	 * 
	 * Metodo encargado del create (del CRUD)
	 * 
	 * @author Tulio Estrella
	 */
	public void crearRol(RolDTO rolNuevo);

	/**
	 * 
	 * Metodo encargado del read (del CRUD)
	 * 
	 * @author Tulio Estrella
	 */
	public RolDTO leerRol(Long idRol);

	/**
	 * 
	 * Metodo encargado del update (del CRUD)
	 * 
	 * @author Tulio Estrella
	 */
	public void editarRol();

	/**
	 * 
	 * Metodo encargado del delete (del CRUD)
	 * 
	 * @author Tulio Estrella
	 */
	public void eliminarRol();


}
