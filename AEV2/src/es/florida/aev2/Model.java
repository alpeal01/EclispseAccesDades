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

	public String dbDisconnect() {

		try {
			this.con.close();
			return "Conexió tancada";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "Errada al tancar la conexió";
	}

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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return resultad;
	}

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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return resultad+= "Taula no trovada";

	}

	// describir tablas con DESCRIBE [nombre de la tabla];

//    public void controlLogin() throws HeadlessException, NoSuchAlgorithmException, UnsupportedEncodingException {
//        dbConnect();
//        ArrayList<String> res = getUserPass();
//        dbDisconnect();
//        JTextField username = new JTextField();
//        JTextField password = new JPasswordField();
//        Object[] message = { "Username:", username, "Password:", password };
//
//        while (res.lastIndexOf(username.getText()) == -1 ||res.lastIndexOf(convertPassword(password.getText())) == -1) {
//            int option = JOptionPane.showConfirmDialog(null, message, "Login", JOptionPane.OK_CANCEL_OPTION);
//            if (res.lastIndexOf(username.getText()) == -1|| res.lastIndexOf(convertPassword(password.getText())) == -1) {
//                JOptionPane.showMessageDialog(password, "La contrassenya o l'usuari no son correctes");
//                password.setText("");
//                username.setText("");
//            }
//        }
//        JOptionPane.showMessageDialog(password, "Sessió iniciada");
//    }

	public String convertPassword(String input) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		try {

			// Static getInstance method is called with hashing MD5
			MessageDigest md = MessageDigest.getInstance("MD5");

			// digest() method is called to calculate message digest
			// of an input digest() return array of byte
			byte[] messageDigest = md.digest(input.getBytes());

			// Convert byte array into signum representation
			BigInteger no = new BigInteger(1, messageDigest);

			// Convert message digest into hex value
			String hashtext = no.toString(16);
			while (hashtext.length() < 32) {
				hashtext = "0" + hashtext;
			}
			return hashtext;
		}

		// For specifying wrong message digest algorithms
		catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}

//    public ArrayList<String> getUserPass() {
//        ArrayList<String> resultad = new ArrayList<String>();
//        try {
//            Statement stmt = this.con.createStatement();
//            ResultSet rs = stmt.executeQuery("SELECT user,pass from users;");
//            while (rs.next()) {
//                resultad.add(rs.getString(1));
//                resultad.add(rs.getString(2));
//            }
//            rs.close();
//            stmt.close();
//        } catch (SQLException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//
//        return resultad;
//    }

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

	public String exConsulta(String cons) throws SQLException {
		Statement stmt = con.prepareStatement(cons, ResultSet.TYPE_SCROLL_SENSITIVE, 
                ResultSet.CONCUR_UPDATABLE);
		ResultSet rs = stmt.executeQuery(cons);
		ResultSetMetaData rsmd = rs.getMetaData();
		rs.last();
		int size = rsmd.getColumnCount();
		rs.beforeFirst();
		String line = "";
		while (rs.next()) {
			for (int i = 1; i <= size; i++) {
				line += rsmd.getColumnName(i).toUpperCase()+": ";
				line += rs.getString(i) + "\t|";
			}
			line += "\n";
		}
		return line;

	}

}
