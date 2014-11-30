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
        }catch (NullPointerException ex) 
        {
            System.err.println("Connexion non existante.");
        }    
    }


	public void nbEtuOrigFrance(ArrayList <String> listEtu) {
		Statement requete = null;
		ResultSet resultat = null;
		
		try {
			connexion();
			requete = conn.createStatement();
			
			//à modifier avec adaptateur
			
			resultat = requete.executeQuery("SELECT ID_ETUDIANT FROM ETUDIANT WHERE PROVENANCE='fr'");
			while (resultat.next()) {
				int id = resultat.getInt("ID_ETUDIANT");
				if (!listEtu.contains(id)) listEtu.add(String.valueOf(id));
			}
	
			
			deconnexion();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println("Excel Erreur de deconnexion au SQL");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.err.println("Excel Erreur de deconnexion au fichier");
		}catch (NullPointerException e) {
			// TODO Auto-generated catch block
			System.err.println("Valeur Nulle");
		}
		
	
		
		//nb = Integer.valueOf(nb.intValue() + listIdEtudiant.size());
		
	
		
		
	}

	public void nbCoursPType(HashMap<String, ArrayList> hs) {
		// TODO Auto-generated method stub
		
		Statement requete = null;
		ResultSet resultat = null;
		
		
		
		
		try {
			connexion();
			requete = conn.createStatement();
			
			//à modifier avec adaptateur
			
			resultat = requete.executeQuery("SELECT * FROM COURS");
			while (resultat.next()) {
				String str = resultat.getString("TYPE");
				String id = String.valueOf(resultat.getInt("NumCours"));
				if (str.contains("CM")) {
					if (hs.containsKey(id)) {
						if (!hs.get(id).contains("CM")) {
							hs.get(id).add("CM");
						}
					} else {
							hs.put(id, new ArrayList());
					}
					
					//nbCM = new Integer(nbCM.intValue() + 1);
				}
				else if (str.contains("TD")){
					
					if (hs.containsKey(id)) {
						if (!hs.get(id).contains("TP")) {
							hs.get(id).add("TP");
						}
					}
					else {
						hs.put(id, new ArrayList());
						hs.get(id).add("TP");
					}
					//nbTD = new Integer(nbTD.intValue() + 1);
				}
				else if (str.contains("TP")){
					
					if (hs.containsKey(id)) {
						if (!hs.get(id).contains("TP")) {
							hs.get(id).add("TP");
						}
					}
					else {
						hs.put(id, new ArrayList());
						hs.get(id).add("TP");
					}
					//nbTP = new Integer(nbTP.intValue() + 1);
				}
			}
			deconnexion();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (NullPointerException e) {
			// TODO Auto-generated catch block
			System.err.println("Valeur Nulle");
		}
		
		
		
	}
}
