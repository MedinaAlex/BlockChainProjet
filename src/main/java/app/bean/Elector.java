package app.bean;

/**
 * The Class Elector.
 */
public class Elector{

	/**  Elector's ID. */
	private String electorNum;
	
	/**  Elector's last name. */
	private String lastName;
	
	/**  Elector's first name. */
	private String firstName;
	
	/**
	 *  Default constructor.
	 */
	public Elector() {
		super();
	}
	
	/**
	 * Constructor with ID.
	 *
	 * @param id Elector's ID
	 */
	public Elector(String id) {
		this.electorNum = id;
	}

	/**
	 * Constructor with fields.
	 *
	 * @param id Elector's ID
	 * @param lastName du user
	 * @param firstName du user
	 */
	public Elector(String id, String lastName, String firstName) {
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
