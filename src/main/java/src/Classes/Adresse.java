package Classes;



public class Adresse {
		private String rue; 
		private String codepostal ; 
		private String ville; 
		private String pays;
		
		public Adresse() {
			
		}

		
		public Adresse(String rue, String codepostal, String ville, String pays) {
			super();
			this.rue = rue;
			this.codepostal = codepostal;
			this.ville = ville;
			this.pays = pays;
		}


		public String getRue() {
			return rue;
		}
		public void setRue(String rue) {
			this.rue = rue;
		}
		public String getCodepostal() {
			return codepostal;
		}
		public void setCodepostal(String codepostal) {
			this.codepostal = codepostal;
		}
		public String getVille() {
			return ville;
		}
		public void setVille(String ville) {
			this.ville = ville;
		}
		public String getPays() {
			return pays;
		}
		public void setPays(String pays) {
			this.pays = pays;
		} 
		
}
