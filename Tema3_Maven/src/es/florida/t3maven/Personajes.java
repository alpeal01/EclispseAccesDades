package es.florida.t3maven;

import javax.imageio.spi.ServiceRegistry;

import org.hibernate.Session;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.mysql.cj.xdevapi.SessionFactory;

public class Personajes {
	
	int id;
	
	String name;
	
	int atq;
	
	int def;
	
	public Personajes(int id, String name, int atq, int def) {
		super();
		this.id = id;
		this.name = name;
		this.atq = atq;
		this.def = def;
	}

	static void session() {
		
		Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
		configuration.addClass(Personajes.class);
		ServiceRegistry registry = new
		StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		SessionFactory sessionFactory = configuration.buildSessionFactory(registry);
		// Obri una nova sessió de la session factory
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		//Ací les operacio/ns CRUD (crear, llegir, actualitzar, borrar)
		//Commit de la transacció i tanca de sessió
		session.getTransaction().commit();
		session.close();

		
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
