package vol2.dao;

import vol2.dao.SQL.DaoClientSQL;


public class DaoFactory {
	private static IDaoClient daoClient = null;
//	private static IDaoParticulier daoParticulier = null;
//	private static IDaoSociete daoSociete = null;
	

	public static IDaoClient getDaoClient() {
		if (daoClient == null) {
			daoClient = new DaoClientSQL();
		}

		return daoClient;
	}

//	public static IDaoParticulier getDaoParticulier() {
//		if (daoParticulier == null) {
//			daoParticulier = new DaoParticulierSQL();
//		}
//
//		return daoParticulier;
//	}
//
//	public static IDaoSociete getDaoSociete() {
//		if (daoSociete == null) {
//			daoSociete = new DaoSocieteSQL();
//		}
//
//		return daoSociete;
//	}
	

}
