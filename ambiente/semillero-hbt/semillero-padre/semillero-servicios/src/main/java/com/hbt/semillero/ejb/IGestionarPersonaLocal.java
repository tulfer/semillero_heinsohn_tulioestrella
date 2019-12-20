package com.hbt.semillero.ejb;

import java.util.List;

import javax.ejb.Local;

import com.hbt.semillero.dto.PersonaDTO;

/**
 * Expone los métodos del EJB Perona
 * 
 * @author Tulio Estrella
 *
 */
@Local
public interface IGestionarPersonaLocal {
	
	/**
	 * 
	 * Metodo encargado del create (del CRUD)
	 * 
	 * @author Tulio Estrella
	 */
	public void crearPersona(PersonaDTO personaNuevo);

	/**
	 * 
	 * Metodo encargado del read (del CRUD)
	 * 
	 * @author Tulio Estrella
	 */
	public PersonaDTO leerPersona(Long idPersona);

	/**
	 * 
	 * Metodo encargado de retornar una lista de personas
	 * 
	 * @return
	 */
	public List<PersonaDTO> consultarPersonas();
	
	/**
	 * 
	 * Metodo encargado del update (del CRUD)
	 * 
	 * @author Tulio Estrella
	 */
	public void editarPersona();

	/**
	 * 
	 * Metodo encargado del delete (del CRUD)
	 * 
	 * @author Tulio Estrella
	 */
	public void eliminarPersona();

}
