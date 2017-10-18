package app.bean;

public class Elector{

	/** Elector's ID */
	private String electorNum;
	
	/** Elector's last name */
	private String lastName;
	
	/** Elector's first name */
	private String firstName;
	
	/** Constructor */
	public Elector() {
		super();
	}
	
	/**
	 * Constructor
	 * @param id Elector's ID
	 */
	public Elector(String id) {
		this.electorNum = id;
	}

	/**
	 * Constructeur
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

	public String getNumElecteur() {
		return electorNum;
	}

	public void setNumElecteur(String id) {
		this.electorNum = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Override
	public String toString() {
		return "User [id=" + electorNum + ", nom=" + lastName + ", prenom=" + firstName + "]";
	}

}
