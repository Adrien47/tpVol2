package vol2.dao.csv;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

import Classes.Ville;

import vol2.dao.IDaoVille;

public class DaoVilleCSV implements IDaoVille {

	private final String chemin;

	// 2. réception du chemin du fichier de stockage
	public DaoVilleCSV(String chemin) {
		super();
		this.chemin = chemin;
	}

	@Override
	public List<Ville> findAll() {
		// 4. appel de la méthode interne de lecture sur fichier
		return read();
	}

	@Override
	public Ville find(Long id) {
		for (Ville ville : read()) {
			if (ville.getId() ==id) {
				return ville;
			}
		}

		return null;
	}

	@Override
	public void save(Ville obj) {
		// 11. chargement du contenu du fichier en mémoire
		List<Ville> liste = read();

		// 12. test si objet en mode ajout 
		if (obj.getId() == null) {
			// 12b. recherche de l'identifiant maximum
			Long max = 0L;
			for(Ville ville : liste) {
				if(max < ville.getId()) {
					max = ville.getId();
				}
			}
			
			obj.setId(++max);
			
			liste.add(obj);
		} else {
			// 15. test si objet en mode modification
			int idx;
			// 16. recherche de la position de l'élève à modifier dans la liste
			for (idx = 0; idx < liste.size(); idx++) {
				if (liste.get(idx).getId() == obj.getId()) {
					// 17. dès que la ligne est trouvée on force une sortie de la boucle 
					// en gardant l'indice (idx) stocké
					break;
				}
			}
			
			// 18. écrasement de la ligne (idx) par le nouvel objet
			liste.set(idx, obj);
		}
		
		// 13. écrasement de l'ensemble du fichier avec les données en mémoire modifiées
		write(liste);
	}

	@Override
	public void delete(Ville obj) {
		deleteById(obj.getId());
	}

	@Override
	public void deleteById(Long id) {
		// 20. chargement du contenu du fichier en mémoire
		List<Ville> liste = read();
		
		int idx;
		// 21. recherche de la position de l'élève à supprimer dans la liste
		for (idx = 0; idx < liste.size(); idx++) {
			if (liste.get(idx).getId()==id) {
				break;
			}
		}
		
		// 22. suppression de l'objet suivant son indice (idx)
		liste.remove(idx);
		
		// 23. écrasement de l'ensemble du fichier avec les données en mémoire modifiées
		write(liste);
	}

	private List<Ville> read() {
		// 5. instanciation d'une liste vierge
		List<Ville> liste = new ArrayList<>();
		try {
			// 6. lecture de toutes les lignes du fichier cible
			List<String> lines = Files.readAllLines(Paths.get(chemin));

			// 7. boucle sur l'ensemble des lignes
			for (String line : lines) {
				// 8. transformation de la ligne en objet et ajout à la liste
				String[] items = line.split(";");
				Long id = Long.valueOf(items[0]);
				String nom = items[1];
				String codePostal = items[2];
				String pays = items[3];

				Ville obj = new Ville(id, nom, codePostal, pays);
				liste.add(obj);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return liste;
	}

	private void write(List<Ville> liste) {
		StringBuilder sb = new StringBuilder();
		for(Ville obj : liste) {
			sb.append(obj.getId());
			sb.append(";");
			sb.append(obj.getNom());
			sb.append(";");
			sb.append(obj.getCodePostal());
			sb.append(";");
			sb.append(obj.getPays());
			sb.append("\n");
		}
		
		String lines = sb.toString();
		FileWriter fw = null;
		BufferedWriter bw= null;
		try {
			fw = new FileWriter(chemin);
			bw = new BufferedWriter(fw);
			bw.write(lines);
//			Files.write(Paths.get(chemin), lines.getBytes(), StandardOpenOption.CREATE);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bw.close();
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}



}
