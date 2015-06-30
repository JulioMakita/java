package br.com.juliomakita.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.juliomakita.model.Carro;

public class Insert {

	public static void main(String[] args) {
		
		 EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-persistence");
		 EntityManager em = emf.createEntityManager();

		 try{
			 
			 em.getTransaction().begin();
			 
			 Carro carro = new Carro();
			 carro.setAno(2012);
			 carro.setMarca("chevrolet");
			 carro.setModelo("corsa");
			 
			 em.persist(carro);
             
	         em.getTransaction().commit();
	         
		 }catch (Exception e) {
	         em.getTransaction().rollback();
	         e.printStackTrace();
	     } finally{
	        emf.close();
	    }
	}
}
