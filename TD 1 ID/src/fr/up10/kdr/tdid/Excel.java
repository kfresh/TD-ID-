package fr.up10.kdr.tdid;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class Excel {
    private Connection conn;
    
    public Excel()
    {
        super();
    }
    
    public void connexion() throws SQLException, ClassNotFoundException
    {
    	

        try
        {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        }
        catch (ClassNotFoundException ex) 
        {
            System.err.println("Erreur de chargement du driver.");
        }
        
        try 
        {
        	String str= "C:\\Users\\Kader\\git\\TD-ID-\\TD 1 ID\\Source3.xls;";
        	
        	//{Microsoft Excel Driver (*.xls)};DriverId=790;DBQ=D:\inetpub\db\fichier.xls;DefaultDir=D:\inetpub\db;
        	//this.conn = DriverManager.getConnection("jdbc:odbc:Excel Files","", "");
        	
        	this.conn = DriverManager.getConnection("jdbc:odbc:Driver={Microsoft Excel Driver (*.xls)};DriverId=22;DBQ=" + str,"", "");
        }
        catch (SQLException ex) 
        {
            System.err.println("Excel Erreur de connexion à la base de données.");
        }  
    }
    
    public void deconnexion()
    {
        try
        {
            this.conn.close();      
        }
        catch (SQLException ex) 
        {
            System.err.println("Excel Erreur de deconnexion à la base de données.");
        }
    }
}