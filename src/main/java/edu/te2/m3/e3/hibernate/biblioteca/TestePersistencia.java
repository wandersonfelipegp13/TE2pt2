package edu.te2.m3.e3.hibernate.biblioteca;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class TestePersistencia {

	protected SessionFactory sessionFactory;

	protected void setup() {

		// configures settings from hibernate.cfg.xml
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
		try {
			sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
		} catch (Exception ex) {
			StandardServiceRegistryBuilder.destroy(registry);
		}

	}

	protected void exit() {
		sessionFactory.close();
	}

	protected void create() {
		Editora editora = new Editora();
		editora.setNome("Pearson");

		Livro livro = new Livro();
		livro.setTitulo("Java with Spring");
		livro.setPreco(new BigDecimal("412.65"));
		livro.setLancamento(LocalDate.of(2019, Month.APRIL, 25));
		livro.setEditora(editora);

		Session session = sessionFactory.openSession();
		session.beginTransaction();

		session.save(livro);

		session.getTransaction().commit();
		session.close();
	}

	protected void create0() {

		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Query query = session.createQuery("from Editora where id = 1");
		@SuppressWarnings("unchecked")
		List<Editora> listEditora = query.getResultList();
		Editora editora = listEditora.get(0);

		Livro livro = new Livro();
		livro.setTitulo("SOA");
		livro.setPreco(new BigDecimal("412.65"));
		livro.setLancamento(LocalDate.of(2018, Month.DECEMBER, 14));
		livro.setEditora(editora);

		session.save(livro);

		session.getTransaction().commit();
		session.close();
	}

	protected void create(Livro livro) {

		Session session = sessionFactory.openSession();
		session.beginTransaction();

		if (livro.getEditora() == null) {
			Query query = session.createQuery("from Editora where id = 1");
			@SuppressWarnings("unchecked")
			List<Editora> listEditora = query.getResultList();
			Editora editora = listEditora.get(0);
			livro.setEditora(editora);
			// posso criar uma nova editora ou lançar um erro tambem
		}
		session.save(livro);
		session.getTransaction().commit();
		session.close();
	}

	public static void main(String args[]) {

		TestePersistencia teste = new TestePersistencia();
		teste.setup();

		teste.create();
		teste.exit();

	}

}
