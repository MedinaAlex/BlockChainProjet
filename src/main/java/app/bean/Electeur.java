package app.bean;

import java.io.Serializable;

import org.springframework.data.annotation.Id;

/** Déclaration de l'Objet */

public class Electeur implements Serializable{
	
	/** Autogénéré */
	private static final long serialVersionUID = 1L;

	/** Id du message */
	@Id
	private String numElecteur;
	
	/** Nom du User */
	private String nom;
	
	/** Prenom du User */
	private String prenom;
	
	/** Constructeur */
	public Electeur() {
		super();
	}
	
	/**
	 * Constructeur
	 * @param id du message, peut être null
	 */
	public Electeur(String id) {
		this.numElecteur = id;
	}

	/**
	 * Constructeur
	 * @param id du user
	 * @param nom du user
	 * @param prenom du user
	 */
	public Electeur(String id, String nom, String prenom) {
		super();
		this.numElecteur = id;
		this.nom = nom;
		this.prenom = prenom;

	}

	public String getNumElecteur() {
		return numElecteur;
	}

	public void setNumElecteur(String id) {
		this.numElecteur = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	@Override
	public String toString() {
		return "User [id=" + numElecteur + ", nom=" + nom + ", prenom=" + prenom + "]";
	}

}
