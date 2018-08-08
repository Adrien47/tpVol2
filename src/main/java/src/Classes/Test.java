package Classes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class Test {
	public static void main(String[] args) {
		Societe sopra = new Societe();
		Particulier fernand = new Particulier();
		Passager jeanMarc = new Passager();
		Passager jeanHugues = new Passager();
		
		Adresse adresseSopra = new Adresse();
		Adresse adresseJeanHugues = new Adresse();
		Adresse adresseJeanMarc = new Adresse();
		Adresse adresseFernand = new Adresse();
		
		Reservation reservation1 = new Reservation(); 
		Reservation reservation2 = new Reservation(); 
		
		Ville londres = new Ville(); 
		Ville losangeles = new Ville(); 
		Ville paris = new Ville(); 
		Ville newyork = new Ville(); 
		Ville miami = new Ville(); 
		
		Aeroport cdg = new Aeroport(); 
		Aeroport jfk = new Aeroport(); 
		Aeroport lax = new Aeroport(); 
		Aeroport lnd = new Aeroport(); 
		Aeroport mam = new Aeroport(); 
		
		CompagnieAerienne easyJet = new CompagnieAerienne();
	    CompagnieAerienne klm = new CompagnieAerienne();
	    CompagnieAerienneVol num1 = new CompagnieAerienneVol();
	    CompagnieAerienneVol num2 = new CompagnieAerienneVol();
	    Vol vol1 = new Vol();
	    Vol vol2 = new Vol();
	    Escale escale11 = new Escale();
	    Escale escale21 = new Escale();
	    Escale escale22 = new Escale();
		
		
	
		
	    // SETUP Sopra Steria
		sopra.setSiret("n�Siret");
		sopra.setNom("SopraSteria");
		sopra.setFormejuridique("sarl");
		sopra.setAdresse(adresseSopra);
		Reservation[] reservationsSopraTableau = {reservation1};
		ArrayList<Reservation> reservationsSopra = new ArrayList<>(Arrays.asList(reservationsSopraTableau));
		sopra.setReservations(reservationsSopra);
		adresseSopra.setRue("Rue des Concombres");
		adresseSopra.setCodepostal("33400");
		adresseSopra.setVille("Bordeaux");
		adresseSopra.setPays("France"); 
		
		// SETUP fernand
		
		fernand.setCivilite("Mr");
		fernand.setPrenom("Fernand");
		fernand.setNom("De La Tour");
		fernand.setAdresse(adresseFernand);
		Reservation[] reservationsFernandTableau = {reservation2};
		ArrayList<Reservation> reservationsFernand = new ArrayList<>(Arrays.asList(reservationsFernandTableau));
		fernand.setReservations(reservationsFernand);
		adresseFernand.setRue("Rue des chocolatines");
		adresseFernand.setCodepostal("33754");
		adresseFernand.setVille("Tabernac");
		adresseFernand.setPays("France");
		
		// SETUP JeanMarc
		
		jeanMarc.setNom("De La Pacotille");
		jeanMarc.setPrenom("Jean-Marc");
		jeanMarc.setDtnaissance(new Date(1960, 3, 23, 12, 00, 45));
		jeanMarc.setPI("Pieceidentit�JM");
		jeanMarc.setAdresse(adresseJeanMarc);
		jeanMarc.setReservation(reservation1);
		adresseJeanMarc.setRue("Rue des croissants au beurre");
		adresseJeanMarc.setCodepostal("56876");
		adresseJeanMarc.setVille("lesBiloutes");
		adresseJeanMarc.setPays("Chine");
		
		// SETUP JeanHugues
		

		jeanHugues.setNom("De la Maison neuve");
		jeanHugues.setPrenom("Jean-Hugues");
		jeanHugues.setDtnaissance(new Date(1955, 6, 29, 07, 23, 28));
		jeanHugues.setPI("Pieceidentit�JH");
		jeanHugues.setAdresse(adresseJeanHugues);
		jeanHugues.setReservation(reservation2);
		adresseJeanHugues.setRue("Rue de la trucMuche");
		adresseJeanHugues.setCodepostal("13589");
		adresseJeanHugues.setVille("Pancake");
		adresseJeanHugues.setPays("USA");
		
		// SETUP reservation
		
		reservation1.setCode("123"); 
		reservation2.setCode("234"); 
		reservation1.setAnnulee(true);
		reservation2.setConfirmee(false);
		reservation1.setClient(sopra); 
		reservation2.setClient(fernand); 
		reservation1.setPassager(jeanMarc); 
		reservation2.setPassager(jeanHugues);
		reservation1.setVol(vol1);
		reservation2.setVol(vol2); 
		
		// SETUP Aeroport
		
		cdg.setCode("CDG"); 
		jfk.setCode("JFK"); 
		lax.setCode("LAX");
		lnd.setCode("LND");
		mam.setCode("MAM"); 
		
		//SETUP Villes
		
		londres.setNom("Londres"); 
		losangeles.setNom("Los-Angeles"); 
		paris.setNom("Paris");
		newyork.setNom("New-York");
		miami.setNom("Miami");
		
		
	

		// SETUP CAV
		num1.setCompagnie(easyJet);
		num1.setNumero("00001");
    	num1.setVol(vol1);
    	num2.setCompagnie(klm);
    	num2.setNumero("10002");
    	num2.setVol(vol2);

    	// SETUP VOLS
    	vol1.setAeroportA(lax);
    	vol1.setAeroportD(cdg);
    	vol1.setDtArrivee(new Date(2018, 00, 01, 16, 00));
    	vol1.setDtDepart(new Date(2018, 00, 01, 12, 00));
    	vol1.setNbPlace(325);
    	vol1.setOuvert(false);
    	Escale[] escalesVol1Tableau = {escale11};
    	ArrayList<Escale> escalesVol1 = new ArrayList<>(Arrays.asList(escalesVol1Tableau));
    	vol1.setEscales(escalesVol1);    
    	Reservation[] reservationsVol1Tableau = {reservation1};
    	ArrayList<Reservation> reservationsVol1 = new ArrayList<>(Arrays.asList(reservationsVol1Tableau));
    	vol1.setReservations(reservationsVol1);
    	CompagnieAerienneVol[] cavVol1Tableau = {num1};
    	ArrayList<CompagnieAerienneVol> cavVol1 = new ArrayList<>(Arrays.asList(cavVol1Tableau));
    	vol1.setVols(cavVol1);
    
    	vol2.setAeroportA(cdg);
    	vol2.setAeroportD(jfk); 
    	vol2.setDtArrivee(new Date(2018, 00, 23, 20, 00));
    	vol2.setDtDepart(new Date(2018, 00, 23, 7, 00));
    	vol2.setNbPlace(429);
    	vol2.setOuvert(true);
    	Escale[] escalesVol2Tableau = {escale21,escale22};
    	ArrayList<Escale> escalesVol2 = new ArrayList<>(Arrays.asList(escalesVol2Tableau));
    	vol2.setEscales(escalesVol2);    
    	Reservation[] reservationsVol2Tableau = {reservation2};
    	ArrayList<Reservation> reservationsVol2 = new ArrayList<>(Arrays.asList(reservationsVol2Tableau));
    	vol2.setReservations(reservationsVol2);
    	CompagnieAerienneVol[] cavVol2Tableau = {num2};
    	ArrayList<CompagnieAerienneVol> cavVol2 = new ArrayList<>(Arrays.asList(cavVol2Tableau));
    	vol2.setVols(cavVol2);
    

    	// SETUP CA
    	easyJet.setNom("EasyJet");
        CompagnieAerienneVol[] volsEasyJetTableau = { num1 };
        ArrayList<CompagnieAerienneVol> volsEasyJet = new ArrayList<>(Arrays.asList( volsEasyJetTableau));
        easyJet.setVolsProposes(volsEasyJet);
        klm.setNom("KLM");
        CompagnieAerienneVol[] volsKLMTableau = { num2 };
        ArrayList<CompagnieAerienneVol> volsKLM = new ArrayList<>(Arrays.asList(volsKLMTableau));
        klm.setVolsProposes(volsKLM);
    
    	// SETUP Escale
    	escale11.setAeroport(jfk);
    	escale11.sethArrivee(new Date(2018,0,1,12,0));
    	escale11.sethDepart(new Date(2018,0,1,12,10));
    	escale11.setVol(vol1);
    
    	escale21.setAeroport(mam);
    	escale21.sethArrivee(new Date(2018,0,23,8,0));
    	escale21.sethDepart(new Date(2018,0,23,8,20));
    	escale21.setVol(vol2);
    
    	escale22.setAeroport(lnd);
    	escale22.sethArrivee(new Date(2018,0,23,18,0));
    	escale22.sethDepart(new Date(2018,0,23,18,15));
    	escale22.setVol(vol2);
		
		
		
		
//		InfosPassager(jeanMarc);
//		InfosPassager(jeanHugues);
		InfosReservation(reservation1);
		InfosReservation(reservation2);
		

	}
	
	
	
	static void InfosPassager(Passager personne) {
		Adresse adressePersonne = new Adresse();
		adressePersonne = personne.getAdresse();
		System.out.println(personne.getPrenom());
		System.out.println(personne.getNom());
		System.out.println(personne.getPI());
		System.out.println(personne.getDtnaissance());
		System.out.println(adressePersonne.getRue());
		System.out.println(adressePersonne.getVille());
		System.out.println(adressePersonne.getCodepostal());
		System.out.println(adressePersonne.getPays());
	}
	
	static void InfosReservation(Reservation resa) {
		
		System.out.println("Client : " + resa.getClient().getNom());
		System.out.println("Passager : "+ resa.getPassager().getNom());
		System.out.println("Code de r�servation : " + resa.getCode());
		System.out.println("Annul�e : " + resa.getAnnulee());
		System.out.println("Confirm�e : " + resa.getConfirmee());
		System.out.println("D�part de : " + resa.getVol().getAeroportD().getCode());
		System.out.println("Arriv�e � : " + resa.getVol().getAeroportA().getCode());
//		Escale[] escalesVol = vol.getEscales;
//		for (int i =0; i<escalesVol.length,i++) {
//			Escale escaleencours = escalesVol[i];
//			System.out.println(escaleencours.getAeroport.getCode);
		}
		
	
	
static void InfosVol(Vol vol ) {
    
    	System.out.println(vol.getAeroportA().getCode());
    	System.out.println(vol.getAeroportD().getCode());
    	System.out.println(vol.getDtArrivee());
    	System.out.println(vol.getDtDepart());
    	System.out.println(vol.getNbPlace());
    	System.out.println(vol.isOuvert());
    	System.out.println(vol.getEscales().get(0).getAeroport().getCode());
    	System.out.println(vol.getVols().get(0).getNumero());
	}
	

}
