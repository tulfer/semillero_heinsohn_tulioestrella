package com.hbt.semillero.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.hbt.semillero.dto.PersonajeDTO;
import com.hbt.semillero.dto.ResultadoDTO;
import com.hbt.semillero.ejb.IInformacionPersonajesComicLocal;

/**
 * <b>Descripción:<b> Clase que determina el servicio rest para el CRUD de informacion personajes comics
 * 
 * @author Tulio Estrella
 * @version
 */
@Path("/InformacionPersonajesComic")
public class InformacionPersonajesComicRest {

	/**
	 * Atriburo que permite gestionar el CRUD
	 */
	@EJB
	private IInformacionPersonajesComicLocal informacionPersonajesComic;


	/**
	 * 
	 * Metodo encargado del create del CRUD
	 * http://localhost:8085/semillero-servicios/rest/InformacionPersonajesComic/create
	 * 
	 * @return
	 */
	@POST
	@Path("/create")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ResultadoDTO crearPersonaje(PersonajeDTO personajeDTO) {
		informacionPersonajesComic.crearPersonaje(personajeDTO);
		ResultadoDTO resultadoDTO = new ResultadoDTO(Boolean.TRUE, "Personaje creado exitosamente");
		return resultadoDTO;
	}

	/**
	 * 
	 * Metodo encargado del read del CRUD
	 * http://localhost:8085/semillero-servicios/rest/InformacionPersonajesComic/read
	 * 
	 * @return
	 */
	@GET
	@Path("/read")
	@Produces(MediaType.APPLICATION_JSON)
	public PersonajeDTO leerPersonaje(@QueryParam("idPersonaje") Long idPersonaje) {
		if(idPersonaje != null) {
			PersonajeDTO personajeDTO = informacionPersonajesComic.leerPersonaje(idPersonaje);
			return personajeDTO;
		}
		
		return null;
	}

	/**
	 * 
	 * Metodo encargado del update del CRUD
	 * http://localhost:8085/semillero-servicios/rest/InformacionPersonajesComic/update
	 * 
	 * @return
	 */
	@GET
	@Path("/update")
	@Produces(MediaType.APPLICATION_JSON)
	public String updatePersonaje() {
		informacionPersonajesComic.editarPersonaje();
		return "Ejecuto Correctamente";
	}

	/**
	 * 
	 * Metodo encargado del delete del CRUD
	 * http://localhost:8085/semillero-servicios/rest/InformacionPersonajesComic/delete
	 * 
	 * @return
	 */
	@GET
	@Path("/delete")
	@Produces(MediaType.APPLICATION_JSON)
	public String deletePersonaje() {
		informacionPersonajesComic.eliminarPersonaje();
		return "Ejecuto Correctamente";
	}
}