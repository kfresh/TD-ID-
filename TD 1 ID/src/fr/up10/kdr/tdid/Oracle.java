package fr.up10.kdr.tdid;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;


public class Oracle 
{
    private Connection conn;
    
    public Oracle()
    {
        super();
    }
    
    public void connexion() throws SQLException, ClassNotFoundException
    {
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        }
        catch (ClassNotFoundException ex) 
        {
            System.err.println("Erreur de chargement du driver.");
        }
        
        try 
        {
            this.conn = DriverManager.getConnection("jdbc:oracle:thin:@miage03.dmiage.u-paris10.fr:1521:miage", "absaidso", "apprentis2012pw");
//"jdbc:oracle:thin:@172.19.255.3:1521:MIAGE"

        }
        catch (SQLException ex) 
        {
            System.err.println("Erreur de connexion à la base de données Oracle.");
        }  
    }
    
    private void deconnexion()
    {
        try
        {
            this.conn.close();      
        }
        catch (SQLException ex) 
        {
            System.err.println("Erreur de deconnexion à la base de données.");
        }    
    }


	public Integer nbEtuOrigFrance(Integer nb) {
		Statement requete = null;
		ResultSet resultat = null;
		ArrayList<Integer> listIdEtudiant = new ArrayList<Integer>();
		
		try {
			connexion();
			requete = conn.createStatement();
			
			//à modifier avec adaptateur
			
			resultat = requete.executeQuery("SELECT ID_ETUDIANT FROM ETUDIANT WHERE PROVENANCE='fr'");
			while (resultat.next()) {
				listIdEtudiant.add(resultat.getInt("ID_ETUDIANT"));
			}
	
			nb = Integer.valueOf(nb.intValue() + listIdEtudiant.size());
			
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
	
		
		//nb = Integer.valueOf(nb.intValue() + listIdEtudiant.size());
		
		return nb;
		
		
	}

	public void nbCoursPType(HashMap<String, Integer> hs) {
		// TODO Auto-generated method stub
		
		Statement requete = null;
		ResultSet resultat = null;
		
		
		Integer nbCM = hs.get("CM");
		Integer nbTD = hs.get("TD");
		Integer nbTP = hs.get("TP");
		
		try {
			connexion();
			requete = conn.createStatement();
			
			//à modifier avec adaptateur
			
			resultat = requete.executeQuery("SELECT * FROM COURS");
			while (resultat.next()) {
				String str = resultat.getString("TYPE");
				if (str.contains("CM")) {
					nbCM = new Integer(nbCM.intValue() + 1);
				}
				else if (str.contains("TD")){
					nbTD = new Integer(nbTD.intValue() + 1);
				}
				else if (str.contains("TP")){
					nbTP = new Integer(nbTP.intValue() + 1);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			deconnexion();
		}
		hs.put("CM", nbCM);
		hs.put("TD", nbTD);
		hs.put("TP", nbTP);
		
		
	}
}
