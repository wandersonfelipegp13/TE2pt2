package edu.te2.m3.e3.jpa;

// import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AlunoManager {
	
	public static void main(String args[]) {
		
		EntityManagerFactory objFactory = Persistence.createEntityManagerFactory("PAluno");
		
		// EntityManager manager = objFactory.createEntityManager();
		
		AlunoJpaController jpa = new AlunoJpaController(objFactory);
		
		Aluno registro1 = new Aluno();
		registro1.setNome("João");
		jpa.create(registro1);
		
	}

}
