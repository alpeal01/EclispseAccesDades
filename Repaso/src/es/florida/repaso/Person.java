package es.florida.repaso;

public class Person {
	int id;
	String nom;
	int edad;
	String job;
	public Person(int id,String nom, int edad, String job) {
		super();
		this.id = id;
		this.nom = nom;
		this.edad = edad;
		this.job = job;
	}
	public int getId() {
		
		return id;
	}
	
	public String getNom() {
		return nom;
	}
	public int getEdad() {
		return edad;
	}
	public String getJob() {
		return job;
	}
	
	
	
	
}
