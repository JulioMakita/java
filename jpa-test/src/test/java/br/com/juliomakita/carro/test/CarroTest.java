package br.com.juliomakita.carro.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


import org.dbunit.operation.DatabaseOperation;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.juliomakita.dao.CarroDao;
import br.com.juliomakita.model.Carro;
import br.com.juliomakita.persistence.test.DbUnitHelper;

public class CarroTest {

	private static DbUnitHelper dbUnitHelper;
	
	private static EntityManagerFactory factory;
	private EntityManager entityManager;
	private CarroDao carroDao;
	
	@BeforeClass
	public static void initClass() {
		dbUnitHelper = new DbUnitHelper("xmlFolder");
		factory = Persistence.createEntityManagerFactory("jpa-hsqldb");
	}
	
	@Before
	public void init() {
		dbUnitHelper.execute(DatabaseOperation.INSERT, "carro.xml");
		entityManager = factory.createEntityManager();
		carroDao = new CarroDao(entityManager);
	}
	
	
	@Test
	public void deveRetornarCarros(){
		List<Carro> resultado = carroDao.findAll();
		Assert.assertNotNull(resultado);
		Assert.assertEquals(4, resultado.size());	
	}
	
	@Test
	public void deveRetornarCarro(){
		Carro carro = carroDao.findById(4L);
		Assert.assertNotNull(carro);
	}

	@After
	public void end() {
		dbUnitHelper.execute(DatabaseOperation.DELETE_ALL, "carro.xml");
		this.entityManager.close();
	}
}
