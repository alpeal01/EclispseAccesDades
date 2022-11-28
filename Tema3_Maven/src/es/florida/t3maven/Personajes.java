package es.florida.t3maven;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class Personajes {

	int id;
	
	String nombre;

	int ataque;

	int defensa;


	
	public Personajes(int id, String name, int atq, int def) {
		super();
		this.id = id;
		this.nombre = name;
		this.ataque = atq;
		this.defensa = def;
	}
	
	public Personajes() {}

	public void setId(int value) {
		this.id = value;
	}

	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getAtaque() {
		return ataque;
	}

	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}

	public int getDefensa() {
		return defensa;
	}

	public void setDefensa(int defensa) {
		this.defensa = defensa;
	}

	static void insertar(Personajes per) {
		// Carrega la configuracio i crea un session factory
		Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
		configuration.addClass(Personajes.class);
		ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties())
				.build();
		SessionFactory sessionFactory = configuration.buildSessionFactory(registry);

		// Obri una nova sessió de la session factory
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		// Ací les operacio/ns CRUD (crear, llegir, actualitzar, borrar)
		 
		Serializable id = (Serializable) session.save(per);
		System.out.println(id);

		// Commit de la transacció i tanca de sessió
		session.getTransaction().commit();
		session.close();

	}
	
	static Personajes leer (int id) {
		// Carrega la configuracio i crea un session factory
		Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
		configuration.addClass(Personajes.class);
		ServiceRegistry registry = new
		StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		SessionFactory sessionFactory = configuration.buildSessionFactory(registry);
		// Obri una nova sessió de la session factory
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		//Ací les operacio/ns CRUD (crear, llegir, actualitzar, borrar)
		Personajes per = (Personajes) session.get(Personajes.class, id);
		
		
		//Commit de la transacció i tanca de sessió
		session.getTransaction().commit();
		session.close();
		
		return per;
		
		
	}
	
	static void modificarNombre(int id, String newName) {
		
		// Carrega la configuracio i crea un session factory
		Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
		configuration.addClass(Personajes.class);
		ServiceRegistry registry = new
		StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		SessionFactory sessionFactory = configuration.buildSessionFactory(registry);
		// Obri una nova sessió de la session factory
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		//Ací les operacio/ns CRUD (crear, llegir, actualitzar, borrar)
		Personajes pers = (Personajes) session.load(Personajes.class, id);
		pers.setNombre(newName);
		session.update(pers);
		System.out.println("Nombre cambiado con exito");
		
		//Commit de la transacció i tanca de sessió
		session.getTransaction().commit();
		session.close();
		
		
	}
	static void eliminar(int id) {
		// Carrega la configuracio i crea un session factory
		Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
		configuration.addClass(Personajes.class);
		ServiceRegistry registry = new
		StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		SessionFactory sessionFactory = configuration.buildSessionFactory(registry);
		// Obri una nova sessió de la session factory
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		//Ací les operacio/ns CRUD (crear, llegir, actualitzar, borrar)
		
		Personajes cancion = new Personajes();
		cancion.setId(id);
		session.delete(cancion);
		System.out.println("Personaje eliminado");
		
		
		//Commit de la transacció i tanca de sessió
		session.getTransaction().commit();
		session.close();
		
		
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		insertar(new Personajes(0,"Atelio", 10, 2));
//		Personajes per = leer(1);		
//		System.out.println(per.nombre);
//		modificarNombre(3,"Kasani");
		eliminar(2);
		
		


	}

}
