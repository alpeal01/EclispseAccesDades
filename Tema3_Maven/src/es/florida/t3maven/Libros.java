package es.florida.t3maven;

import java.io.Serializable;

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

	public void mostrarTodo() {
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
		


		// Commit de la transacció i tanca de sessió
		session.getTransaction().commit();
		session.close();

	}

	public static void main(String[] args) {
		Libros lib = new Libros("Carlitos 2", "Romano Arpas", 1990, 2010, "Huevos", 200);
		insert(lib);

	}

}
