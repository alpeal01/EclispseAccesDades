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
		//CRUD operations
		
		MongoCursor<Document> cursor = coleccion.find().iterator();
		while (cursor.hasNext()) {
			JSONObject json = new JSONObject(cursor.next().toJson());
			
			System.out.println(json.get("Id")+" | " + json.get("Titol"));
		} 	

		mongoClient.close();

		
	}
	
	static void mostarInfo(int id) {
		
		

		MongoClient mongoClient = new MongoClient("localhost", 27017);
		MongoDatabase database = mongoClient.getDatabase("Biblioteca");
		MongoCollection<Document> coleccion = database.getCollection("Llibres");
		//CRUD operations
		
		MongoCursor<Document> cursor = coleccion.find( eq("Id", id)).iterator();
		while (cursor.hasNext()) {
			JSONObject json = new JSONObject(cursor.next().toJson());
			
			System.out.println(json);
		} 	

		mongoClient.close();
		
	}
	static void insertLlibre(Llibre lib) {

		MongoClient mongoClient = new MongoClient("localhost", 27017);
		MongoDatabase database = mongoClient.getDatabase("Biblioteca");
		MongoCollection<Document> coleccion = database.getCollection("Llibres");
		//CRUD operations
		Document doc = new Document();
		doc.append("Id", lib.getId());
		doc.append("Autor", lib.getAutor());
		doc.append("Any_naixement", lib.getAny_naixement());
		doc.append("Any_publicacio",lib.getAny_publicacio());
		doc.append("Titol",lib.getTitol());
		doc.append("Nombre_pagines",lib.getNombre_pagines());
		coleccion.insertOne(doc);
		
		
		mongoClient.close();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//mostarTitulos();
		
		//mostarInfo(3);
		
		
		
		
	
	}

}
