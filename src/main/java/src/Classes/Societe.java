package Classes;

public class Societe extends Client {
	private Long id;
	private String nom;
	private String siret;
	private String formejuridique;

	public Societe() {
		super();
	}

	
	
	public Societe(String nom, String siret, String formejuridique) {
		super();
		this.nom = nom;
		this.siret = siret;
		this.formejuridique = formejuridique;
	}



	public Societe(Long id, String nom, String siret, String formejuridique) {
		super();
		this.id = id;
		this.nom = nom;
		this.siret = siret;
		this.formejuridique = formejuridique;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getSiret() {
		return siret;
	}

	public void setSiret(String siret) {
		this.siret = siret;
	}

	public String getFormejuridique() {
		return formejuridique;
	}

	public void setFormejuridique(String formejuridique) {
		this.formejuridique = formejuridique;
	}

}
