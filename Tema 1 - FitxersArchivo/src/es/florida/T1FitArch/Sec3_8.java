package es.florida.T1FitArch;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.*;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class Sec3_8 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		ArrayList<Personaje> persList = new ArrayList<Personaje>();
		
		 boolean op = true;
		 String res;
		 
		 do {
			 
			 persList.add(new Personaje());
			 System.out.println("Quiere ingresa otro personaje S/N");
			 res = sc.nextLine();
			 if(res.toLowerCase().equals("n")) {
				 op = false;
			 }
			
			 
		 }while(op);
		 
		 sc.close();
		 
		 
		 System.out.println("Guardando informacion");
		
			 DocumentBuilderFactory dFact = DocumentBuilderFactory.newInstance();
			 DocumentBuilder build;
			try {
				build = dFact.newDocumentBuilder();
				Document doc = build.newDocument();
				Element raiz = doc.createElement("personajes");
				 doc.appendChild(raiz);
				 
				 for (Personaje personaje : persList) {
					 
					 Element person = doc.createElement("personaje");
					 String id = String.valueOf(personaje.getId());
					 person.setAttribute("id",id); 
					 raiz.appendChild(person);
					 
					 Element nombre = doc.createElement("nombre");
					 nombre.appendChild(doc.createTextNode(String.valueOf(personaje.nombre())));
					 person.appendChild(nombre);
					 
					 Element vida = doc.createElement("vida");
					 vida.appendChild(doc.createTextNode(String.valueOf(personaje.vida())));
					 person.appendChild(vida);
					 
					 Element ataque = doc.createElement("ataque");
					 ataque.appendChild(doc.createTextNode(String.valueOf(personaje.nombre())));
					 person.appendChild(ataque);
					 
					 Element armadura = doc.createElement("armadura");
					 armadura.appendChild(doc.createTextNode(String.valueOf(personaje.armadura())));
					 person.appendChild(armadura);

					
				}
				 TransformerFactory tranFactory = TransformerFactory.newInstance();
				 try {
					Transformer aTransformer = tranFactory.newTransformer();
					aTransformer.setOutputProperty(OutputKeys.ENCODING, "ISO-8859-1");
					aTransformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
					aTransformer.setOutputProperty(OutputKeys.INDENT, "yes");
					DOMSource source = new DOMSource(doc);
					try {
						FileWriter fw = new FileWriter("./xmlDocuments/personatjesNous.xml");
						StreamResult result = new StreamResult(fw);
						try {
							aTransformer.transform(source, result);
						} catch (TransformerException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						fw.close();
						} catch (IOException e) {
						e.printStackTrace();
						}

					
				} catch (TransformerConfigurationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (ParserConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
		
		

		

	}

}