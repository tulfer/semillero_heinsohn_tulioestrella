package com.hbt.semillero.ejb;

import java.util.List;

import javax.ejb.Local;


/**
 * Expone los métodos del EJB InformacionPersonajesComic
 * 
 * @author Tulio Estrella
 *
 */
@Local
public interface IInformacionPersonajesComicLocal {

	/**
	 * 
	 * Metodo encargado del create (del CRUD)
	 * 
	 * @author Tulio Estrella
	 */
	public void crearPersonaje();

	/**
	 * 
	 * Metodo encargado del read (del CRUD)
	 * 
	 * @author Tulio Estrella
	 */
	public void leerPersonaje();

	/**
	 * 
	 * Metodo encargado del update (del CRUD)
	 * 
	 * @author Tulio Estrella
	 */
	public void editarPersonaje();

	/**
	 * 
	 * Metodo encargado del delete (del CRUD)
	 * 
	 * @author Tulio Estrella
	 */
	public void eliminarPersonaje();


}
