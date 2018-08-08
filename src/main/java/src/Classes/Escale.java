package Classes;


import java.util.Date;

public class Escale {
	private long id;
	private Date hDepart;
	private Date hArrivee;
	private Aeroport aeroport;
	private Vol vol;
	
	
	public Aeroport getAeroport() {
		return aeroport;
	}
	public void setAeroport(Aeroport aeroport) {
		this.aeroport = aeroport;
	}
	public Vol getVol() {
		return vol;
	}
	public void setVol(Vol vol) {
		this.vol = vol;
	}
	
	
	
	public Date gethDepart() {
		return hDepart;
	}
	public void sethDepart(Date hDepart) {
		this.hDepart = hDepart;
	}
	public Date gethArrivee() {
		return hArrivee;
	}
	public void sethArrivee(Date hArrivee) {
		this.hArrivee = hArrivee;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
}
