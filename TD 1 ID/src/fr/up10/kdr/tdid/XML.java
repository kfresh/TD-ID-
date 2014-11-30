package fr.up10.kdr.tdid;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XML {

	public void lire_XML(String path_fichier) throws FileNotFoundException,
			SAXException, IOException, ParserConfigurationException {

		DocumentBuilderFactory builderFactory = DocumentBuilderFactory
				.newInstance();
		org.w3c.dom.Document doc = builderFactory.newDocumentBuilder().parse(
				new FileInputStream(path_fichier));
		Node node;
		Element E, E_1;

		// liste des etudiants
		NodeList etudiants = ((org.w3c.dom.Document) doc)
				.getElementsByTagName("Etudiant");
		NodeList L;

		for (int index = 0; index < etudiants.getLength(); index++) {
			// un etudiant
			E = (Element) etudiants.item(index);

			L = E.getElementsByTagName("NumEt");
			E_1 = (Element) L.item(0); // un seul noeud NumEt
			System.out.println("num etudiant " + E_1.getTextContent());

			L = E.getElementsByTagName("nom");
			E_1 = (Element) L.item(0);
			System.out.println("num etudiant " + E_1.getTextContent());
		}
	}

	public HashMap<Integer, Integer> nbHeuresEnseignant(String path_fichier,
			HashMap<Integer, Integer> hs) throws FileNotFoundException,
			SAXException, IOException, ParserConfigurationException {
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory
				.newInstance();
		org.w3c.dom.Document doc = builderFactory.newDocumentBuilder().parse(
				new FileInputStream(path_fichier));
		// Node node ;
		Element E, E_1;

		// liste des enseignants
		NodeList enseignants = ((org.w3c.dom.Document) doc)
				.getElementsByTagName("Enseigne");
		NodeList L;

		for (int index = 0; index < enseignants.getLength(); index++) {

			E = (Element) enseignants.item(index);

			L = E.getElementsByTagName("NumEns");
			E_1 = (Element) L.item(0); // un seul noeud NumEt
			Integer NumEns = Integer.parseInt(E_1.getTextContent());

			L = E.getElementsByTagName("Nb_heures");
			E_1 = (Element) L.item(0);
			Integer NbHeure = Integer.parseInt(E_1.getTextContent());

			Integer nb = hs.get(NumEns);
			if (nb == null) {
				hs.put(NumEns, NbHeure);
			} else {
				nb += NbHeure;
				hs.put(NumEns, nb);
			}

		}

		return hs;

	}

	public void nbEtuOrigFrance(String path_fichier, ArrayList listEtu)
			throws FileNotFoundException, SAXException, IOException,
			ParserConfigurationException {
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory
				.newInstance();
		org.w3c.dom.Document doc = builderFactory.newDocumentBuilder().parse(
				new FileInputStream(path_fichier));

		Element E, E_1;
		
		// liste des enseignants
		NodeList etudiants = ((org.w3c.dom.Document) doc)
				.getElementsByTagName("Etudiant");
		NodeList L;

		for (int index = 0; index < etudiants.getLength(); index++) {

			E = (Element) etudiants.item(index);

			L = E.getElementsByTagName("Provenance");
			E_1 = (Element) L.item(0);

			

			if (E_1.getTextContent().contains("France")) {
				L = E.getElementsByTagName("NumEt");
				E_1 = (Element) L.item(0);
				listEtu.add(E_1.getTextContent());
			}

		}


	}

	public void nbCoursPType(String path_fichier,
			HashMap<String, ArrayList> hs) throws FileNotFoundException,
			SAXException, IOException, ParserConfigurationException {
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory
				.newInstance();
		org.w3c.dom.Document doc = builderFactory.newDocumentBuilder().parse(
				new FileInputStream(path_fichier));

		Element E, E_1,E_2;

		// liste des enseignants
		NodeList etudiants = ((org.w3c.dom.Document) doc)
				.getElementsByTagName("Cours");
		NodeList L;
		/*Integer nbCM = hs.get("CM");
		Integer nbTD = hs.get("TD");
		Integer nbTP = hs.get("TP");*/
		
		
		
		
		

		for (int index = 0; index < etudiants.getLength(); index++) {
			E = (Element) etudiants.item(index);

			L = E.getElementsByTagName("Type");
			E_1 = (Element) L.item(0);
			
			L = E.getElementsByTagName("ID_cours");
			E_2 = (Element) L.item(0); // un seul noeud NumEt
			String id = E_2.getTextContent();
			
			if (E_2.getTextContent().contains("Cours Magistral")) {
				if (hs.containsKey(id)) {
					if (!hs.get(id).contains("CM")) {
						hs.get(id).add("CM");
					}
				} else {
						hs.put(id, new ArrayList());
				}
				
				//nbCM = new Integer(nbCM.intValue() + 1);
			}
			else if (E_1.getTextContent().contains("Travaux diriges")){
				if (hs.containsKey(id)) {
					if (!hs.get(id).contains("TD")) {
						hs.get(id).add("TD");
					}
				} else {
						hs.put(id, new ArrayList());
				}
				
				//nbTD = new Integer(nbTD.intValue() + 1);
			}
			else if (E_1.getTextContent().contains("Travaux pratiques")){
				if (hs.containsKey(id)) {
					if (!hs.get(id).contains("TP")) {
						hs.get(id).add("TP");
					}
				} else {
						hs.put(id, new ArrayList());
				}
				
				
			}

		}


	}

}
