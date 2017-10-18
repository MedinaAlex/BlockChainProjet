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

import app.bean.Electeur;
import app.gestion.GestionUser;


/**
 * Point d'entrée (et déclaration) des services REST pour les utilisateurs, appelle les fonctions métier sous-jacentes. Chemin du
 * service REST est définit par /users
 * @author alexm
 *
 */
@Component
@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
public class AdaptateurUser {
	
	/** LOG de l'application */
	private static Logger LOG = Logger.getLogger(AdaptateurUser.class);
	
	/** DAO des users */
	@Autowired
	GestionUser gestionUser;
		
	/**
	 * récupère la liste de tous les users
	 * @return la liste des users
	 */
	@GET
	public List<Electeur> getUsers() {
		return gestionUser.getList();
	}
	
	/**
	 * récupère un User selon son id
	 * @param idUser l'id du user
	 * @return le user
	 */
	@GET
	@Path("/{id}")
	public Electeur getUser(@PathParam("id") String idUser) {
		return gestionUser.getById(idUser);
	}
	
	/**
	 * Ajoute un User à la base de données
	 * @param id l'id du user, peut être null il sera généré automatiquement par Mongo
	 * @param prenom du User
	 * @param nom du User
	 * @return Une Response OK avec un message si
	 */
	@POST
	@Path("/add")
	public Response addUser(@FormParam("id") String id, @FormParam("prenom") String prenom, @FormParam("nom") String nom) {
		Response resp;
		if (gestionUser.getById(id) == null ) {
			Electeur user = new Electeur(id, nom, prenom);
			LOG.info("add user " + user);
			
			gestionUser.add(user);
			resp = Response.ok("User ajouté", MediaType.APPLICATION_JSON).build();
		}else {
			LOG.info("User déjà existant");
			resp = Response.ok("User déjà existant", MediaType.APPLICATION_JSON).build();
		}
		
		return resp;
	}
	
	/**
	 * Génère des users dans la base de données pour effectuer des tests rapide
	 * @return Response Ok
	 */
	@GET
	@Path("/generateDB")
	public Response generateDB() {
		gestionUser.add(new Electeur("1234", "Alex", "Medina"));
		gestionUser.add(new Electeur(null, "Amandine", "Medina"));
		gestionUser.add(new Electeur(null, "Adrien", "Medina"));
		gestionUser.add(new Electeur(null, "Romain", "Medina"));
		gestionUser.add(new Electeur(null, "Flavien", "Medina"));
		
		return Response.ok("Base générée", MediaType.APPLICATION_JSON).build();
	}

	/**
	 * Supprime un User
	 * @param id du User à supprimer
	 * @return
	 */
	@DELETE
	@Path("/{id}")
	public Response removeUser(@PathParam("id") String id) {
		gestionUser.delete(id);
		return Response.ok("User supprimé", MediaType.APPLICATION_JSON).build();
	}
}
