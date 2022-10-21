package es.florida.T1FitArch;

import java.io.File;
import java.util.ArrayList;

import org.w3c.dom.*;
import javax.xml.parsers.*;

public class Sec3_6 {

	public static void main(String[] args) {
		Personaje persona;
		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document document = dBuilder.parse(new File("./xmlDocuments/personajes.xml"));
			
			ArrayList<Personaje> persList = new ArrayList<Personaje>();
			
			Element raiz = document.getDocumentElement();
			System.out.println("Contingut XML " + raiz.getNodeName() + ":");
			NodeList nodeList = document.getElementsByTagName("personaje");
			for (int i = 0; i < nodeList.getLength(); i++) {
				Node node = nodeList.item(i);
				System.out.println("");
				if (node.getNodeType() == Node.ELEMENT_NODE) {
//					Element eElement = (Element) node;
//					System.out.println("ID personaje : " + eElement.getAttribute("id"));
//					System.out.println("Nombre : " + eElement.getElementsByTagName("nombre").item(0).getTextContent());
//					System.out.println("Vida: " + eElement.getElementsByTagName("vida").item(0).getTextContent());
//					System.out.println("Ataque: " + eElement.getElementsByTagName("ataque").item(0).getTextContent());
//					System.out
//							.println("Armadura: " + eElement.getElementsByTagName("armadura").item(0).getTextContent());
					Element eElement = (Element) node;
					persona = new Personaje(
							eElement.getElementsByTagName("nombre").item(0).getTextContent(),
							Integer.parseInt(eElement.getElementsByTagName("vida").item(0).getTextContent()),
							Integer.parseInt(eElement.getElementsByTagName("ataque").item(0).getTextContent()),
							Integer.parseInt(eElement.getElementsByTagName("armadura").item(0).getTextContent())
							);
							
					persList.add(persona);
					
					
				}
			}
		} catch (Exception e) {

			e.printStackTrace();

		}

	}

}