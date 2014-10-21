package fr.up10.kdr.tdid;

import java.util.ArrayList;
import java.util.HashMap;

public class Mediateur {
	private HashMap <String, HashMap <String, ArrayList>> dictionnaire;
	
	public Mediateur(){
		dictionnaire = new HashMap <String, HashMap <String, ArrayList>>();
		dictionnaire.put("Etudiant", new HashMap());
		dictionnaire.put("Enseignant", new HashMap());
		dictionnaire.put("Cours", new HashMap());
		dictionnaire.put("Inscription", new HashMap());
		dictionnaire.put("Enseigne", new HashMap());
		
	//Renplissage de la table étudiant	
		
		dictionnaire.get("Etudiant").put("ID-Etudiant", new ArrayList<String>());
		dictionnaire.get("Etudiant").get("ID-Etudiant").add("S2");
		dictionnaire.get("Etudiant").get("ID-Etudiant").add("S3");
		
		dictionnaire.get("Etudiant").put("Nom", new ArrayList<String>());
		dictionnaire.get("Etudiant").get("Nom").add("S2");
		dictionnaire.get("Etudiant").get("Nom").add("S3");
		
		dictionnaire.get("Etudiant").put("Prenom", new ArrayList<String>());
		dictionnaire.get("Etudiant").get("Prenom").add("S2");
		
		
		dictionnaire.get("Etudiant").put("FormationPrecedente", new ArrayList<String>());
		dictionnaire.get("Etudiant").get("FormationPrecedente").add("S2");
		dictionnaire.get("Etudiant").get("FormationPrecedente").add("S3");
		
		dictionnaire.get("Etudiant").put("PaysFormationPrecedente", new ArrayList<String>());
		dictionnaire.get("Etudiant").get("PaysFormationPrecedente").add("S2");
		dictionnaire.get("Etudiant").get("PaysFormationPrecedente").add("S3");
		
		dictionnaire.get("Etudiant").put("AnneeDebut", new ArrayList<String>());
		dictionnaire.get("Etudiant").get("AnneeDebut").add("S2");
		dictionnaire.get("Etudiant").get("AnneeDebut").add("S3");
		
		dictionnaire.get("Etudiant").put("NiveauInsertion", new ArrayList<String>());
		dictionnaire.get("Etudiant").get("NiveauInsertion").add("S2");
		dictionnaire.get("Etudiant").get("NiveauInsertion").add("S3");
		
		dictionnaire.get("Etudiant").put("Age", new ArrayList<String>());
		dictionnaire.get("Etudiant").get("Age").add("S2");
		dictionnaire.get("Etudiant").get("Age").add("S3");
		
		
		//****************************************
		
		
		dictionnaire.get("Enseignant").put("ID-Enseignant", new ArrayList<String>());
		dictionnaire.get("Enseignant").get("ID-Enseignant").add("S2");
		dictionnaire.get("Enseignant").get("ID-Enseignant").add("S3");

		dictionnaire.get("Enseignant").put("Nom", new ArrayList<String>());
		dictionnaire.get("Enseignant").get("Nom").add("S2");
		dictionnaire.get("Enseignant").get("Nom").add("S3");
		
		dictionnaire.get("Enseignant").put("Prenom", new ArrayList<String>());
		dictionnaire.get("Enseignant").get("Prenom").add("S2");
		dictionnaire.get("Enseignant").get("Prenom").add("S3");
		
		dictionnaire.get("Enseignant").put("adresseMail", new ArrayList<String>());
		dictionnaire.get("Enseignant").get("adresseMail").add("S3");
		
		//***********************************************
		
		dictionnaire.get("Cours").put("ID-Cours", new ArrayList<String>());
		dictionnaire.get("Cours").get("ID-Cours").add("S2");
		dictionnaire.get("Cours").get("ID-Cours").add("S3");
		
	}
	
	public void NbHeureEnseignant(){
		HashMap lesEnseignantsHashMap = new HashMap ();
	}
	
	
}
