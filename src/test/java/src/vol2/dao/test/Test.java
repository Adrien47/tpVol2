package vol2.dao.test;

import java.util.List;

import Classes.Adresse;
import Classes.Civilite;
import Classes.Client;
import Classes.Particulier;
import vol2.dao.IDaoClient;
import vol2.dao.SQL.DaoClientSQL;

public class Test {

	public static void main(String[] args) {

		IDaoClient daoClient = new DaoClientSQL();

		List<Client> clients = daoClient.findAll();

		for (Client client : clients) {
			System.out.println(client.toString());
		}

		Particulier jeanBon = new Particulier("Bon", "Jean", Civilite.M);
		Adresse adr = new Adresse("12", "333333", "Bowdeaux", "Wankanda");
		jeanBon.setAdresse(adr);
		// Societe chorizo = new Societe ("ChoRiZo", "12121ABA", "SARL");

		daoClient.save(jeanBon);

		clients = daoClient.findAll();

		for (Client client : clients) {
			System.out.println(client.toString());
		}

		Client agen = daoClient.find(4L);

		jeanBon.setPrenom("Juan");
		jeanBon.setNom("Bono");

		daoClient.save(jeanBon);

		daoClient.deleteById(4L);

	}

}
