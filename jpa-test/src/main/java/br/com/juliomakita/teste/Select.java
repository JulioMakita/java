package br.com.juliomakita.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.juliomakita.model.Carro;

public class Select {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-persistence");
		EntityManager em = emf.createEntityManager();
		
		Query query = em.createQuery("Select c from Carro c");
		
		List<Carro> list = query.getResultList();
		
		for(Carro carro : list){
			System.out.println(carro.getId() + " " + carro.getMarca() + " " + carro.getModelo());
		}
		
		System.exit(0);
	}
}
