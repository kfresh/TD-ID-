package fr.up10.kdr.tdid;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

public class Mediateur {
	private HashMap<String, HashMap<String, ArrayList>> dictionnaire;
	private XML monXML;
	private Oracle monOracle;
	private Excel monExcel;

	// S1 = source excel
	// S2 = source oracle
	// S3 = source xml

	public Mediateur() {
		monXML = new XML();
		monOracle = new Oracle();
		monExcel = new Excel();

		dictionnaire = new HashMap<String, HashMap<String, ArrayList>>();

		dictionnaire.put("Etudiant", new HashMap <String, ArrayList>());
		dictionnaire.put("Enseignant", new HashMap());
		dictionnaire.put("Cours", new HashMap());
		dictionnaire.put("Inscription", new HashMap());
		dictionnaire.put("Enseigne", new HashMap());

		// Renplissage de la table �tudiant

		dictionnaire.get("Etudiant")
				.put("ID-Etudiant", new ArrayList<String>());
		dictionnaire.get("Etudiant").get("ID-Etudiant").add("S1");
		dictionnaire.get("Etudiant").get("ID-Etudiant").add("S2");
		dictionnaire.get("Etudiant").get("ID-Etudiant").add("S3");

		dictionnaire.get("Etudiant").put("Nom", new ArrayList<String>());
		dictionnaire.get("Etudiant").get("Nom").add("S1");
		dictionnaire.get("Etudiant").get("Nom").add("S2");
		dictionnaire.get("Etudiant").get("Nom").add("S3");

		dictionnaire.get("Etudiant").put("Prenom", new ArrayList<String>());
		dictionnaire.get("Etudiant").get("Prenom").add("S1");
		dictionnaire.get("Etudiant").get("Prenom").add("S2");

		dictionnaire.get("Etudiant").put("FormationPrecedente",
				new ArrayList<String>());

		dictionnaire.get("Etudiant").get("FormationPrecedente").add("S1");
		dictionnaire.get("Etudiant").get("FormationPrecedente").add("S2");
		dictionnaire.get("Etudiant").get("FormationPrecedente").add("S3");

		dictionnaire.get("Etudiant").put("PaysFormationPrecedente",
				new ArrayList<String>());
		// dictionnaire.get("Etudiant").get("PaysFormationPrecedente").add("S1");
		dictionnaire.get("Etudiant").get("PaysFormationPrecedente").add("S2");
		dictionnaire.get("Etudiant").get("PaysFormationPrecedente").add("S3");

		dictionnaire.get("Etudiant").put("AnneeDebut", new ArrayList<String>());
		dictionnaire.get("Etudiant").get("AnneeDebut").add("S2");
		dictionnaire.get("Etudiant").get("AnneeDebut").add("S3");

		dictionnaire.get("Etudiant").put("NiveauInsertion",
				new ArrayList<String>());
		dictionnaire.get("Etudiant").get("NiveauInsertion").add("S1");
		dictionnaire.get("Etudiant").get("NiveauInsertion").add("S2");
		dictionnaire.get("Etudiant").get("NiveauInsertion").add("S3");

		dictionnaire.get("Etudiant").put("Provenance", new ArrayList<String>());
		dictionnaire.get("Etudiant").get("Provenance").add("S1");
		dictionnaire.get("Etudiant").get("Provenance").add("S2");
		dictionnaire.get("Etudiant").get("Provenance").add("S3");

		dictionnaire.get("Etudiant").put("Age", new ArrayList<String>());
		dictionnaire.get("Etudiant").get("Age").add("S2");
		dictionnaire.get("Etudiant").get("Age").add("S3");

		// ****************************************

		dictionnaire.get("Enseignant").put("ID-Enseignant",
				new ArrayList<String>());
		dictionnaire.get("Enseignant").get("ID-Enseignant").add("S1");
		dictionnaire.get("Enseignant").get("ID-Enseignant").add("S2");
		dictionnaire.get("Enseignant").get("ID-Enseignant").add("S3");

		dictionnaire.get("Enseignant").put("Nom", new ArrayList<String>());
		dictionnaire.get("Enseignant").get("Nom").add("S1");
		dictionnaire.get("Enseignant").get("Nom").add("S2");
		dictionnaire.get("Enseignant").get("Nom").add("S3");

		dictionnaire.get("Enseignant").put("Prenom", new ArrayList<String>());
		dictionnaire.get("Enseignant").get("Prenom").add("S1");
		dictionnaire.get("Enseignant").get("Prenom").add("S2");
		dictionnaire.get("Enseignant").get("Prenom").add("S3");

		dictionnaire.get("Enseignant").put("adresseMail",
				new ArrayList<String>());
		dictionnaire.get("Enseignant").get("adresseMail").add("S3");

		// ***********************************************

		dictionnaire.get("Cours").put("ID-Cours", new ArrayList<String>());
		dictionnaire.get("Cours").get("ID-Cours").add("S1");
		dictionnaire.get("Cours").get("ID-Cours").add("S2");
		dictionnaire.get("Cours").get("ID-Cours").add("S3");

		dictionnaire.get("Cours").put("Libele", new ArrayList<String>());
		dictionnaire.get("Cours").get("Libele").add("S1");
		dictionnaire.get("Cours").get("Libele").add("S2");

		dictionnaire.get("Cours").put("Type", new ArrayList<String>());
		dictionnaire.get("Cours").get("Type").add("S1");
		dictionnaire.get("Cours").get("Type").add("S2");
		dictionnaire.get("Cours").get("Type").add("S3");

		dictionnaire.get("Cours").put("Niveau", new ArrayList<String>());
		dictionnaire.get("Cours").get("Niveau").add("S1");
		dictionnaire.get("Cours").get("Niveau").add("S2");
		dictionnaire.get("Cours").get("Niveau").add("S3");

		dictionnaire.get("Cours").put("Heures", new ArrayList<String>());
		dictionnaire.get("Cours").get("Heures").add("S3");

		// ************************************************

		dictionnaire.get("Inscription").put("ID-Etudiant",
				new ArrayList<String>());
		dictionnaire.get("Inscription").get("ID-Etudiant").add("S1");
		dictionnaire.get("Inscription").get("ID-Etudiant").add("S2");
		dictionnaire.get("Inscription").get("ID-Etudiant").add("S3");

		dictionnaire.get("Inscription")
				.put("ID-Cours", new ArrayList<String>());

		dictionnaire.get("Inscription").get("ID-Cours").add("S1");
		dictionnaire.get("Inscription").get("ID-Cours").add("S2");
		dictionnaire.get("Inscription").get("ID-Cours").add("S3");

		dictionnaire.get("Inscription").put("Annee", new ArrayList<String>());
		dictionnaire.get("Inscription").get("Annee").add("S1");
		dictionnaire.get("Inscription").get("Annee").add("S2");
		dictionnaire.get("Inscription").get("Annee").add("S3");

		dictionnaire.get("Inscription").put("Note", new ArrayList<String>());
		dictionnaire.get("Inscription").get("Note").add("S1");
		dictionnaire.get("Inscription").get("Note").add("S2");
		dictionnaire.get("Inscription").get("Note").add("S3");

		// **************************************************
		dictionnaire.get("Enseigne").put("ID-Enseignant",
				new ArrayList<String>());
		dictionnaire.get("Enseigne").get("ID-Enseignant").add("S2");
		dictionnaire.get("Enseigne").get("ID-Enseignant").add("S3");

		dictionnaire.get("Enseigne").put("ID-Cours", new ArrayList<String>());
		dictionnaire.get("Enseigne").get("ID-Cours").add("S2");
		dictionnaire.get("Enseigne").get("ID-Cours").add("S3");

		dictionnaire.get("Enseigne").put("Annee", new ArrayList<String>());
		dictionnaire.get("Enseigne").get("Annee").add("S2");
		dictionnaire.get("Enseigne").get("Annee").add("S3");

		dictionnaire.get("Enseigne").put("Heures", new ArrayList<String>());
		dictionnaire.get("Enseigne").get("Heures").add("S3");

	}

	public void NbHeureEnseignant() throws FileNotFoundException, SAXException,
			IOException, ParserConfigurationException {
		HashMap<Integer, Integer> nbHeureEnsHs = new HashMap<Integer, Integer>();

		if (dictionnaire.get("Enseigne").get("Heures").contains("S1")) {
			// La source Excel ne contient pas cette donn�e pour le moment

		}

		if (dictionnaire.get("Enseigne").get("Heures").contains("S2")) {
			// La source Oracle ne contient pas cette donn�e pour le moment

		}
		if (dictionnaire.get("Enseigne").get("Heures").contains("S3")) {
			monXML.nbHeuresEnseignant("Univ_BD_3.xml", nbHeureEnsHs);
		}

		nbHeureEnsHs.size();

		Iterator it = nbHeureEnsHs.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry ent = (Map.Entry) it.next();

			System.out.println("L'enseignant n�" + ent.getKey().toString()
					+ " a " + ent.getValue() + " heures");

		}

	}

	public void nbEtuOrigFrance() throws FileNotFoundException, SAXException,
			IOException, ParserConfigurationException {
		Integer nb = Integer.valueOf(0);
		ArrayList etuOrigFr = new ArrayList();
		
		
		if (dictionnaire.get("Etudiant").get("Provenance").contains("S1")) {
			monExcel.nbEtuOrigFrance(etuOrigFr);

		}

		if (dictionnaire.get("Etudiant").get("Provenance").contains("S2")) {
			monOracle.nbEtuOrigFrance(etuOrigFr);

		}

		if (dictionnaire.get("Etudiant").get("Provenance").contains("S3")) {
			monXML.nbEtuOrigFrance("Univ_BD_3.xml", etuOrigFr);
		}

		System.out.println("il y a " + etuOrigFr.size()
				+ " �tudiants provenant de France");

	}

	public void nbCourspType() throws FileNotFoundException, SAXException,
			IOException, ParserConfigurationException {
		HashMap<String, ArrayList> hs = new HashMap<String, ArrayList>();



		if (dictionnaire.get("Cours").get("Type").contains("S1")) {
			monExcel.nbCoursPType(hs);

		}
		if (dictionnaire.get("Cours").get("Type").contains("S2")) {
			monOracle.nbCoursPType(hs);

		}
		if (dictionnaire.get("Cours").get("Type").contains("S3")) {
			monXML.nbCoursPType("Univ_BD_3.xml", hs);

		}
		
		int nbCM = 0;
		int nbTP = 0;
		int nbTD = 0;
		
		for (String mapKey : hs.keySet()) {
			
			if (hs.get(mapKey).contains("CM"))
				nbCM++;
			if (hs.get(mapKey).contains("TD"))
				nbTD++;
			if (hs.get(mapKey).contains("TP"))
				nbTP++;

		}

		System.out.println(nbCM + " Cours Magistraux");
		System.out.println(nbTD + " Travaux Dirig�s");
		System.out.println(nbTP + " Travaux pratiques");
		
		
		/*System.out.println(hs.get("CM").toString() + " Cours Magistaux");
		System.out.println(hs.get("TD").toString() + " Travaux dirig�s");
		System.out.println(hs.get("TP").toString() + " Travaux pratiques");*/

	}

}
