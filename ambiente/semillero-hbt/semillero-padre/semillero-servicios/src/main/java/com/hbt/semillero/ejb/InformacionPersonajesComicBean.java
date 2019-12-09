package com.hbt.semillero.ejb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;

import com.hbt.semillero.dto.ComicDTO;
import com.hbt.semillero.dto.PersonajeDTO;
import com.hbt.semillero.entidad.Comic;
import com.hbt.semillero.entidad.Personaje;


/**
 * <b>Descripción:<b> Clase que determina el bean para realizar las gestion de
 * los personajes de los comics
 * 
 * @author Tulio Estrella
 * @version
 */
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class InformacionPersonajesComicBean implements IInformacionPersonajesComicLocal {
	
	final static Logger logger = Logger.getLogger(InformacionPersonajesComicBean.class);

	/**
	 * Atributo em que se usa para interacturar con el contexto de persistencia.
	 */
	@PersistenceContext
	private EntityManager em;
	
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void crearPersonaje(PersonajeDTO personajeNuevo) {
		logger.debug("Se ejecuta el create del CRUD");
		Personaje personaje = convertirPersonajeDTOToPersonaje(personajeNuevo);
		em.persist(personaje);
		logger.debug("Finaliza el create del CRUD");
	}

	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public PersonajeDTO leerPersonaje(Long idPersonaje) {
		logger.debug("Se ejecuta el read del CRUD");
		Personaje personaje = null;
		personaje = new Personaje();
		personaje = em.find(Personaje.class, idPersonaje);
		PersonajeDTO personajeDTO = convertirPersonajeToPersonajeDTO(personaje);
		logger.debug("Finaliza el read del CRUD");
		return personajeDTO;
	}

	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public void editarPersonaje() {
		logger.debug("Se ejecuta el update del CRUD");
		logger.debug("Finaliza el update del CRUD");
	}

	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public void eliminarPersonaje() {
		logger.debug("Se ejecuta el delete del CRUD");
		logger.debug("Finaliza el delete del CRUD");
	}
	
	/**
	 * 
	 * Metodo encargado de transformar un personajeDTO a un personaje
	 * 
	 * @param personajeDTO
	 * @return
	 */
	private Personaje convertirPersonajeDTOToPersonaje(PersonajeDTO personajeDTO) {
		Personaje personaje = new Personaje();
		//personaje.setId(5);
		personaje.setId(personajeDTO.getId());
		personaje.setNombre(personajeDTO.getNombre());
		personaje.setComic(new Comic());
		personaje.getComic().setId(personajeDTO.getIdComic());
		personaje.setEstado(personajeDTO.getEstado());
		//personaje.setEstado(personajeDTO.getEstado());
		personaje.setSuperPoder(personajeDTO.getSuperPoder());
		return personaje;
	}
	
	/**
	 * 
	 * Metodo encargado de transformar un personaje a un personajeDTO
	 * 
	 * @param personaje
	 * @return
	 */
	private PersonajeDTO convertirPersonajeToPersonajeDTO(Personaje personaje) {
		PersonajeDTO personajeDTO = new PersonajeDTO();
		personajeDTO.setId(personaje.getId());
		personajeDTO.setNombre(personaje.getNombre());
		personajeDTO.setIdComic(personaje.getComic().getId());
		personajeDTO.setEstado(personaje.getEstado());
		personajeDTO.setSuperPoder(personaje.getSuperPoder());
		return personajeDTO;
	}

}