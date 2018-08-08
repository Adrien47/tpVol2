package vol2.dao.csv;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import Classes.Aeroport;
import Classes.Ville;

import vol2.dao.IDaoAeroport;

public class DaoAeroportCSV implements IDaoAeroport {

	private final String chemin;

	public DaoAeroportCSV(String chemin) {
		super();
		this.chemin = chemin;
	}

	@Override
	public List<Aeroport> findAll() {
		// TODO Auto-generated method stub
		return read();
	}

	@Override
	public Aeroport find(Long id) {
		for (Aeroport aeroport : read()) {
			if (aeroport.getId().equals(id)) {
				return aeroport;
			}
		}

		return null;
	}

	@Override
	public void save(Aeroport obj) {

		List<Aeroport> liste = read();

		if (obj.getId() == null) {

			Long max = 0L;
			for (Aeroport aeroport : liste) {
				if (max < aeroport.getId()) {
					max = aeroport.getId();
				}
			}

			obj.setId(++max);

			liste.add(obj);
		} else {

			int idx;

			for (idx = 0; idx < liste.size(); idx++) {
				if (liste.get(idx).getId() == obj.getId()) {

					break;
				}
			}

			liste.set(idx, obj);
		}

		write(liste);

	}

	@Override
	public void delete(Aeroport obj) {
		deleteById(obj.getId());
	}

	@Override
	public void deleteById(Long id) {

		List<Aeroport> liste = read();

		int idx;

		for (idx = 0; idx < liste.size(); idx++) {
			if (liste.get(idx).getId() == id) {
				break;
			}
		}

		liste.remove(idx);

		write(liste);
	}

	private List<Aeroport> read() {

		List<Aeroport> liste = new ArrayList<>();
		try {
			// 6. lecture de toutes les lignes du fichier cible
			List<String> lines = Files.readAllLines(Paths.get(chemin));

			// 7. boucle sur l'ensemble des lignes
			for (String line : lines) {
				// 8. transformation de la ligne en objet et ajout à la liste
				String[] items = line.split(";");
				Long id = Long.valueOf(items[0]);
				String code = items[1];

				Aeroport obj = new Aeroport(id, code);
				liste.add(obj);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return liste;
	}

	private void write(List<Aeroport> liste) {
		StringBuilder sb = new StringBuilder();
		for (Aeroport obj : liste) {
			sb.append(obj.getId());
			sb.append(";");
			sb.append(obj.getCode());
			sb.append("\n");
		}

		String lines = sb.toString();
		FileWriter fw = null;
		BufferedWriter bw = null;
		try {
			fw = new FileWriter(chemin);
			bw = new BufferedWriter(fw);
			bw.write(lines);

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
