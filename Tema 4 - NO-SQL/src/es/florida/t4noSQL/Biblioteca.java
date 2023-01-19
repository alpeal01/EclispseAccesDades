package es.florida.t4noSQL;

import org.bson.Document;
import org.json.JSONObject;

import static com.mongodb.client.model.Filters.eq;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class Biblioteca {

	static void mostarTitulos() {

		MongoClient mongoClient = new MongoClient("localhost", 27017);
		MongoDatabase database = mongoClient.getDatabase("Biblioteca");
		MongoCollection<Document> coleccion = database.getCollection("Llibres");
		// CRUD operations

		MongoCursor<Document> cursor = coleccion.find().iterator();
		while (cursor.hasNext()) {
			JSONObject json = new JSONObject(cursor.next().toJson());

			System.out.println(json.get("Id") + " | " + json.get("Titol"));
		}

		mongoClient.close();

	}

	static void mostarInfo(int id) {

		MongoClient mongoClient = new MongoClient("localhost", 27017);
		MongoDatabase database = mongoClient.getDatabase("Biblioteca");
		MongoCollection<Document> coleccion = database.getCollection("Llibres");
		// CRUD operations

		MongoCursor<Document> cursor = coleccion.find(eq("Id", id)).iterator();
		while (cursor.hasNext()) {
			JSONObject json = new JSONObject(cursor.next().toJson());

			System.out.println(json);
		}

		mongoClient.close();

	}

	static void addLlibre(Llibre lib) {

		MongoClient mongoClient = new MongoClient("localhost", 27017);
		MongoDatabase database = mongoClient.getDatabase("Biblioteca");
		MongoCollection<Document> coleccion = database.getCollection("Llibres");

		Document doc = new Document();
		doc.append("Autor", lib.getAutor());
		doc.append("Editorial", lib.getEditorial());
		doc.append("Titol", lib.getTitol());
		doc.append("Any_naixementt", lib.getAny_naixement());
		doc.append("Any_publicacio", lib.getAny_publicacio());
		doc.append("Id", lib.getId());
		doc.append("Nombre_pagines", lib.getNombre_pagines());

		coleccion.insertOne(doc);

		mongoClient.close();

	}

	static void insertLlibre(Llibre lib) {

		MongoClient mongoClient = new MongoClient("localhost", 27017);
		MongoDatabase database = mongoClient.getDatabase("Biblioteca");
		MongoCollection<Document> coleccion = database.getCollection("Llibres");
		// CRUD operations
		Document doc = new Document();
		doc.append("Id", lib.getId());
		doc.append("Titol", lib.getTitol());
		doc.append("Autor", lib.getAutor());
		doc.append("Any_naixement", lib.getAny_naixement());
		doc.append("Any_publicacio", lib.getAny_publicacio());
		doc.append("Editorial", lib.getEditorial());
		doc.append("Nombre_pagines", lib.getNombre_pagines());

		coleccion.insertOne(doc);

		System.out.println("Insercio realizda con exito");

		mongoClient.close();
	}

	static void modLib(Llibre lib) {
		MongoClient mongoClient = new MongoClient("localhost", 27017);
		MongoDatabase database = mongoClient.getDatabase("Biblioteca");
		MongoCollection<Document> coleccion = database.getCollection("Llibres");
		// CRUD operations

		coleccion.updateOne(eq("Id", lib.getId()), new Document("$set", new Document("Titol", lib.getTitol())));
		coleccion.updateOne(eq("Id", lib.getId()), new Document("$set", new Document("Autor", lib.getAutor())));
		coleccion.updateOne(eq("Id", lib.getId()), new Document("$set", new Document("Autor", lib.getAutor())));

		coleccion.updateOne(eq("Id", lib.getId()), new Document("$set", new Document("Any_naixement", lib.getAny_naixement())));

		coleccion.updateOne(eq("Id", lib.getId()), new Document("$set", new Document("Any_publicacio", lib.getAny_publicacio())));

		coleccion.updateOne(eq("Id", lib.getId()), new Document("$set", new Document("Editorial", lib.getEditorial())));
		coleccion.updateOne(eq("Id", lib.getId()), new Document("$set", new Document("Nombre_pagines", lib.getNombre_pagines())));

		System.out.println("Modificacion realizada correctamente");

		mongoClient.close();

	}
	static void deleteLib(int id) {
		
		
		MongoClient mongoClient = new MongoClient("localhost", 27017);
		MongoDatabase database = mongoClient.getDatabase("Biblioteca");
		MongoCollection<Document> coleccion = database.getCollection("Llibres");
		
		coleccion.deleteOne(eq("Id", id));
		
		System.out.println("La fila a sido eliminada");
		
		mongoClient.close();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// mostarTitulos();

		// mostarInfo(3);

		// insertLlibre(new Llibre(15,"Mondogo","Carsto Madera",
		// 1999,2020,"Analis",420));
		
		//modLib((new Llibre(15,"MangoDB","Kasemir SInto",1880,1910,"Costa",69)));
		
		deleteLib(15);

	}

}
