package app.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * The Class Ballot.
 */
@Document(collection = "Ballot")
public class Ballot implements Serializable{

	/**  default serialId. */
	private static final long serialVersionUID = 1L;
	
	/**  primary key. */
	@Id
	private String id;
	
	/**
	 *  enum Type of a ballot.
	 */
	public enum Type {
		
		/** The presidentielle. */
		PRESIDENTIELLE,
		
		/** The municipale. */
		MUNICIPALE
	};
	
	/**  Type of the ballot. */
	private Type type;
	
	/**  Set containing candidates. */
	private Set<String> candidates;
	
	/**  Informations of the ballot. */
	private String infos;
	
	/**  Date of the ballot. */
	private Date date;
	
	/**
	 *  Default contructor.
	 */
	public Ballot() {
		super();
	}

	/**
	 *  Constructor with id .
	 *
	 * @param id ballot Id
	 */
	public Ballot(String id) {
		this.id = id;
	}

	/**
	 *  Constructor withs fields.
	 *
	 * @param id ballot ID
	 * @param type ballot Type
	 * @param candidates ballot candidates
	 * @param infos ballot informations
	 * @param date ballot Date
	 */
	public Ballot(String id, Type type, Set<String> candidates, String infos, Date date) {
		super();
		this.id = id;
		this.type = type;
		this.candidates = candidates;
		this.infos = infos;
		this.date = date;
	}

	
	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Gets the candidates.
	 *
	 * @return the candidates
	 */
	public Set<String> getCandidates() {
		return candidates;
	}

	/**
	 * Sets the candidates.
	 *
	 * @param candidates the new candidates
	 */
	public void setCandidates(Set<String> candidates) {
		this.candidates = candidates;
	}

	/**
	 * Gets the infos.
	 *
	 * @return the infos
	 */
	public String getInfos() {
		return infos;
	}

	/**
	 * Sets the infos.
	 *
	 * @param infos the new infos
	 */
	public void setInfos(String infos) {
		this.infos = infos;
	}

	/**
	 * Gets the date.
	 *
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * Sets the date.
	 *
	 * @param date the new date
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * Gets the type.
	 *
	 * @return the type
	 */
	public Type getType() {
		return type;
	}

	/**
	 * Sets the type.
	 *
	 * @param type the new type
	 */
	public void setType(Type type) {
		this.type = type;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Ballot [id=" + id + ", type=" + type + ", candidates=" + candidates + ", infos=" + infos + ", date="
				+ date + "]";
	}
}
