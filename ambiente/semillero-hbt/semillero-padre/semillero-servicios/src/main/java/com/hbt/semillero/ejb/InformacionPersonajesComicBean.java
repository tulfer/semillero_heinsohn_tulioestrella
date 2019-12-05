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
import com.hbt.semillero.entidad.Comic;


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

	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public void crearPersonaje() {
		logger.debug("Se ejecuta el create del CRUD");
		logger.debug("Finaliza el create del CRUD");
	}

	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public void leerPersonaje() {
		logger.debug("Se ejecuta el read del CRUD");
		logger.debug("Finaliza el read del CRUD");
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

}