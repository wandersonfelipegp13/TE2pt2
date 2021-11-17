package edu.te2.m3.e3.hibernate.biblioteca;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class DAOEditora {
	
	protected SessionFactory sessionFactory;

	protected void setup() {

		// configures settings from hibernate.cfg.xml
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
		try {
			sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
		} catch (Exception ex) {
			System.out.println("Erro em setup [DAOEditora]: " + ex.getMessage() + "\n");
			StandardServiceRegistryBuilder.destroy(registry);
		}

	}

	protected void exit() {
		sessionFactory.close();
	}

	public void create(Editora editora) {
		
		setup();
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		session.save(editora);

		session.getTransaction().commit();
		session.close();
		
		exit();
	}


}
