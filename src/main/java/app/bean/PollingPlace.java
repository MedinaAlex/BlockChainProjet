package app.bean;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="PollingPlace")
public class PollingPlace implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	
	private String department;
	
	private String city;
	
	private String pollingPlaceNumber;
	
	public PollingPlace() {
		super();
	}
	
	public PollingPlace(String id) {
		super();
		this.id = id;
	}

	public PollingPlace(String id, String department, String city, String pollingPlaceNumber) {
		super();
		this.id = id;
		this.department = department;
		this.city = city;
		this.pollingPlaceNumber = pollingPlaceNumber;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getPollingPlaceNumber() {
		return pollingPlaceNumber;
	}

	public void setPollingPlaceNumber(String pollingPlaceNumber) {
		this.pollingPlaceNumber = pollingPlaceNumber;
	}
}
