package br.com.juliomakita.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.juliomakita.model.Carro;

public class Update {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-persistence");
		EntityManager em = emf.createEntityManager();
		
		Carro carro = em.find(Carro.class, 1L);
		
		try{
			em.getTransaction().begin();
			
			carro.setMarca("Ford");
			carro.setModelo("Fiesta");
			
			em.getTransaction().commit();
			
		}catch (Exception e) {
	         em.getTransaction().rollback();
	         e.printStackTrace();
	    } finally{
	        emf.close();
	    }
	}
}
