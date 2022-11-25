package es.florida.t3maven;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class Personajes {
	
	int id;
	
	String name;
	
	int atq;
	
	int def;
	
	public Personajes(String name, int atq, int def) {
		super();
		this.name = name;
		this.atq = atq;
		this.def = def;
	}

	static void session() {
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
		Personajes per = new Personajes("Casio", 5,10 );
		Serializable id = (Serializable) session.save(per);
		System.out.println(id);
		
		
		//Commit de la transacció i tanca de sessió
		session.getTransaction().commit();
		session.close();

		
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		session();

	}

}
