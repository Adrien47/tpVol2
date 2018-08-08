package vol2.dao.test;

import java.util.List;

import Classes.Aeroport;
import Classes.Ville;
import vol2.dao.IDaoAeroport;
import vol2.dao.csv.DaoAeroportCSV;

public class TestAeroport {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		IDaoAeroport daoAeroport = new DaoAeroportCSV("aeroports.txt");
		
		List<Aeroport> aeroports = daoAeroport.findAll();
		
		for (Aeroport aeroport : aeroports) {
			System.out.println(aeroport.toString());
		}
		
		
		Aeroport aero1 = new Aeroport("555L");

		
		daoAeroport.save(aero1);
		
		aeroports = daoAeroport.findAll();

		for (Aeroport aeroport : aeroports) {
			System.out.println(aeroport.toString());
		}

		
		Aeroport agen = daoAeroport.find(4L);

	
		aero1.setCode("33200");
		
		
		daoAeroport.save(aero1);

	
		daoAeroport.deleteById(4L);

	}

}