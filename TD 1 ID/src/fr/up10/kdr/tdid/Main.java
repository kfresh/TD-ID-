package fr.up10.kdr.tdid;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

public class Main {

	public static void main(String[] args) throws FileNotFoundException, SAXException, IOException, ParserConfigurationException {
		// TODO Auto-generated method stub
		Mediateur monMediateur = new Mediateur();
		
			monMediateur.NbHeureEnseignant();
			monMediateur.nbEtuOrigFrance();
		
	}

}
