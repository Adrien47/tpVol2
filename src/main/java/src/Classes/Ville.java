package Classes;

import java.util.ArrayList;

public class Ville {
	private Long id;
	private String nom;
	private String codePostal;
	private String pays;
	private ArrayList<Aeroport> aeroports = new ArrayList<>();
	
	
	public Ville() {
		super();
	}

	public Ville(String nom, String codePostal, String pays) {
		super();
		this.nom = nom;
		this.codePostal = codePostal;
		this.pays = pays;
	}

	public Ville(Long id, String nom, String codePostal, String pays) {
		super();
		this.id = id;
		this.nom = nom;
		this.codePostal = codePostal;
		this.pays = pays;
	}

	public ArrayList<Aeroport> getAeroports() {
		return aeroports;
	}

	public void setAeroports(ArrayList<Aeroport> aeroports) {
		this.aeroports = aeroports;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	// public String ecrire() {
	// if (nom == null || codePostal == null) {
	// throw new FormationException("Le nom ou le code postal de la ville n'est pas
	// renseigné");
	// }

	// return "Eleve [id=" + id + ", nom=" + nom + ", codePostal=" + codePostal + ",
	// pays=" + pays
	// + "]";
	// }
	//
	@Override
	public String toString() {
		return "Ville [id=" + id + ", nom=" + nom + ", codePostal=" + codePostal + ", pays=" + pays + "]";
	}

	public String getNom() {
		return nom;
	}

}
