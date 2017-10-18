package app.bean;

import java.io.Serializable;

public class Vote implements Serializable{

	/** Autogenerate */
	private static final long serialVersionUID = 1L;
	
	private String ballotId;
	
	private String choice;
	
	private String department;
	
	private String city;
	
	private String pollingPlaceId;

	/** Constructeur vide */
	public Vote() {
		super();
	}

	public Vote(String ballotId, String choice, String department, String city, String pollingPlaceId) {
		super();
		this.ballotId = ballotId;
		this.choice = choice;
		this.department = department;
		this.city = city;
		this.pollingPlaceId = pollingPlaceId;
	}

	public String getBallotId() {
		return ballotId;
	}

	public void setBallotId(String ballotId) {
		this.ballotId = ballotId;
	}

	public String getChoice() {
		return choice;
	}

	public void setChoice(String choice) {
		this.choice = choice;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPollingPlaceId() {
		return pollingPlaceId;
	}

	public void setPollingPlaceId(String pollingPlaceId) {
		this.pollingPlaceId = pollingPlaceId;
	}
	
	

	
}
