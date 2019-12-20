package com.hbt.semillero.rest;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.hbt.semillero.dto.PersonaDTO;
import com.hbt.semillero.dto.ResultadoDTO;
import com.hbt.semillero.ejb.IGestionarPersonaLocal;

/**
 * <b>Descripción:<b> Clase que determina el servicio rest para el CRUD de Personas
 * 
 * @author Tulio Estrella
 * @version
 */
@Path("/GestionarPersonas")
public class GestionarPersonaRest {

	/**
	 * Atriburo que permite gestionar el CRUD
	 */
	@EJB
	private IGestionarPersonaLocal gestionarPersona;
	
	/**
	 * 
	 * Metodo encargado del create del CRUD
	 * http://localhost:8085/semillero-servicios/rest/GestionarPersona/create
	 * 
	 * @return
	 */
	@POST
	@Path("/create")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ResultadoDTO crearPersonaje(PersonaDTO personaDTO) {
		gestionarPersona.crearPersona(personaDTO);
		ResultadoDTO resultadoDTO = new ResultadoDTO(Boolean.TRUE, "Persona creado exitosamente");
		return resultadoDTO;
	}
	
}
