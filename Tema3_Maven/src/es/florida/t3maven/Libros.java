package es.florida.t3maven;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import org.hibernate.service.ServiceRegistry;



public class Libros {
	int id;
	String titol;
	String autor;
	int anyNaix;
	int anyPub;
	String editorial;
	int numPag;

	public Libros(int id, String titol, String autor, int anyNaix, int anyPub, String editorial, int numPag) {
		super();
		this.id = id;
		this.titol = titol;
		this.autor = autor;
		this.anyNaix = anyNaix;
		this.anyPub = anyPub;
		this.editorial = editorial;
		this.numPag = numPag;
	}

	public Libros(String titol, String autor, int anyNaix, int anyPub, String editorial, int numPag) {
		super();
		this.titol = titol;
		this.autor = autor;
		this.anyNaix = anyNaix;
		this.anyPub = anyPub;
		this.editorial = editorial;
		this.numPag = numPag;
	}

	public Libros() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitol() {
		return titol;
	}

	public void setTitol(String titol) {
		this.titol = titol;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getAnyNaix() {
		return anyNaix;
	}

	public void setAnyNaix(int anyNaix) {
		this.anyNaix = anyNaix;
	}

	public int getAnyPub() {
		return anyPub;
	}

	public void setAnyPub(int anyPub) {
		this.anyPub = anyPub;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public int getNumPag() {
		return numPag;
	}

	public void setNumPag(int numPag) {
		this.numPag = numPag;
	}

	public static void insert(Libros lib) {

		// Carrega la configuracio i crea un session factory
		Configuration configuration = new Configuration().configure("hibernate2.cfg.xml");
		configuration.addClass(Libros.class);
		ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties())
				.build();
		SessionFactory sessionFactory = configuration.buildSessionFactory(registry);
		// Obri una nova sessió de la session factory
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		// Ací les operacio/ns CRUD (crear, llegir, actualitzar, borrar)

		Serializable id = session.save(lib);
		System.out.println("Insercion Realizada");

		// Commit de la transacció i tanca de sessió
		session.getTransaction().commit();
		session.close();

	}

	public static void mostrarTodo() {
		// Carrega la configuracio i crea un session factory

		Configuration configuration = new Configuration().configure("hibernate2.cfg.xml");
		configuration.addClass(Libros.class);
		ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties())
				.build();
		SessionFactory sessionFactory = configuration.buildSessionFactory(registry);
		// Obri una nova sessió de la session factory
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		// Ací les operacio/ns CRUD (crear, llegir, actualitzar, borrar)
		List listaLibros =  session.createQuery("From Libros").list();
		
		


		// Commit de la transacció i tanca de sessió
		session.getTransaction().commit();
		session.close();
		
		
		for (int i = 0; i < listaLibros.size(); i++) {
			
			Libros lib = (Libros) listaLibros.get(i);
			
			System.out.println(lib.titol);
			
		}

	}
	
	public static void mostraInfoLib(int id) {
		
		// Carrega la configuracio i crea un session factory
		Configuration configuration = new Configuration().configure("hibernate2.cfg.xml");
		configuration.addClass(Libros.class);
		ServiceRegistry registry = new
		StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		SessionFactory sessionFactory = configuration.buildSessionFactory(registry);
		// Obri una nova sessió de la session factory
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		//Ací les operacio/ns CRUD (crear, llegir, actualitzar, borrar)
		
		Libros lib = (Libros) session.get(Libros.class, id);

		
		//Commit de la transacció i tanca de sessió
		session.getTransaction().commit();
		session.close();
		
		System.out.println(lib.getId()+" "+lib.getTitol()+" "+lib.getAutor()+" "+lib.getAnyNaix()+lib.getAnyPub()+" "+lib.getEditorial()+" "+lib.getNumPag());
		
		
	}
	public static void modificarLib(Libros newLib) {
		
		// Carrega la configuracio i crea un session factory
		Configuration configuration = new Configuration().configure("hibernate2.cfg.xml");
		configuration.addClass(Libros.class);
		ServiceRegistry registry = new
		StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		SessionFactory sessionFactory = configuration.buildSessionFactory(registry);
		// Obri una nova sessió de la session factory
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		//Ací les operacio/ns CRUD (crear, llegir, actualitzar, borrar)
		
	
		session.update(newLib);
		
		
		//Commit de la transacció i tanca de sessió
		session.getTransaction().commit();
		session.close();
		
		System.out.println("Modificacion realizada exitosamente");
		
		
	}
	
	public static void eliminarLib(int id) {
		
		
		// Carrega la configuracio i crea un session factory
		Configuration configuration = new Configuration().configure("hibernate2.cfg.xml");
		configuration.addClass(Libros.class);
		ServiceRegistry registry = new
		StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		SessionFactory sessionFactory = configuration.buildSessionFactory(registry);
		// Obri una nova sessió de la session factory
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		//Ací les operacio/ns CRUD (crear, llegir, actualitzar, borrar)
		
		Libros lib = new Libros();
		lib.setId(id);
		session.delete(lib);
		
		
		
		//Commit de la transacció i tanca de sessió
		session.getTransaction().commit();
		session.close();
		
		System.out.println("Modificacion realizada exitosamente");
		
		
	}

	public static void main(String[] args) {
//		Libros lib = new Libros("Cavo del 8", "Castro rolan", 1999, 2008, "Nuevikov", 240);
//		insert(lib);
//		
//		mostrarTodo();
		
//		mostraInfoLib(2);
		
//		Libros lib = new Libros(2,"Chavo del 7", "Castro rolan", 1999, 2008, "Nuevikov", 240);
//		modificarLib(lib);
		

	}

}
