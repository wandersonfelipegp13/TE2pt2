package edu.te2.m3.e3.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

public class BookManager {
	protected SessionFactory sessionFactory;

	protected void setup() {
		// code to load Hibernate Session factory
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build(); // configures settings from hibernate.cfg.xml
				
		try {
			sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
		} catch (Exception ex) {
			StandardServiceRegistryBuilder.destroy(registry);
		}

	}

	protected void exit() {
		// code to close Hibernate Session factory
		sessionFactory.close();
	}

	protected void create(Book book) {
		// code to save a book
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		session.save(book);

		session.getTransaction().commit();
		session.close();
	}

	protected Book read(long bookId) {
		// code to get a book
		Session session = sessionFactory.openSession();

		Book book = session.get(Book.class, bookId);

		session.close();
		return book;
	}

	protected void update(Book book) {
		// code to modify a book

		Session session = sessionFactory.openSession();
		session.beginTransaction();

		session.update(book);

		session.getTransaction().commit();
		session.close();
	}

	protected void delete(Book book) {
		// code to remove a book

		Session session = sessionFactory.openSession();
		session.beginTransaction();

		session.delete(book);

		session.getTransaction().commit();
		session.close();
	}
	
	protected List<Book> find(String text) {
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		Query<Book> query = session.createQuery("from Book where title like :t");
		query.setParameter("t", "%" + text + "%");
		List<Book> listBook = query.getResultList();
		return listBook;
	}
	
	/**
	 * Usando JPA Named Queries
	 * @param text
	 * @return
	 */
	protected List<Book> find2(String text) {
		Session s = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		Query<Book> q = s.createNamedQuery("Book.findByText");
		q.setParameter(1, "%" + text + "%");
		List<Book> listBook = q.getResultList();
		return listBook;
	}

	public static void main(String[] args) {
		// code to run the program

		BookManager manager = new BookManager();
		manager.setup();

		// Book book1 = new Book("Java 2020", "Pedro", 20.45f);
		// manager.create(book);
		// Book book2 = manager.read(1);
		// System.out.println(book2.toString());
		// Book book3 = new Book(6, "Java Dev 2021", "Z??", 40.34f);
		// manager.update(book3);
		// Book book3 = new Book();
		// book3.setId(1);
		// manager.delete(book3);
		
		List<Book> listBook = manager.find2("Java");
		for (Book book : listBook) {
			System.out.println(book);
		}

		manager.exit();
	}
}
