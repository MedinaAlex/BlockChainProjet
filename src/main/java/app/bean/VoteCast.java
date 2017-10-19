package app.bean;

/**
 * The Class VoteCast.
 */
public class VoteCast{

	/**  VoteCast's ID. */
	private String electorNum;
	
	/**  VoteCast's last name. */
	private String lastName;
	
	/**  VoteCast's first name. */
	private String firstName;
	
	/**
	 *  Default constructor.
	 */
	public VoteCast() {
		super();
	}
	
	/**
	 * Constructor with ID.
	 *
	 * @param id Elector's ID
	 */
	public VoteCast(String id) {
		this.electorNum = id;
	}

	/**
	 * Constructor with fields.
	 *
	 * @param id Elector's ID
	 * @param lastName du user
	 * @param firstName du user
	 */
	public VoteCast(String id, String lastName, String firstName) {
		super();
		this.electorNum = id;
		this.lastName = lastName;
		this.firstName = firstName;
	}

	
	/**
	 * Gets the num electeur.
	 *
	 * @return the num electeur
	 */
	public String getNumElecteur() {
		return electorNum;
	}

	/**
	 * Sets the num electeur.
	 *
	 * @param id the new num electeur
	 */
	public void setNumElecteur(String id) {
		this.electorNum = id;
	}

	/**
	 * Gets the last name.
	 *
	 * @return the last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Sets the last name.
	 *
	 * @param lastName the new last name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Gets the first name.
	 *
	 * @return the first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Sets the first name.
	 *
	 * @param firstName the new first name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User [id=" + electorNum + ", nom=" + lastName + ", prenom=" + firstName + "]";
	}

}
