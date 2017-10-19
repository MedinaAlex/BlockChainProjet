package app.bean;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * The Class PollingPlace.
 */
@Document(collection="PollingPlace")
public class PollingPlace implements Serializable{
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**  Polling place's Id. */
	@Id
	private String id;
	
	/**  Polling place's department. */
	private String department;
	
	/**  Polling place's city. */
	private String city;
	
	
	/**  Polling place's number. */
	private String pollingPlaceNumber;
	
	/**
	 *  Default constructor.
	 */ 
	public PollingPlace() {
		super();
	}
	
	/**
	 *  Constructor with Id.
	 *
	 * @param id the id
	 */
	public PollingPlace(String id) {
		super();
		this.id = id;
	}

	/**
	 *  Constructor with fields.
	 *
	 * @param id the id
	 * @param department the department
	 * @param city the city
	 * @param pollingPlaceNumber the number
	 */
	public PollingPlace(String id, String department, String city, String pollingPlaceNumber) {
		super();
		this.id = id;
		this.department = department;
		this.city = city;
		this.pollingPlaceNumber = pollingPlaceNumber;
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
	 * Gets the department.
	 *
	 * @return the department
	 */
	public String getDepartment() {
		return department;
	}

	/**
	 * Sets the department.
	 *
	 * @param department the new department
	 */
	public void setDepartment(String department) {
		this.department = department;
	}

	/**
	 * Gets the city.
	 *
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * Sets the city.
	 *
	 * @param city the new city
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * Gets the polling place number.
	 *
	 * @return the polling place number
	 */
	public String getPollingPlaceNumber() {
		return pollingPlaceNumber;
	}

	/**
	 * Sets the polling place number.
	 *
	 * @param pollingPlaceNumber the new polling place number
	 */
	public void setPollingPlaceNumber(String pollingPlaceNumber) {
		this.pollingPlaceNumber = pollingPlaceNumber;
	}
}
