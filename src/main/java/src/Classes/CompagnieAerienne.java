package Classes;

import java.util.ArrayList;


public class CompagnieAerienne {
	private String nom;
	
	private ArrayList<CompagnieAerienneVol> volsProposes = new ArrayList<>();

	public ArrayList<CompagnieAerienneVol> getVolsProposes() {
		return volsProposes;
	}

	public void setVolsProposes(ArrayList<CompagnieAerienneVol> volsProposes) {
		this.volsProposes = volsProposes;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
}

