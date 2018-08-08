package vol2.dao.SQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import Classes.Adresse;
import Classes.Civilite;
import Classes.Client;
import Classes.Particulier;
import Classes.Societe;
import application.Application;

import vol2.dao.IDaoClient;

public class DaoClientSQL implements IDaoClient {

	public List<Client> findAll() {
		List<Client> liste = new ArrayList<>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = Application.getInstance().createConnection();
			ps = conn.prepareStatement(
					"SELECT id, type, nom, siret, forme_juridique, prenom, civilite, rue, code_postal, ville , pays FROM client");

			rs = ps.executeQuery();

			while (rs.next()) {
				Long id = rs.getLong("id");
				String type = rs.getString("type");
				String nom = rs.getString("nom");
				String siret = rs.getString("siret");
				String forme_juridique = rs.getString("forme_juridique");
				String prenom = rs.getString("prenom");
				Civilite civilite = Civilite.valueOf(rs.getString("civilite"));
				String rue = rs.getString("rue");
				String code_postal = rs.getString("code_postal");
				String ville = rs.getString("ville");
				String pays = rs.getString("pays");

				Client obj = null;

				if (type.equals("Societe")) {
					obj = new Societe(id, nom, siret, forme_juridique);

				} else {
					obj = new Particulier(id, nom, prenom, civilite);
				}
				Adresse adr = new Adresse(rue, code_postal, ville, pays);

				obj.setAdresse(adr);

				liste.add(obj);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				ps.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return liste;
	}

	@Override
	public Client find(Long id) {

		Client obj = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			conn = Application.getInstance().createConnection();
			ps = conn.prepareStatement(
					"SELECT id, type, nom, siret, forme_juridique, prenom, civilite, rue, code_postal, ville , pays FROM client WHERE id = ?");

			ps.setLong(1, id);

			rs = ps.executeQuery();

			if (rs.next()) {
				String type = rs.getString("type");
				String nom = rs.getString("nom");
				String siret = rs.getString("siret");
				String forme_juridique = rs.getString("forme_juridique");
				String prenom = rs.getString("prenom");
				Civilite civilite = Civilite.valueOf(rs.getString("civilite"));
				String rue = rs.getString("rue");
				String code_postal = rs.getString("code_postal");
				String ville = rs.getString("ville");
				String pays = rs.getString("pays");

				if (type.equals("Societe")) {
					obj = new Societe(id, nom, siret, forme_juridique);

				} else {
					obj = new Particulier(id, nom, prenom, civilite);
				}
				Adresse adr = new Adresse(rue, code_postal, ville, pays);

				obj.setAdresse(adr);

			}

		} catch (Throwable e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				ps.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return obj;
	}

	@Override
	public void save(Client obj) {

		Connection conn = null;
		PreparedStatement ps = null;

		try {
			conn = Application.getInstance().createConnection();
			if (obj.getId() == null) {
				ps = conn.prepareStatement(
						"INSERT INTO client (id, type, nom, siret, forme_juridique, prenom, civilite, rue, code_postal, ville , pays) VALUES (nextval('client_seq'),?,?,?,?,?,?,?,?,?,?)",
						Statement.RETURN_GENERATED_KEYS);

				if (obj instanceof Societe) {
					ps.setString(1, "Société");
					ps.setString(2, obj.getNom());
					ps.setString(3, ((Societe) obj).getSiret());
					ps.setString(4, ((Societe) obj).getFormejuridique());

				} else if (obj instanceof Particulier) {
					ps.setString(1, "Particulier");
					ps.setString(2, obj.getNom());
					ps.setNull(3, Types.VARCHAR);
					ps.setNull(4, Types.VARCHAR);
					ps.setString(5, ((Particulier) obj).getPrenom());
					ps.setString(6, ((Particulier) obj).getCivilite().getLabel());

				}
				ps.setString(7, obj.getAdresse().getRue());
				ps.setString(8, obj.getAdresse().getCodepostal());
				ps.setString(9, obj.getAdresse().getVille());
				ps.setString(10, obj.getAdresse().getPays());

				int rows = ps.executeUpdate();

				if (rows > 0) {
					ResultSet rs = ps.getGeneratedKeys();

					if (rs.next()) {
						Long id = rs.getLong(1);
						obj.setId(id);
					}
				}
			} else {
				ps = conn.prepareStatement(
						"UPDATE client SET type = ?, nom = ?, siret = ?, forme_juridique= ?, prenom=?, civilite=?, rue= ?, code_postal=?, ville=? , pays = ? WHERE id = ?");
				
				if (obj instanceof Societe) {
					ps.setString(1, "Société");
					ps.setString(2, obj.getNom());
					ps.setString(3, ((Societe) obj).getSiret());
					ps.setString(4, ((Societe) obj).getFormejuridique());

				} else if (obj instanceof Particulier) {
					ps.setString(1, "Particulier");
					ps.setString(2, obj.getNom());
					ps.setNull(3, Types.VARCHAR);
					ps.setNull(4, Types.VARCHAR);
					ps.setString(5, ((Particulier) obj).getPrenom());
					ps.setString(6, ((Particulier) obj).getCivilite().getLabel());

				}

				ps.setString(7, obj.getAdresse().getRue());
				ps.setString(8, obj.getAdresse().getCodepostal());
				ps.setString(9, obj.getAdresse().getVille());
				ps.setString(10, obj.getAdresse().getPays());

				int rows = ps.executeUpdate();
			}
		} catch (

		SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void delete(Client obj) {
		deleteById(obj.getId());
	}

	@Override
	public void deleteById(Long id) {

		PreparedStatement ps = null;

		try (Connection conn = Application.getInstance().createConnection()) {
			ps = conn.prepareStatement("DELETE FROM client WHERE id = ?");

			ps.setLong(1, id);

			int rows = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
