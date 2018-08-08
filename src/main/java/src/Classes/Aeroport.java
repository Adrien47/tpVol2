package Classes;

import java.util.ArrayList;

public class Aeroport {
	private Long id;
	private String code;
	private ArrayList<Ville> villesDesservies = new ArrayList<>();
	private ArrayList<Escale> escales = new ArrayList<>();
	
	

	public Aeroport() {
		super();
	}

	public Aeroport(String code) {
		super();
		this.code = code;
		
	}
	
	public Aeroport(Long id, String code) {
		super();
		this.id = id;
		this.code = code;
	}

	public Aeroport(String code, ArrayList<Ville> villesDesservies, ArrayList<Escale> escales) {
		super();
		this.code = code;
		this.villesDesservies = villesDesservies;
		this.escales = escales;
	}


	
	@Override
	public String toString() {
		return "Aeroport [id=" + id + ", code=" + code + "]";
	}

	public ArrayList<Escale> getEscales() {
		return escales;
	}

	public void setEscales(ArrayList<Escale> escales) {
		this.escales = escales;
	}

	public ArrayList<Ville> getVillesDesservies() {
		return villesDesservies;
	}

	public void setVillesDesservies(ArrayList<Ville> villesDesservies) {
		this.villesDesservies = villesDesservies;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
