package es.florida.aev2;

import java.io.File;

import org.w3c.dom.*;
import javax.xml.parsers.*;


public class Model {
	String conexio;
	String user;
	String pswd;
	
	
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
	
	
	


}
