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
					.println("Excel Erreur de connexion à la base de données.");
		}
	}

	public void deconnexion() {
		try {
			this.conn.close();
		} catch (SQLException ex) {
			System.err
					.println("Excel Erreur de deconnexion à la base de données.");
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
				if (resultat.getString(4).contains("etudiant")
						&& resultat.getString(5).contains("France")) {
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
		
		nb = Integer.valueOf(nb.intValue() + hsEtu.size());
		return nb;
		
	}
	
	public void nbCoursPType(HashMap<String, Integer> hs) {
		Statement requete = null;
		ResultSet resultat = null;
		HashMap<Integer, String> hsCM = new HashMap<Integer, String>();
		HashMap<Integer, String> hsTP = new HashMap<Integer, String>();
		HashMap<Integer, String> hsTD = new HashMap<Integer, String>();




		try {

			connexion();
			requete = conn.createStatement();
			resultat = requete
					.executeQuery("Select * from [2006$] UNION Select * from [2007$]");
			while (resultat.next()) {
				if (resultat.getString(10).contains("CM")) {
					hsCM.put(Integer.valueOf(resultat.getInt(8)),
							resultat.getString(9));
				}
				if (resultat.getString(10).contains("TP")){
					hsTP.put(Integer.valueOf(resultat.getInt(8)),
							resultat.getString(9));
				}
				if (resultat.getString(10).contains("TD")){
					hsTD.put(Integer.valueOf(resultat.getInt(8)),
							resultat.getString(9));
				}

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println("Excel Erreur de deconnexion au SQL");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.err.println("Excel Erreur de deconnexion au fichier");
		}
		
		Integer nbCM = Integer.valueOf(hsCM.size());
		Integer nbTD = Integer.valueOf(hsTD.size());
		Integer nbTP = Integer.valueOf(hsTP.size());
		
		hs.put("CM", nbCM);
		hs.put("TD", nbTD);
		hs.put("TP", nbTP);
	}
}