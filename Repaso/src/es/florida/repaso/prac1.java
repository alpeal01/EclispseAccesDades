package es.florida.repaso;

import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;

public class prac1 {

	static ArrayList<Person> leerXml(String nameFile) {
		int id;
		String nom;
		int edad;
		String job;
		ArrayList<Person> list = new ArrayList<Person>();

		try {

			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document document = dBuilder.parse(new File(nameFile));

			Element raiz = document.getDocumentElement();
			System.out.println("Contingut XML " + raiz.getNodeName() + ":");
			NodeList nodeList = document.getElementsByTagName("person");
			for (int i = 0; i < nodeList.getLength(); i++) {

				Node node = nodeList.item(i);
				System.out.println("");
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) node;
					System.out.println("ID : " + (id = Integer.parseInt(eElement.getAttribute("id"))));
					System.out.println(
							"Nom : " + (nom = eElement.getElementsByTagName("nombre").item(0).getTextContent()));
					System.out.println("edad : " + (edad = Integer
							.parseInt(eElement.getElementsByTagName("edad").item(0).getTextContent())));
					System.out
							.println("job : " + (job = eElement.getElementsByTagName("job").item(0).getTextContent()));
					list.add(new Person(id, nom, edad, job));
				}

			}

		} catch (Exception e) {

			e.printStackTrace();
		}
		return list;
	}

	static void guardarXML(String fileName, ArrayList<Person> list) {

		try {
			DocumentBuilderFactory dFact = DocumentBuilderFactory.newInstance();
			DocumentBuilder build = dFact.newDocumentBuilder();
			Document doc = build.newDocument();
			Element raiz = doc.createElement("persons");
			doc.appendChild(raiz);

			for (Person pers : list) {

				Element person = doc.createElement("person");
				String id = String.valueOf(pers.getId());
				person.setAttribute("id", id);
				raiz.appendChild(person);

				Element nom = doc.createElement("nombre");
				nom.appendChild(doc.createTextNode(pers.getNom()));
				person.appendChild(nom);

				Element edad = doc.createElement("edad");
				edad.appendChild(doc.createTextNode(Integer.toString(pers.getEdad())));
				person.appendChild(edad);

				Element job = doc.createElement("job");
				job.appendChild(doc.createTextNode(pers.getJob()));
				person.appendChild(job);

			}

			TransformerFactory tranFactory = TransformerFactory.newInstance(); // Crear serialitzador
			Transformer aTransformer = tranFactory.newTransformer();
			aTransformer.setOutputProperty(OutputKeys.ENCODING, "ISO-8859-1"); // Formato al document
			aTransformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
			aTransformer.setOutputProperty(OutputKeys.INDENT, "yes");
			DOMSource source = new DOMSource(doc);
			try {
				FileWriter fw = new FileWriter(fileName); // Definir el nom del fitxer i guardar
				StreamResult result = new StreamResult(fw);
				aTransformer.transform(source, result);
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (TransformerException ex) {
			System.out.println("Error escrivint el documento");
		} catch (ParserConfigurationException ex) {
			System.out.println("Error construint el document");
		}

	}

	public static void main(String[] args) {
		ArrayList<Person> list = leerXml("person.xml");
		list.add(new Person(5,"Crista",28,"Medic"));
		guardarXML("person.xml",list);

	}

}
