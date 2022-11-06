package es.florida.aev2;


import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.w3c.dom.*;
import javax.xml.parsers.*;


public class Model {
	String conexio;
	String user;
	String pswd;
	Statement stmt;
	Connection con;
	
	
	public Model() {
		super();
		try {
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document document = dBuilder.parse(new File("connectDB.xml"));
		NodeList nodeList = document.getElementsByTagName("conexio"); 
		Node node = nodeList.item(0);
		Element eElement = (Element) node;
		this.conexio = eElement.getElementsByTagName("url").item(0).getTextContent();
		this.user = eElement.getElementsByTagName("user").item(0).getTextContent();
		this.pswd = eElement.getElementsByTagName("pswd").item(0).getTextContent();
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	public String dbConnect() {
		try{
		Class.forName("com.mysql.cj.jdbc.Driver");
		this.con = DriverManager.getConnection(this.conexio,this.user,this.pswd);
		this.stmt = con.createStatement();
		return "Conexión establecida";
		
		}catch(Exception e) {
			
			e.printStackTrace();
		}
		return "Fallo al conectar";
		
	}
	
	public String dbDisconnect() {
		
		try {
			this.stmt.close();
			this.con.close();
			return "Conexion cerrada";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "Fallo al cerrar conexion";
	}
	
	public void dbStruc () {
		
		
		
	}
	
	//describir tablas con DESCRIBE [nombre de la tabla];
	


}
