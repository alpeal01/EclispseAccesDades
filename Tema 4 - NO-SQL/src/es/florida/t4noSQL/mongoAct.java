package es.florida.t4noSQL;

import org.bson.Document;
import static com.mongodb.client.model.Filters.eq;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class mongoAct {
	
	 static void createCasa(MongoCollection<Document> coleccion) {
		

		Document doc = new Document();
		doc.append("_id", 2);
		doc.append("nombre", "Casa Blanca");
		doc.append("ventanas", 8);
		doc.append("puertas", 4);
		doc.append("Problemas", "goteras");
		coleccion.insertOne(doc);
		System.out.println("Inseccion realizda");
	}
	 
	 static void leerCasas(MongoCollection<Document> coleccion) {
		 
		 MongoCursor<Document> cursor = coleccion.find().iterator();
		 while (cursor.hasNext()) {
		 System.out.println(cursor.next().toJson());
		 }

		 
	 }
	 
	 static void actCasa(MongoCollection<Document> coleccion,int id,Document doc) {

		 coleccion.updateOne(eq("_id", id), new Document("$set",doc));
		 
		 System.out.println("Casa actualizada");
		 
		 
	 }
	 
	 static void delCasa(MongoCollection<Document> coleccion,int id) {
		 
		 coleccion.deleteOne(eq("_id", id));
		 
		 System.out.println("Casa aliminada");
		 
	 }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MongoClient mongoClient = new MongoClient("localhost", 27017);
		MongoDatabase database = mongoClient.getDatabase("prova");
		MongoCollection<Document> coleccion = database.getCollection("casa");
		//CRUD operations
		
		//createCasa(coleccion);
		
		//leerCasas(coleccion);
		
//		Document doc = new Document();
//		doc.append("nombre", "Casita");
//		doc.append("ventanas", 3);
//		doc.append("puertas", 2);
//		doc.append("Problemas", "Techo viejo");
//		
//		actCasa(coleccion,1, doc);	
//		
		delCasa(coleccion,2);
		mongoClient.close();
	}

}
