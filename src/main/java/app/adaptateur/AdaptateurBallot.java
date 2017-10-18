package app.adaptateur;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.bean.Ballot;
import app.gestion.ManageBallot;
import app.gestion.ManagePollingPlace;

/**
 * Point d'entrée (et déclaration) des services REST pour les messages, appelle les fonctions métier sous-jacentes. Chemin du
 * service REST est définit par /messages
 * @author alexm
 *
 */
@Component
@Path("/ballot")
@Produces(MediaType.APPLICATION_JSON)
public class AdaptateurBallot {
	
	/** LOG de l'application */
	private static Logger LOG = Logger.getLogger(AdaptateurBallot.class);
	
	/** DAO des messages */
	@Autowired
	ManageBallot manageBallot;
	
	/** DAO des utilisateurs */
	@Autowired
	ManagePollingPlace gestionUser;
		
	/**
	 * Récupère la liste de tous les messages
	 * @return la liste des messages
	 */
	@GET
	public List<Ballot> getMessages() {
		return manageBallot.getList();
	}
	
	@GET
	@Path("empty")
	public Ballot getEmptyBallot() {
		return new Ballot();
	}
	
	/**
	 * Ajoute un message à une conversation
	 * @param idUser user a qui ajouter un message
	 * @param contenu du message
	 * @param expediteur true si le bot envoie le message
	 * @return une Response
	 */
	@POST
	@Path("/{ballot}")
	public Response addMessage(@PathParam("ballot") Ballot ballot) {
		
		manageBallot.add(ballot);
		
		return Response.ok("added ballot", MediaType.APPLICATION_JSON).build();
	}
	
	/**
	 * Génère la base de données pour effectuer des tests rapide
	 * @return une response OK
	 */
	@GET
	@Path("/generateDB")
	public Response generateDB() {
		/*List<Map<String, Object>> messages = new ArrayList<>();
		Map<String, Object> mess = new HashMap<>();
		mess.put(Ballot.TIMESTAMP, new Timestamp(System.currentTimeMillis()));
		mess.put(Ballot.CONTENU, "envoyé");
		mess.put(Ballot.EXPEDITEUR, true);
		messages.add(mess);
		
		mess = new HashMap<>();
		mess.put(Ballot.TIMESTAMP, new Timestamp(System.currentTimeMillis()));
		mess.put(Ballot.CONTENU, "reçu");
		mess.put(Ballot.EXPEDITEUR, false);
		messages.add(mess);
		LOG.info(messages);
		
		Ballot message1 = manageBallot.add(new Ballot(null, "1234", messages));
		manageBallot.add(new Ballot(null, "12345", messages));
		manageBallot.add(new Ballot(null, "123456", messages));
		manageBallot.add(new Ballot(null, "1234567", messages));

		message1.addMessage("envoyé2", true);
		message1.addMessage("recu2", false);
		manageBallot.update(message1);*/
		return Response.ok("Base Générée", MediaType.APPLICATION_JSON).build();
	}
	
	/**
	 * Supprime un Message
	 * @param id du Message
	 * @return une response OK
	 */
	@DELETE
	@Path("/{id}")
	public Response removeMessage(@PathParam("id") String id) {
		manageBallot.delete(id);
		return Response.ok("Message supprimé", MediaType.APPLICATION_JSON).build();
	}

}
