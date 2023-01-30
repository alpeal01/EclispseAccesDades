package es.florida.examen;

import java.util.ArrayList;
import java.util.Scanner;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.lt;
import static com.mongodb.client.model.Filters.eq;

public class App {

	static void ejer1() {

		String[] titol = new String[] { "El padrino", "El padrino II", "Doce hombres sin piedad",
				"La lista de Schindler", "Testigo de cargo", "Luces de la ciudad", "Cadena perpetua",
				"El gran dictador" };
		double[] nota = new double[] { 9.0, 8.9, 8.7, 8.6, 8.6, 8.6, 8.6, 8.6 };
		int[] any = new int[] { 1972, 1974, 1957, 1993, 1957, 1931, 1994, 1940 };

		MongoClient mongoClient = new MongoClient("localhost", 27017);
		MongoDatabase database = mongoClient.getDatabase("Pelis");
		MongoCollection<Document> coleccion = database.getCollection("Top");
		// CRUD operations

		for (int i = 0; i < any.length; i++) {
			Document doc = new Document();

			doc.append("titol", titol[i]);
			doc.append("nota", nota[i]);
			doc.append("any", any[i]);

			coleccion.insertOne(doc);

		}

		System.out.println(" Insercio realitzada");

		mongoClient.close();

	}

	static void ejer2() {
		Scanner sc = new Scanner(System.in);

		System.out.println("Indica que mostrar\na)Titul\nb)Titul i la nota");
		String resp = sc.nextLine();

		MongoClient mongoClient = new MongoClient("localhost", 27017);
		MongoDatabase database = mongoClient.getDatabase("Pelis");
		MongoCollection<Document> coleccion = database.getCollection("Top");

		MongoCursor<Document> cursor = coleccion.find().iterator();
		while (cursor.hasNext()) {
			Document top = cursor.next();
			if (resp.equals("b")) {

				System.out.println(top.get("titol") + " - " + top.get("nota").toString());
			} else if (resp.equals("a")) {

				System.out.println(top.get("titol"));
			}

		}

		mongoClient.close();

	}

	static void ejer3() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Indica any");
		int resp = sc.nextInt();

		MongoClient mongoClient = new MongoClient("localhost", 27017);
		MongoDatabase database = mongoClient.getDatabase("Pelis");
		MongoCollection<Document> coleccion = database.getCollection("Top");

		Bson query = lt("any", resp);
		MongoCursor<Document> cursor = coleccion.find(query).iterator();

		while (cursor.hasNext()) {

			System.out.println(cursor.next().get("titol"));

		}

	}

	static void ejer4() {

		Scanner sc = new Scanner(System.in);

		System.out.println("Indica titol");
		String titol = sc.nextLine();

		System.out.println("Indica nova nota");
		double nota = sc.nextDouble();

		System.out.println("Indica nou any");
		int any = sc.nextInt();

		MongoClient mongoClient = new MongoClient("localhost", 27017);
		MongoDatabase database = mongoClient.getDatabase("Pelis");
		MongoCollection<Document> coleccion = database.getCollection("Top");

		coleccion.updateOne(eq("titol", titol), new Document("$set", new Document("nota", nota)));

		coleccion.updateOne(eq("titol", titol), new Document("$set", new Document("any", any)));

	}

	static void ejer5() {
		Scanner sc = new Scanner(System.in);

		System.out.println("Indica nou titol");
		String titol = sc.nextLine();

		System.out.println("Indica nova nota");
		double nota = sc.nextDouble();

		System.out.println("Indica nou any");
		int any = sc.nextInt();

		MongoClient mongoClient = new MongoClient("localhost", 27017);
		MongoDatabase database = mongoClient.getDatabase("Pelis");
		MongoCollection<Document> coleccion = database.getCollection("Top");

		Document doc = new Document();
		doc.append("titol", titol);
		doc.append("nota", nota);
		doc.append("any", any);

		coleccion.insertOne(doc);

		System.out.println("Incercio realitzada");

	}

	static void ejer6() {
		double mitja = 0;
		double min = Integer.MAX_VALUE;
		double max = Integer.MIN_VALUE;
		int num = 0;

		MongoClient mongoClient = new MongoClient("localhost", 27017);
		MongoDatabase database = mongoClient.getDatabase("Pelis");
		MongoCollection<Document> coleccion = database.getCollection("Top");
		MongoCursor<Document> cursor = coleccion.find().iterator();

		while (cursor.hasNext()) {
			Document top = cursor.next();
			double nota = top.getDouble("nota");
			System.out.println(nota);

			mitja += nota;

			if (min > nota) {
				min = nota;
			}

			if (max < nota) {

				max = nota;
			}

			num++;

		}
		System.out.println("-----------------------");

		System.out.println("Nota mitjana es: " + mitja / num);
		System.out.println("La maxima nota es: " + max);
		System.out.println("La minima nota es: " + min);

	}

	static void ejer7() {
		ArrayList <Integer> any = new ArrayList<Integer>();
		
		MongoClient mongoClient = new MongoClient("localhost", 27017);
		MongoDatabase database = mongoClient.getDatabase("Pelis");
		MongoCollection<Document> coleccion = database.getCollection("Top");

	
		
		
		MongoCursor<Document> cursor = coleccion.find().iterator();
		

		while (cursor.hasNext()) {

			any.add(cursor.next().getInteger("any"));

		}
		
		 any.sort(null);
		 
		 for (int i = 0; i < any.size(); i++) {
			 Bson query = eq("any", any.get(i));
			 cursor = coleccion.find(query).iterator();

			 
				while (cursor.hasNext()) {
					Document top = cursor.next();
					System.out.println(top.get("titol") + "\t" + top.get("nota").toString() +"\t"+ top.get("any").toString() );
				}
			
		}
		 
		 
		
		

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// ejer1();
		// ejer2();
		// ejer3();
		// ejer4();
		// ejer5();
		// ejer6();
		//ejer7();

	}

}
