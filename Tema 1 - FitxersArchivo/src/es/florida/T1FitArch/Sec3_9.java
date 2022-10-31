package es.florida.T1FitArch;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Sec3_9 {
	
	public static int crearLlibre(ArrayList<Llibre> lbList) {
		
		Llibre lib = new Llibre();
		lbList.add(lib);
		
		 DocumentBuilderFactory dFact = DocumentBuilderFactory.newInstance();
		 DocumentBuilder build;
		try {
			build = dFact.newDocumentBuilder();
			Document doc = build.newDocument();
			Element raiz = doc.createElement("biblioteca");
			 doc.appendChild(raiz);
			 
			 for (Llibre lb : lbList) {
			 
			 Element llibre = doc.createElement("llibre");
			 String id = String.valueOf(lb.getIdentificador());
			 llibre.setAttribute("id", id);
			 raiz.appendChild(llibre);
			 
			 Element titol =  doc.createElement("titol");
			 titol.appendChild(doc.createTextNode(String.valueOf(lb.getTitol())));
			 llibre.appendChild(titol);
			 
			 Element autor =  doc.createElement("autor");
			 autor.appendChild(doc.createTextNode(String.valueOf(lb.getAutor())));
			 llibre.appendChild(autor);
			 
			 Element any =  doc.createElement("any");
			 any.appendChild(doc.createTextNode(String.valueOf(lb.getAny())));
			 llibre.appendChild(any);
			 
			 Element editorial =  doc.createElement("editorial");
			 editorial.appendChild(doc.createTextNode(String.valueOf(lb.getEditorial())));
			 llibre.appendChild(editorial);
			 
			 Element numPag =  doc.createElement("numPag");
			 numPag.appendChild(doc.createTextNode(String.valueOf(lb.getNumPag())));
			 llibre.appendChild(numPag);
			 }
			 
			 
			 TransformerFactory tranFactory = TransformerFactory.newInstance();
			 try {
				Transformer aTransformer = tranFactory.newTransformer();
				aTransformer.setOutputProperty(OutputKeys.ENCODING, "ISO-8859-1");
				aTransformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
				aTransformer.setOutputProperty(OutputKeys.INDENT, "yes");
				DOMSource source = new DOMSource(doc);
				try {
					FileWriter fw = new FileWriter("./xmlDocuments/biblioteca.xml");
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
			 
			 
		
		
		return lib.getIdentificador();
		
	}
	
	
	static void  mostrarLlibre() {
		
		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document document = dBuilder.parse(new File("./xmlDocuments/biblioteca.xml"));

			Element raiz = document.getDocumentElement();
			System.out.println("Contingut XML " + raiz.getNodeName() + ":");
			NodeList nodeList = document.getElementsByTagName("llibre");
			
			for (int i = 0; i < nodeList.getLength(); i++) {
				Node node = nodeList.item(i);
				System.out.println("");
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) node;
					System.out.println("ID Llibre : " + eElement.getAttribute("id"));
					System.out.println("Titol : " + eElement.getElementsByTagName("titol").item(0).getTextContent());
					System.out.println("Autor: " + eElement.getElementsByTagName("autor").item(0).getTextContent());
					System.out.println("any: " + eElement.getElementsByTagName("any").item(0).getTextContent());
					System.out.println("editorial: " + eElement.getElementsByTagName("editorial").item(0).getTextContent());
					System.out.println("Num. pag: " + eElement.getElementsByTagName("numPag").item(0).getTextContent());
				}
			}
			
		}catch(Exception e) {
			
			e.printStackTrace();
			
		}
		
		
	}
	
static void borrarLlibre (int id, ArrayList<Llibre> listLibre ) {
	
	int position = -1;
	
	for (int i = 0; i < listLibre.size(); i++) {
		
		if(listLibre.get(i).getIdentificador() == id) {
			
			position = i;
			
			
		}
		
	}
	
	if(position != -1) {
		
		
		listLibre.remove(position);
		
	}
		
	
	
	
}

static void actualitzaLlibre(int id, ArrayList<Llibre> listLibre) {
	

	for (int i = 0; i < listLibre.size(); i++) {
		
		if(listLibre.get(i).getIdentificador() == id) {
			
			
			listLibre.set(i, new Llibre());
			
		}
		
	}
		
	
}

static ArrayList<Llibre> recuperarTots() {
	
	Llibre lb;
	ArrayList<Llibre> lbList = new ArrayList<Llibre>();
	
	try {
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document document = dBuilder.parse(new File("./xmlDocuments/biblioteca.xml"));
		
		
		Element raiz = document.getDocumentElement();
		System.out.println("Contingut XML " + raiz.getNodeName() + ":");
		NodeList nodeList = document.getElementsByTagName("llibre");
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node node = nodeList.item(i);
			System.out.println("");
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				
				Element eElement = (Element) node;
				
				lb = new Llibre(eElement.getElementsByTagName("id").item(0).getTextContent(),
						eElement.getElementsByTagName("titol").item(0).getTextContent(),
						eElement.getElementsByTagName("autor").item(0).getTextContent(),
						eElement.getElementsByTagName("any").item(0).getTextContent(),
						eElement.getElementsByTagName("editorial").item(0).getTextContent(),
						eElement.getElementsByTagName("numPag").item(0).getTextContent()
						);
				lbList.add(lb);
			}
			
		
		}
		
	
	
	}catch(Exception e) {
		
		e.printStackTrace();
	}
	
	return lbList;
	
}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Llibre> lbList = recuperarTots();
		Scanner sc = new Scanner(System.in);
		int op = 0;
		
		while(op != 6) {
			System.out.println("----------Menu----------");
			System.out.println("1. Mostrar tots els títols de la biblioteca)");
			System.out.println("2. Mostrar informació detallada d’un llibre");
			System.out.println("3. Crear nou llibre”");
			System.out.println("4. Actualitzar llibre");
			System.out.println("5. Borrar llibre");
			System.out.println("6. Tanca la biblioteca");
			op = sc.nextInt();
			
			switch (op) {
			case 1: {
				
				 for (Llibre llibre : lbList) {
					 System.out.println("ID Llibre : " + llibre.getIdentificador());
						System.out.println("Titol : " + llibre.getTitol());
						System.out.println("Autor: " + llibre.getAutor());
						System.out.println("any: " + llibre.getAny());
						System.out.println("editorial: " + llibre.getEditorial());
						System.out.println("Num. pag: " + llibre.getNumPag());
				}
				 break;
				
			}
			case 2:{
				mostrarLlibre();
				break;
			}
			case 3:{
				crearLlibre(lbList);
				break;
				
			}
			case 4:{
				System.out.println("Indica identificador");
				int id = sc.nextInt();
				actualitzaLlibre(id,lbList);
				break;
				
				
			}
			case 5:{
				System.out.println("Indica identificador");
				int id = sc.nextInt();
				borrarLlibre(id,lbList);
				break;
			}
			case 6:{
				sc.close();
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + op);
				
			}
			
			
		}
		
		
		
		
		
		
		
		
	}

}
