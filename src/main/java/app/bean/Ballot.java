package app.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Ballot")
public class Ballot implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	
	public enum Type {
		PRESIDENTIELLE,
		MUNICIPALE
	};
	
	private Type type;
	
	private Set<String> candidates;
	
	private String infos;
	
	private Date date;
	
	public Ballot() {
		super();
	}

	public Ballot(String id) {
		this.id = id;
	}

	public Ballot(String id, Type type, Set<String> candidates, String infos, Date date) {
		super();
		this.id = id;
		this.type = type;
		this.candidates = candidates;
		this.infos = infos;
		this.date = date;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Set<String> getCandidates() {
		return candidates;
	}

	public void setCandidates(Set<String> candidates) {
		this.candidates = candidates;
	}

	public String getInfos() {
		return infos;
	}

	public void setInfos(String infos) {
		this.infos = infos;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Ballot [id=" + id + ", type=" + type + ", candidates=" + candidates + ", infos=" + infos + ", date="
				+ date + "]";
	}
	
	
}
