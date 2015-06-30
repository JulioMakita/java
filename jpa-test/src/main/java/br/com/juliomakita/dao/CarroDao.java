package br.com.juliomakita.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.com.juliomakita.model.Carro;

public class CarroDao {

	private EntityManager entityManager;
	
	public CarroDao(EntityManager entityManager){
		this.entityManager = entityManager;
	}

	public List<Carro> findAll(){
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Carro> cq = cb.createQuery(Carro.class);
        Root<Carro> rootEntry = cq.from(Carro.class);
        CriteriaQuery<Carro> all = cq.select(rootEntry);
        TypedQuery<Carro> allQuery = entityManager.createQuery(all);
        return allQuery.getResultList();
	}
	
	public Carro findById(Long id){
		return entityManager.find(Carro.class, id);
	}
}
