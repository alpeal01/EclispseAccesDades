package es.florida.T1FitArch;

import java.io.File;
import org.w3c.dom.*;
import javax.xml.parsers.*;

public class Sec3_2 {

	public static void main(String[] args) {
		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document document = dBuilder.parse(new File("./xmlDocuments/personajes.xml"));

			Element raiz = document.getDocumentElement();
			System.out.println("Contingut XML " + raiz.getNodeName() + ":");
			NodeList nodeList = document.getElementsByTagName("personaje");
			for (int i = 0; i < nodeList.getLength(); i++) {
				Node node = nodeList.item(i);
				System.out.println("");
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) node;
					System.out.println("ID personaje : " + eElement.getAttribute("id"));
					System.out.println("Nombre : " + eElement.getElementsByTagName("nombre").item(0).getTextContent());
					System.out.println("Vida: " + eElement.getElementsByTagName("vida").item(0).getTextContent());
					System.out.println("Ataque: " + eElement.getElementsByTagName("ataque").item(0).getTextContent());
					System.out
							.println("Armadura: " + eElement.getElementsByTagName("armadura").item(0).getTextContent());
				}
			}
		} catch (Exception e) {

			e.printStackTrace();

		}

	}

}
