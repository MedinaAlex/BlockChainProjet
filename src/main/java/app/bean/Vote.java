package app.bean;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

/** Déclaration de l'Objet */

public class Vote implements Serializable{

	/** Autogénéré */
	private static final long serialVersionUID = 1L;
	
	/** Variable TimeStamp */
	public static final String TIMESTAMP = "timeStamp";
	
	/** Variable Contenu */
	public static final String CONTENU = "contenu";
	
	/** Variable Expediteur */
	public static final String EXPEDITEUR = "expediteur";
	
	/** Id du message */
	@Id
	private String id;
	
	/** Id du user */
	@Indexed
	private String idUser;
	
	/** Liste de messages envoyés et reçus */
	List<Map<String, Object>> conversation;

	/** Constructeur vide */
	public Vote() {
		super();
	}

	/**
	 * Constructeur
	 * @param id du message, peut être null
	 */
	public Vote(String id) {
		this.id = id;
	}

	/** 
	 * Constructeur
	 * @param id du message, peut être null
	 * @param idUser id du User
	 */
	public Vote(String id, String idUser) {
		super();
		this.id = id;
		this.idUser = idUser;
		this.conversation = new ArrayList<>();
	}
	
	/**
	 * Constructeur
	 * @param id du message, peut être null
	 * @param idUser du User
	 * @param messages envoyés et reçus
	 */
	public Vote(String id, String idUser, List<Map<String, Object>> messages) {
		super();
		this.id = id;
		this.idUser = idUser;
		this.conversation = messages;
	}

	/**
	 * Ajout d'un message 
	 * @param contenu du message
	 * @param expediteur true si le bot envoie le message
	 */
	public void addMessage(String contenu, Boolean expediteur) {
		Map<String, Object> map = new HashMap<>();
		map.put(TIMESTAMP, new Timestamp(System.currentTimeMillis()));
		map.put(CONTENU, contenu);
		map.put(EXPEDITEUR, expediteur);
		this.conversation.add(map);
	}

	/** Getter de l'id */
	public String getId() {
		return id;
	}

	/** Getter de l'idUser */
	public String getIdUser() {
		return idUser;
	}

	/** Getter de la conversation */
	public List<Map<String, Object>> getConversation() {
		return conversation;
	}

	/**
	 * Setter de la conversation
	 * @param conversation la nouvelle conversation
	 */
	public void setConversation(List<Map<String, Object>> conversation) {
		this.conversation = conversation;
	}

	/** ToString */
	@Override
	public String toString() {
		return "Message [id=" + id + ", idUser=" + idUser + ", conversation=" + conversation + "]";
	}

	/** equals */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vote other = (Vote) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (idUser == null) {
			if (other.idUser != null)
				return false;
		} else if (!idUser.equals(other.idUser))
			return false;
		return true;
	}

}
