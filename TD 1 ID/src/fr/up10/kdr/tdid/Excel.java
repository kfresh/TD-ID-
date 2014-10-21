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
             this.conn = DriverManager.getConnection("jdbc:odbc:Excel Files","", "");
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