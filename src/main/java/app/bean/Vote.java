package app.bean;

/**
 * The Class Vote.
 */
public class Vote{
	
	/** The ballot id. */
	private String ballotId;
	
	/** The choice. */
	private String choice;
	
	/** The department. */
	private String department;
	
	/** The city. */
	private String city;
	
	/** The polling place id. */
	private String pollingPlaceId;

	/**
	 *  Default Constructor.
	 */
	public Vote() {
		super();
	}

	/**
	 * Constructor with fields.
	 *
	 * @param ballotId the ballot id
	 * @param choice the choice
	 * @param department the department
	 * @param city the city
	 * @param pollingPlaceId the polling place id
	 */
	public Vote(String ballotId, String choice, String department, String city, String pollingPlaceId) {
		super();
		this.ballotId = ballotId;
		this.choice = choice;
		this.department = department;
		this.city = city;
		this.pollingPlaceId = pollingPlaceId;
	}

	/**
	 * Gets the ballot id.
	 *
	 * @return the ballot id
	 */
	public String getBallotId() {
		return ballotId;
	}

	/**
	 * Sets the ballot id.
	 *
	 * @param ballotId the new ballot id
	 */
	public void setBallotId(String ballotId) {
		this.ballotId = ballotId;
	}

	/**
	 * Gets the choice.
	 *
	 * @return the choice
	 */
	public String getChoice() {
		return choice;
	}

	/**
	 * Sets the choice.
	 *
	 * @param choice the new choice
	 */
	public void setChoice(String choice) {
		this.choice = choice;
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
	 * Gets the polling place id.
	 *
	 * @return the polling place id
	 */
	public String getPollingPlaceId() {
		return pollingPlaceId;
	}

	/**
	 * Sets the polling place id.
	 *
	 * @param pollingPlaceId the new polling place id
	 */
	public void setPollingPlaceId(String pollingPlaceId) {
		this.pollingPlaceId = pollingPlaceId;
	}

        @Override
        public String toString() {
            return "Vote{" + "ballotId=" + ballotId + ", choice=" + choice + ", department=" + department + ", city=" + city + ", pollingPlaceId=" + pollingPlaceId + '}';
        }
	
}
