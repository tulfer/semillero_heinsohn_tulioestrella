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

import com.hbt.semillero.dto.RolDTO;
import com.hbt.semillero.dto.ResultadoDTO;
import com.hbt.semillero.ejb.IGestionarRolesLocal;

/**
 * <b>Descripción:<b> Clase que determina el servicio rest para el CRUD de roles
 * 
 * @author Tulio Estrella
 * @version
 */
@Path("/GestionarRoles")
public class GestionarRolesRest {

	/**
	 * Atriburo que permite gestionar el CRUD
	 */
	@EJB
	private IGestionarRolesLocal gestionarRoles;


	/**
	 * 
	 * Metodo encargado del create del CRUD
	 * http://localhost:8085/semillero-servicios/rest/GestionarRoles/create
	 * 
	 * @return
	 */
	@POST
	@Path("/create")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ResultadoDTO crearRol(RolDTO rolDTO) {
		gestionarRoles.crearRol(rolDTO);
		ResultadoDTO resultadoDTO = new ResultadoDTO(Boolean.TRUE, "Rol creado exitosamente");
		return resultadoDTO;
	}

	/**
	 * 
	 * Metodo encargado del read del CRUD
	 * http://localhost:8085/semillero-servicios/rest/GestionarRoles/read
	 * 
	 * @return
	 */
	@GET
	@Path("/read")
	@Produces(MediaType.APPLICATION_JSON)
	public RolDTO leerPersonaje(@QueryParam("idRol") Long idRol) {
		if(idRol != null) {
			RolDTO rolDTO = gestionarRoles.leerRol(idRol);
			return rolDTO;
		}
		
		return null;
	}

	/**
	 * 
	 * Metodo encargado del update del CRUD
	 * http://localhost:8085/semillero-servicios/rest/GestionarRoles/update
	 * 
	 * @return
	 */
	@GET
	@Path("/update")
	@Produces(MediaType.APPLICATION_JSON)
	public String updateRol() {
		gestionarRoles.editarRol();
		return "Ejecuto Correctamente";
	}

	/**
	 * 
	 * Metodo encargado del delete del CRUD
	 * http://localhost:8085/semillero-servicios/rest/GestionarRoles/delete
	 * 
	 * @return
	 */
	@GET
	@Path("/delete")
	@Produces(MediaType.APPLICATION_JSON)
	public String deleteRol() {
		gestionarRoles.eliminarRol();
		return "Ejecuto Correctamente";
	}
}