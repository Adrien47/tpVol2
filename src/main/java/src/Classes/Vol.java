package Classes;


import java.util.ArrayList;
import java.util.Date;

public class Vol {
	private Date dtDepart;
	private Date dtArrivee;
	private int nbPlace;
	private boolean ouvert;
	
	private Aeroport aeroportD;
	private Aeroport aeroportA;
	private ArrayList<Escale> escales = new ArrayList<>();
	private ArrayList<CompagnieAerienneVol> vols = new ArrayList<>();
	private ArrayList<Reservation> reservations = new ArrayList<>();
	
	
	
	public Aeroport getAeroportD() {
		return aeroportD;
	}
	public void setAeroportD(Aeroport aeroportD) {
		this.aeroportD = aeroportD;
	}
	public Aeroport getAeroportA() {
		return aeroportA;
	}
	public void setAeroportA(Aeroport aeroportA) {
		this.aeroportA = aeroportA;
	}
	
	public ArrayList<Escale> getEscales() {
		return escales;
	}
	public void setEscales(ArrayList<Escale> escales) {
		this.escales = escales;
	}
	public ArrayList<CompagnieAerienneVol> getVols() {
		return vols;
	}
	public void setVols(ArrayList<CompagnieAerienneVol> vols) {
		this.vols = vols;
	}
	public ArrayList<Reservation> getReservations() {
		return reservations;
	}
	public void setReservations(ArrayList<Reservation> reservations) {
		this.reservations = reservations;
	}
	public Date getDtDepart() {
		return dtDepart;
	}
	public void setDtDepart(Date dtDepart) {
		this.dtDepart = dtDepart;
	}
	public Date getDtArrivee() {
		return dtArrivee;
	}
	public void setDtArrivee(Date dtArrivee) {
		this.dtArrivee = dtArrivee;
	}
	public int getNbPlace() {
		return nbPlace;
	}
	public void setNbPlace(int nbPlace) {
		this.nbPlace = nbPlace;
	}
	public boolean isOuvert() {
		return ouvert;
	}
	public void setOuvert(boolean ouvert) {
		this.ouvert = ouvert;
	}
}
