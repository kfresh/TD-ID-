package fr.up10.kdr.tdid;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

public class Main {

	public static void main(String[] args) throws FileNotFoundException, SAXException, IOException, ParserConfigurationException {
		// TODO Auto-generated method stub
		
		Excel monExcel =new Excel();
		Oracle monOracle = new Oracle();

		try {
			monExcel.connexion();
			monExcel.nbEtuOrigFrance();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
		Mediateur monMediateur = new Mediateur();
		
			monMediateur.NbHeureEnseignant();
			monMediateur.nbEtuOrigFrance();
			monMediateur.nbCourspType();
		
	}

}
