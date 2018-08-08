package Classes;



public class Reservation {

	
	private String code; 
	private Boolean confirmee ; 
	private Boolean annulee;
	private Client client; 
	private Passager passager; 
	private Vol vol;
	
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Boolean getConfirmee() {
		return confirmee;
	}
	
	public void setConfirmee(Boolean confirmee) {
		this.confirmee = confirmee;
	}
	public Boolean getAnnulee() {
		return annulee;
	}
	public void setAnnulee(Boolean annulee) {
		this.annulee = annulee;
	} 
	
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Passager getPassager() {
		return passager;
	}
	public void setPassager(Passager passager) {
		this.passager = passager;
	}
	public Vol getVol() {
		return vol;
	}
	public void setVol(Vol vol) {
		this.vol = vol;
	}
	 
}
