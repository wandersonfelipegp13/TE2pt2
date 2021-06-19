package edu.te2.m3.e3.jpa;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class AlunoJpaController implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private EntityManagerFactory emf = null;
	
	public AlunoJpaController(EntityManagerFactory emf) {
		this.emf = emf;
	}
	
	public EntityManager getEntityManager() {
		return emf.createEntityManager();
	}
	
	public void create(Aluno aluno) {
		EntityManager em = null;
		try {
			em = getEntityManager();
			em.getTransaction().begin();
			em.persist(aluno);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
