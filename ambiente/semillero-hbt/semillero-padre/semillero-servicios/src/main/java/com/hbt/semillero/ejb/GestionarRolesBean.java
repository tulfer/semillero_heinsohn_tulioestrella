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

import com.hbt.semillero.dto.RolDTO;
import com.hbt.semillero.entidad.Rol;


/**
 * <b>Descripción:<b> Clase que determina el bean para realizar las gestion de roles
 * 
 * @author Tulio Estrella
 * @version
 */
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class GestionarRolesBean implements IGestionarRolesLocal {
	
	final static Logger logger = Logger.getLogger(InformacionPersonajesComicBean.class);

	/**
	 * Atributo em que se usa para interacturar con el contexto de persistencia.
	 */
	@PersistenceContext
	private EntityManager em;
	
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void crearRol(RolDTO rolNuevo) {
		logger.debug("Se ejecuta el create del CRUD");
		Rol rol = convertirRolDTOToRol(rolNuevo);
		em.persist(rol);
		logger.debug("Finaliza el create del CRUD");
	}

	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public RolDTO leerRol(Long idRol) {
		logger.debug("Se ejecuta el read del CRUD");
		Rol rol = null;
		rol = new Rol();
		rol = em.find(Rol.class, idRol);
		RolDTO rolDTO = convertirRolToRolDTO(rol);
		logger.debug("Finaliza el read del CRUD");
		return rolDTO;
	}

	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public void editarRol() {
		logger.debug("Se ejecuta el update del CRUD");
		logger.debug("Finaliza el update del CRUD");
	}

	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public void eliminarRol() {
		logger.debug("Se ejecuta el delete del CRUD");
		logger.debug("Finaliza el delete del CRUD");
	}
	
	/**
	 * 
	 * Metodo encargado de transformar un rolDTO a un rol
	 * 
	 * @param personajeDTO
	 * @return
	 */
	private Rol convertirRolDTOToRol(RolDTO rolDTO) {
		Rol rol = new Rol();
		//personaje.setId(5);
		rol.setId(rolDTO.getId());
		rol.setNombre(rolDTO.getNombre());
		rol.setEstado(rolDTO.getEstado());
		return rol;
	}
	
	/**
	 * 
	 * Metodo encargado de transformar un rol a un rolDTO
	 * 
	 * @param personaje
	 * @return
	 */
	private RolDTO convertirRolToRolDTO(Rol rol) {
		RolDTO rolDTO = new RolDTO();
		rolDTO.setId(rol.getId());
		rolDTO.setNombre(rol.getNombre());
		rolDTO.setEstado(rol.getEstado());
		return rolDTO;
	}

}