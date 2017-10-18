package app.adaptateur;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
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

import app.bean.Vote;
import app.gestion.GestionMessages;
import app.gestion.GestionUser;

/**
 * Point d'entrée (et déclaration) des services REST pour les messages, appelle les fonctions métier sous-jacentes. Chemin du
 * service REST est définit par /messages
 * @author alexm
 *
 */
@Component
@Path("/messages")
@Produces(MediaType.APPLICATION_JSON)
public class AdaptateurMessage {
	
	/** LOG de l'application */
	private static Logger LOG = Logger.getLogger(AdaptateurMessage.class);
	
	/** DAO des messages */
	@Autowired
	GestionMessages gestionMessages;
	
	/** DAO des utilisateurs */
	@Autowired
	GestionUser gestionUser;
		
	/**
	 * Récupère la liste de tous les messages
	 * @return la liste des messages
	 */
	@GET
	public List<Vote> getMessages() {
		return gestionMessages.getList();
	}
	
	/**
	 * Récupère la conversation d'un utilisateur
	 * @param id du user 
	 * @return sa conversation
	 */
	@GET
	@Path("/{id}")
	public List<Map<String, Object>> getConversation(@PathParam("id") String id) {
		return gestionMessages.getByIdUser(id).getConversation();
	}
	
	/**
	 * Ajoute un message à une conversation
	 * @param idUser user a qui ajouter un message
	 * @param contenu du message
	 * @param expediteur true si le bot envoie le message
	 * @return une Response
	 */
	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response addMessage(@FormParam("idUser") String idUser, @FormParam("contenu") String contenu, @FormParam("expediteur") Boolean expediteur) {
		Vote message = gestionMessages.getByIdUser(idUser);
		
		message.addMessage(contenu, expediteur);
		LOG.info("mise à jour du message " + message);
		
		gestionMessages.update(message);
		
		return Response.ok("Message ajouté", MediaType.APPLICATION_JSON).build();
	}
	
	/**
	 * Génère la base de données pour effectuer des tests rapide
	 * @return une response OK
	 */
	@GET
	@Path("/generateDB")
	public Response generateDB() {
		List<Map<String, Object>> messages = new ArrayList<>();
		Map<String, Object> mess = new HashMap<>();
		mess.put(Vote.TIMESTAMP, new Timestamp(System.currentTimeMillis()));
		mess.put(Vote.CONTENU, "envoyé");
		mess.put(Vote.EXPEDITEUR, true);
		messages.add(mess);
		
		mess = new HashMap<>();
		mess.put(Vote.TIMESTAMP, new Timestamp(System.currentTimeMillis()));
		mess.put(Vote.CONTENU, "reçu");
		mess.put(Vote.EXPEDITEUR, false);
		messages.add(mess);
		LOG.info(messages);
		
		Vote message1 = gestionMessages.add(new Vote(null, "1234", messages));
		gestionMessages.add(new Vote(null, "12345", messages));
		gestionMessages.add(new Vote(null, "123456", messages));
		gestionMessages.add(new Vote(null, "1234567", messages));

		message1.addMessage("envoyé2", true);
		message1.addMessage("recu2", false);
		gestionMessages.update(message1);
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
		gestionMessages.delete(id);
		return Response.ok("Message supprimé", MediaType.APPLICATION_JSON).build();
	}

}
