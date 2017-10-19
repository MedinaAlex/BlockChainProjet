package app.adaptateur;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.bean.PollingPlace;
import app.gestion.ManagePollingPlace;


/**
 * Entry Point of REST services for polling place
 * @author alexm
 *
 */
@Component
@Path("/pollingplace")
@Produces(MediaType.APPLICATION_JSON)
public class AdaptatorPollingPlace {
		
	/** polling place DAO */
	@Autowired
	ManagePollingPlace managePollingPlace;
		
	/**
	 * get polling place list
	 * @return polling place list
	 */
	@GET
	public List<PollingPlace> getPollingPlaces() {
		return managePollingPlace.getList();
	}
	
	/**
	 * send an empty polling place to construct
	 * @return an empty polling place
	 */
	@GET
	@Path("empty")
	public PollingPlace getEmptyPollingPlace() {
		return new PollingPlace();
	}
	
	/**
	 * get a polling place by its Id
	 * @param id polling place Id
	 * @return a polling place
	 */
	@GET
	@Path("/{id}")
	public PollingPlace getUser(@PathParam("id") String id) {
		return managePollingPlace.getById(id);
	}
	
	/**
	 * add a polling place to the database
	 * @param pollingPlace the polling place to add
	 * @return Ok Response OK with message
	 */
	@POST
	public Response addUser(PollingPlace pollingPlace) {
		managePollingPlace.add(pollingPlace);
		
		return Response.ok("PollingPlace added", MediaType.APPLICATION_JSON).build();
	}

	/**
	 * Remove a polling place from the database
	 * @param id polling place id
	 * @return Ok Response with message
	 */
	@DELETE
	@Path("/{id}")
	public Response removeUser(@PathParam("id") String id) {
		managePollingPlace.delete(id);
		return Response.ok("polling place removed", MediaType.APPLICATION_JSON).build();
	}
}
