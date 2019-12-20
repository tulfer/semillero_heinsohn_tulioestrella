package com.hbt.semillero.ejb;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;

import com.hbt.semillero.dto.PersonaDTO;
import com.hbt.semillero.entidad.Persona;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class GestionarPersonaBean implements IGestionarPersonaLocal{

	final static Logger logger = Logger.getLogger(InformacionPersonajesComicBean.class);
	
	/**
	 * Atributo em que se usa para interacturar con el contexto de persistencia.
	 */
	@PersistenceContext
	private EntityManager em;
	
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void crearPersona(PersonaDTO personaNuevo) {
		logger.debug("Se ejecuta el create del CRUD");
		Persona persona = convertirPersonaDTOToPersona(personaNuevo);
		em.persist(persona);
		logger.debug("Finaliza el create del CRUD");
	}

	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public PersonaDTO leerPersona(Long idPersona) {
		logger.debug("Se ejecuta el read del CRUD");
		return null;
	}

	@Override
	public void editarPersona() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminarPersona() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * 
	 * Metodo encargado de transformar un personaDTO a un persona
	 * 
	 * @param personaDTO
	 * @return
	 */
	private Persona convertirPersonaDTOToPersona(PersonaDTO personaDTO) {
		Persona persona = new Persona();
		//personaje.setId(5);
		persona.setId(personaDTO.getId());
		persona.setNombre(personaDTO.getNombre());
		persona.setTipoDocumento(personaDTO.getTipoDocumento());
		persona.setDocumento(personaDTO.getDocumento());
		persona.setFechaNacimiento(personaDTO.getFechaNacimiento());
		return persona;
	}
	
	/**
	 * 
	 * Metodo encargado de transformar un persona a un personaDTO
	 * 
	 * @param persona
	 * @return
	 */
	private PersonaDTO convertirPersonaToPersonaDTO(Persona persona) {
		PersonaDTO personaDTO = new PersonaDTO();
		personaDTO.setId(persona.getId());
		personaDTO.setNombre(persona.getNombre());
		personaDTO.setTipoDocumento(persona.getTipoDocumento());
		personaDTO.setDocumento(persona.getDocumento());
		personaDTO.setFechaNacimiento(persona.getFechaNacimiento());
		return personaDTO;
	}
	
}
