package es.florida.examen;

import java.util.ArrayList;
import java.util.Scanner;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class App {

	static void indicaXML() {

		Scanner sc = new Scanner(System.in);

		String port;
		String baseDades;
		String user;
		String pwd = "";
		int numConf = 1;

		System.out.println("Indica port a conectar");
		port = sc.nextLine();

		System.out.println("Indica base de dades");
		baseDades = sc.nextLine();

		System.out.println("Indica l'usuari");
		user = sc.nextLine();

		try {
			DocumentBuilderFactory dFact = DocumentBuilderFactory.newInstance();
			DocumentBuilder build = dFact.newDocumentBuilder();
			Document doc = build.newDocument();
			Element raiz = doc.createElement("configurations");
			doc.appendChild(raiz);

			Element config = doc.createElement("config" + numConf);
			raiz.appendChild(config);

			Element url = doc.createElement("url");
			url.appendChild(doc.createTextNode("jdbc:mysql://localhost:" + port + "/" + baseDades));
			config.appendChild(url);

			Element usuari = doc.createElement("user");
			usuari.appendChild(doc.createTextNode(user));
			config.appendChild(usuari);

			Element passwd = doc.createElement("password");
			passwd.appendChild(doc.createTextNode(pwd));
			config.appendChild(passwd);

			TransformerFactory tranFactory = TransformerFactory.newInstance();
			Transformer aTransformer = tranFactory.newTransformer();
			aTransformer.setOutputProperty(OutputKeys.ENCODING, "ISO-8859-1");
			aTransformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
			aTransformer.setOutputProperty(OutputKeys.INDENT, "yes");
			DOMSource source = new DOMSource(doc);
			try {
				FileWriter fw = new FileWriter("config.xml");
				StreamResult result = new StreamResult(fw);
				aTransformer.transform(source, result);
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		} catch (Exception e) {

			e.printStackTrace();

		}

		sc.close();

	}

	static Connection dBCon() {
		Connection con = null;
		String url="";
		String user="";
		String pwd = "";

		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document document = dBuilder.parse(new File("config.xml"));
			Element raiz = document.getDocumentElement();
			
			NodeList nodeList = document.getElementsByTagName("config1");
			for (int i = 0; i < nodeList.getLength(); i++) {
				Node node = nodeList.item(i);
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) node;
					url = eElement.getElementsByTagName("url").item(0).getTextContent();
					user = eElement.getElementsByTagName("user").item(0).getTextContent();
					pwd = eElement.getElementsByTagName("password").item(0).getTextContent();
				}
			}
			System.out.println(url+" " + user + " "+pwd);
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			con = DriverManager.getConnection(url,user,pwd);
			
			if(con.isValid(0)) {
				System.out.println("Conexió realitzada correctament");
				return con;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Problema en la conexió");
		return con;
	}
	
	static void triarDos(Connection con) {
		Scanner sc = new Scanner(System.in);
		int id1;
		int id2;
		ArrayList <Integer> listCal = new ArrayList <Integer>();
		double mitja;

		Statement stmt;
		try {
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT id, titol FROM saludables");
			System.out.println("Id | Titol");
			while(rs.next()) {
				System.out.println(" "+rs.getInt(1)+" | " + rs.getString(2));
				
				}
				System.out.println("Indica primera id: ");
				id1 = sc.nextInt();
				
				System.out.println("Indica segona id: ");
				id2 = sc.nextInt();
				
				rs.close();
				stmt.close();
				
				
				stmt = con.createStatement();
				//SELECT titol, calories FROM saludables WHERE id = 1 || id = 2;
				rs = stmt.executeQuery("SELECT titol, calories FROM saludables where id = " + id1 + " || id = "+ id2);
				System.out.println("Titol | calories");
				while(rs.next()) {
					listCal.add(Integer.parseInt(rs.getString(2)));
					System.out.println(rs.getString(1) +" " + (rs.getString(2)));
				}
				mitja = (listCal.get(0) + listCal.get(1))/2.00;
				
				System.out.println("La media de "+mitja+" Cal");
				rs.close();
				stmt.close();
				
				sc.close();
				
				
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
		
	}
	
	static void insertarDB(Connection con) {
		Scanner sc = new Scanner(System.in);
		String nom="";
		String calories="";
		
		System.out.println("Insertar nou menjar");
		System.out.println("Indica titol del menjar: ");
		nom = sc.nextLine();
		
		System.out.println("Insertar calories");
		calories = sc.nextLine();
		
		try {
		
		PreparedStatement psInsertar = con.prepareStatement("INSERT INTO saludables  (titol,calories) VALUES (?,?)");
				psInsertar.setString(1,nom);
				psInsertar.setString(2,calories);
				int resultadoInsertar = psInsertar.executeUpdate();
				if(resultadoInsertar == 1) {
					System.out.println("Insercio correctament");
					
				}
				
				
		}catch(Exception e) {
			e.printStackTrace();
		}

		sc.close();
		
		
	}
	
	static void consultCal(Connection con) {
		
		//SELECT titol,calories FROM `saludables` where calories >= 100
		Scanner sc = new Scanner(System.in);
		int cal;
		System.out.println("Indica calories a buscar: ");
		cal = sc.nextInt();
		Statement stmt;
		try {
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT titol,calories FROM `saludables` where calories >= "+cal);
			System.out.println("Titol | Calories");
			while(rs.next()) {
				
				System.out.println(rs.getString(1)+ " " + rs.getString(2));
			
			}
			rs.close();
			stmt.close();
		}catch(Exception e) {
			
			e.printStackTrace();
			
		}
		
		sc.close();
			
		
		
		
	}
	
	static void saveMenjar(Connection con) {
		File dir;
		FileWriter fw;
		BufferedWriter bw;
		String cal;
		
		
		Statement stmt;
		try {
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT titol,calories FROM `saludables` ");
		
			while(rs.next()) {
				
				dir = new File(rs.getString(1));
				cal = rs.getString(2);
				if(!dir.isFile()) {dir.createNewFile();}
				fw = new FileWriter(dir);
				bw = new BufferedWriter(fw);
				bw.write(cal);
				bw.close();
				fw.close();
			}
			System.out.println("Menjars guardats");
			rs.close();
			stmt.close();
		}catch(Exception e) {
			
			e.printStackTrace();
			
		}
		
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Connection con;
		//indicaXML();
		con = dBCon();
		
		//triarDos(con);
		//insertarDB(con);
		//consultCal(con);
		//saveMenjar(con);

	}

}
