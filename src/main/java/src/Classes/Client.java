package Classes;

import java.util.ArrayList;

public abstract class  Client {
	
	private Long id;
	private String type;
	private String nom;
	private Adresse adresse; 
	private ArrayList<Reservation> reservations = new ArrayList<>(); 
	


	public Client() {
		super();
	}

	public Client(Long id, String type, String nom, Adresse adresse) {
		super();
		this.id = id;
		this.type = type;
		this.nom = nom;
		this.adresse = adresse;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public ArrayList<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(ArrayList<Reservation> reservations) {
		this.reservations = reservations;
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
	
	
}
