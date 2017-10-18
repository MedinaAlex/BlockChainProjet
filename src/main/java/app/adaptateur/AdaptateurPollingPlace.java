package app.adaptateur;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.bean.Ballot;
import app.bean.PollingPlace;
import app.gestion.ManagePollingPlace;


/**
 * Point d'entrée (et déclaration) des services REST pour les utilisateurs, appelle les fonctions métier sous-jacentes. Chemin du
 * service REST est définit par /users
 * @author alexm
 *
 */
@Component
@Path("/pollingplace")
@Produces(MediaType.APPLICATION_JSON)
public class AdaptateurPollingPlace {
	
	/** LOG de l'application */
	private static Logger LOG = Logger.getLogger(AdaptateurPollingPlace.class);
	
	/** DAO des users */
	@Autowired
	ManagePollingPlace managePollingPlace;
		
	/**
	 * récupère la liste de tous les users
	 * @return la liste des users
	 */
	@GET
	public List<PollingPlace> getUsers() {
		return managePollingPlace.getList();
	}
	
	@GET
	@Path("empty")
	public PollingPlace getEmptyPollingPlace() {
		return new PollingPlace();
	}
	
	/**
	 * récupère un User selon son id
	 * @param idUser l'id du user
	 * @return le user
	 */
	@GET
	@Path("/{id}")
	public PollingPlace getUser(@PathParam("id") String idUser) {
		return managePollingPlace.getById(idUser);
	}
	
	/**
	 * Ajoute un User à la base de données
	 * @param id l'id du user, peut être null il sera généré automatiquement par Mongo
	 * @param prenom du User
	 * @param nom du User
	 * @return Une Response OK avec un message si
	 */
	@POST
	public Response addUser(PollingPlace pollingPlace) {
		managePollingPlace.add(pollingPlace);
		
		return Response.ok("PollingPlace added", MediaType.APPLICATION_JSON).build();
	}
	
	/**
	 * Génère des users dans la base de données pour effectuer des tests rapide
	 * @return Response Ok
	 */
	@GET
	@Path("/generateDB")
	public Response generateDB() {
		managePollingPlace.add(new PollingPlace(null,"44","Nantes","145"));
		managePollingPlace.add(new PollingPlace(null,"44","Nantes","146"));
		managePollingPlace.add(new PollingPlace(null,"44","Carquefou","14"));
		managePollingPlace.add(new PollingPlace(null,"44","Carquefou","15"));
		managePollingPlace.add(new PollingPlace(null,"44","Nantes","115"));
		
		
		return Response.ok("Database PollingPlace generated", MediaType.APPLICATION_JSON).build();
	}

	/**
	 * Supprime un User
	 * @param id du User à supprimer
	 * @return
	 */
	@DELETE
	@Path("/{id}")
	public Response removeUser(@PathParam("id") String id) {
		managePollingPlace.delete(id);
		return Response.ok("User supprimé", MediaType.APPLICATION_JSON).build();
	}
}
