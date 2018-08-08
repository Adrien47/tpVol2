package Classes;


import java.util.Date;

public class Passager {
	
	private String nom; 
	private String prenom ; 
	private String PI; 
	private Date dtnaissance; 
	private Adresse adresse;
	private Reservation reservation; 
	
	
	
	public Reservation getReservation() {
		return reservation;
	}
	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}
	public Adresse getAdresse() {
		return adresse;
	}
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
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
	public String getPI() {
		return PI;
	}
	public void setPI(String pI) {
		PI = pI;
	}
	public Date getDtnaissance() {
		return dtnaissance;
	}
	public void setDtnaissance(Date dtnaissance) {
		this.dtnaissance = dtnaissance;
	} 
	
}
