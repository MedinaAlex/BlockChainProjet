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

import app.bean.Ballot;
import app.gestion.ManageBallot;
import app.gestion.ManagePollingPlace;

/**
 * Entry Point of REST services for ballot
 * @author alexm
 *
 */
@Component
@Path("/ballot")
@Produces(MediaType.APPLICATION_JSON)
public class AdaptatorBallot {
		
	/** Ballot DAO */
	@Autowired
	ManageBallot manageBallot;
	
	/** Polling Place DAO */
	@Autowired
	ManagePollingPlace managePollingPlace;
		
	/**
	 * get Ballot list
	 * @return ballot list
	 */
	@GET
	public List<Ballot> getBallots() {
		return manageBallot.getList();
	}
	
	/**
	 * send an empty ballot to construct
	 * @return an empty ballot
	 */
	@GET
	@Path("empty")
	public Ballot getEmptyBallot() {
		return new Ballot();
	}
	
	/**
	 * add a ballot to the database
	 * @param ballot the ballot to add
	 * @return an Ok Response with message
	 */
	@POST
	public Response addBallot(Ballot ballot) {
		manageBallot.add(ballot);
		
		return Response.ok("added ballot", MediaType.APPLICATION_JSON).build();
	}
	
	/**
	 * Remove a ballot from the database
	 * @param id ballot id
	 * @return Ok response
	 */
	@DELETE
	@Path("/{id}")
	public Response removeBallot(@PathParam("id") String id) {
		manageBallot.delete(id);
		return Response.ok("ballot removed", MediaType.APPLICATION_JSON).build();
	}

}
