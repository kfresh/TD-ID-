package fr.up10.kdr.tdid;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

public class Excel {
	private Connection conn;

	public Excel() {
		super();
	}

	public void connexion() throws SQLException, ClassNotFoundException {

		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		} catch (ClassNotFoundException ex) {
			System.err.println("Erreur de chargement du driver.");
		}

		try {

			this.conn = DriverManager.getConnection("jdbc:odbc:Excel Files",
					"", "");
		} catch (SQLException ex) {
			System.err
					.println("Excel Erreur de connexion � la base de donn�es Excel");
		}
	}

	public void deconnexion() {
		try {
			this.conn.close();
		} catch (SQLException ex) {
			System.err
					.println("Excel Erreur de deconnexion � la base de donn�es.");
		}
	}

	public Integer nbEtuOrigFrance(Integer nb) {
		Statement requete = null;
		ResultSet resultat = null;
		HashMap<Integer, String> hsEtu = new HashMap<Integer, String>();

		try {

			connexion();
			requete = conn.createStatement();
			resultat = requete
					.executeQuery("Select * from [2006$] UNION Select * from [2007$]");

			while (resultat.next()) {
				String origine = resultat.getString(5);
				if (resultat.getString(4).contains("etudiant")
						&& (origine.contains("France"))) {

					hsEtu.put(Integer.valueOf(resultat.getInt(1)),
							resultat.getString(2));

				}

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println("Excel Erreur de deconnexion au SQL");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.err.println("Excel Erreur de deconnexion au fichier");
		}

		finally {
			deconnexion();
		}

		nb = Integer.valueOf(nb.intValue() + hsEtu.size());
		return nb;

	}

	public void nbCoursPType(HashMap<String, ArrayList> hs) {
		Statement requete = null;
		ResultSet resultat = null;
		/*
		 * HashMap<Integer, String> hsCM = new HashMap<Integer, String>();
		 * HashMap<Integer, String> hsTP = new HashMap<Integer, String>();
		 * HashMap<Integer, String> hsTD = new HashMap<Integer, String>();
		 */

		try {

			connexion();
			requete = conn.createStatement();
			resultat = requete
					.executeQuery("Select * from [2006$] UNION Select * from [2007$]");
			while (resultat.next()) {
				String type = resultat.getString(10);
				String id = String.valueOf(resultat.getInt(8));
				if (type.contains("CM")) {

					if (hs.containsKey(id)) {
						if (!hs.get(id).contains("CM")) {
							hs.get(id).add("CM");
						}
					} else {
							hs.put(id, new ArrayList());
					}
				}

				if (type.contains("TP")) {

					if (hs.containsKey(id)) {
						if (!hs.get(id).contains("TP")) {
							hs.get(id).add("TP");
						}
					}
					else {
						hs.put(id, new ArrayList());
						hs.get(id).add("TP");
					}
				}
				if (type.contains("TD")) {

					if (hs.containsKey(id)) {
						if (!hs.get(id).contains("TD")) {
							hs.get(id).add("TP");
						}
					}
					else {
						hs.put(id, new ArrayList());
						hs.get(id).add("TD");
					}
					}
				}

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println("Excel Erreur de deconnexion SQL (Excel)");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.err.println("Excel Erreur de deconnexion au fichier");
		} finally {
			deconnexion();
		}
		System.out.println(hs.size());
		/*
		 * Integer nbCM = Integer.valueOf(hsCM.size()); Integer nbTD =
		 * Integer.valueOf(hsTD.size()); Integer nbTP =
		 * Integer.valueOf(hsTP.size());
		 * 
		 * hs.put("CM", nbCM); hs.put("TD", nbTD); hs.put("TP", nbTP);
		 */
	}
}