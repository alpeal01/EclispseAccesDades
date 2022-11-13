package es.florida.aev2;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import org.w3c.dom.*;
import javax.xml.parsers.*;

public class Model {
	String conexio;
	String user;
	String pswd;
	Connection con;

	/**
	 * Constructor de la classe model
	 */
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

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Funció per a conectar en la base de dades
	 * @return retorna un string en un error si no s'ha pogut realitzar la conexió
	 */
	public String dbConnect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			this.con = DriverManager.getConnection(this.conexio, this.user, this.pswd);
			return "Conexió estableida";

		} catch (Exception e) {

			e.printStackTrace();
		}
		return "Errada al conectar";

	}
	
	/**
	 * Funció per a desconectar en la base de dades
	 * @return retorna un string en un error si no s'ha pogut realitzar la desconexió
	 */
	public String dbDisconnect() {

		try {
			this.con.close();
			return "Conexió tancada";
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return "Errada al tancar la conexió";
	}

	/**
	 * Funció per a mostrar les taules que formen la base de dades
	 * @return retorna un string en un error si no s'ha pogut realitzar la consulta
	 */
	public String dbStruc() {
		String resultad = "------Taules----";
		try {
			Statement stmt = this.con.createStatement();
			ResultSet rs = stmt.executeQuery("SHOW TABLES;");
			while (rs.next()) {
				resultad += "\n";
				
				resultad += "      "+rs.getString(1);

			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			  e.printStackTrace();
			  resultad = "Errada! al mostrar les taules, Base de dades no conectada";
		}

		return resultad;
	}
	/**
	 * Funció per a mostrar el contingut d'una taula
	 * @param table string en el nom de la taula
	 * @return retorna el resultat de la consulta o un error si no s'ha pogut realitzar
	 */
	public String describeTable(String table) {
		String resultad = "-----Descripció de " + table + "-----\n";
		try {
			Statement stmt = this.con.createStatement();
			ResultSet rs = stmt.executeQuery("DESCRIBE " + table + ";");
			while (rs.next()) {

				resultad += "Camp: " + rs.getString(1)+"\t";
				resultad += "Tipus: " + rs.getString(2)+"\t";;
				resultad += "es Nul?: " + rs.getString(3)+"\t";;
				resultad += "Clau: " + rs.getString(4)+"\t";;
				resultad += "Defecte: " + rs.getString(5)+"\t";;
				resultad += "Extras: " + rs.getString(6)+"\t";;
				resultad += "\n";

			}

			rs.close();
			stmt.close();
			
			return resultad;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return resultad+= "Taula no trovada";

	}

	/**
	 * Funció per a convertir la contrassenya a la encriptació MD5
	 * @param input string que conté la contrassenya
	 * @return retorna la contrassenya convertida a MD5
	 * @throws NoSuchAlgorithmException
	 * @throws UnsupportedEncodingException
	 */
	public String convertPassword(String input) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		try {

			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] messageDigest = md.digest(input.getBytes());

			BigInteger no = new BigInteger(1, messageDigest);

			String hashtext = no.toString(16);
			while (hashtext.length() < 32) {
				hashtext = "0" + hashtext;
			}
			return hashtext;
		}
		catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Funció per a comprobar que el usuari i la contrassenya coincidixen en les que hi ha a la base de dades
	 * @param user
	 * @param pass
	 * @return 
	 */
	public boolean compUser(String user, String pass) {
		
		boolean line = false;
		try {
			dbConnect();
			String query = "SELECT user,pass from users where user = '" + user + "' and pass = '" + pass + "';";
			
			Statement stmt = this.con.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			line = rs.next();
			rs.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return line;

	}
	
	/**
	 * Funció que executa una consulta indicada en un string
	 * @param cons
	 * @param option
	 * @return retorna un error o el resultat de la consulta
	 */
	public String exConsulta(String cons,Boolean option)  {
		String line = "";
		try {
		Statement stmt = con.prepareStatement(cons, ResultSet.TYPE_SCROLL_SENSITIVE, 
                ResultSet.CONCUR_UPDATABLE);
		if(option) {
		ResultSet rs = stmt.executeQuery(cons);
		

		
		ResultSetMetaData rsmd = rs.getMetaData();
		rs.last();
		int size = rsmd.getColumnCount();
		rs.beforeFirst();
		while (rs.next()) {
			for (int i = 1; i <= size; i++) {
				line += rsmd.getColumnName(i).toUpperCase()+": ";
				line += rs.getString(i) + "\t|";
			}
			line += "\n";
		}
		
		}else {
			
			int rs = stmt.executeUpdate(cons);
			
			if(rs == 0) {
				
				return "Errada! Ordre no indicada correctament";
			}
			else {
				
				return "Consulta realitzada correctament";
			}
			
		}
		
	}catch(Exception e) {
		e.printStackTrace();
		line = "Errada! La consulta no esta indicada correctament";
		
	}
		
		return line;
		}
	
	
	
	

}
