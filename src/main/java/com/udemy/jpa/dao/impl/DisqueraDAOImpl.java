package com.udemy.jpa.dao.impl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.udemy.jpa.dao.DisqueraDAO;
import com.udemy.jpa.entities.Disquera;

public class DisqueraDAOImpl implements DisqueraDAO {

	private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
			.createEntityManagerFactory("persistenceJPA");

	@Override
	public void guardar(Disquera disquera) {
		// contiene las funciones para persistir la informacion
		EntityManager entityManager = DisqueraDAOImpl.ENTITY_MANAGER_FACTORY.createEntityManager();

		// siempre que se haga una transaccion en la base de datos se usa entity
		// transaction
		EntityTransaction et = entityManager.getTransaction();
		// inicia transaccion
		et.begin();
		try {
			// se encarga de guardar el registro en la tabla
			entityManager.persist(disquera);
			et.commit();
		} catch (Exception e) {
			if (et != null)
				et.rollback();
		} finally {
			entityManager.close();
		}

	}

	@Override
	public void actualizar(Disquera disquera) {
		// contiene las funciones para persistir la informacion
		EntityManager entityManager = DisqueraDAOImpl.ENTITY_MANAGER_FACTORY.createEntityManager();

		// siempre que se haga una transaccion en la base de datos se usa entity
		// transaction
		EntityTransaction et = entityManager.getTransaction();
		// inicia transaccion
		et.begin();
		try {
			// se encarga de actualiza el registro en la tabla
			entityManager.merge(disquera);
			et.commit();
		} catch (Exception e) {
			if (et != null)
				et.rollback();
		} finally {
			entityManager.close();
		}
	}

	@Override
	public void eliminar(Long id) {

		EntityManager entityManager = DisqueraDAOImpl.ENTITY_MANAGER_FACTORY.createEntityManager();
		Disquera disquera = entityManager.find(Disquera.class, id);

		EntityTransaction et = entityManager.getTransaction();
		try {
			et.begin();
			entityManager.remove(disquera);
			et.commit();
		} catch (Exception e) {
			if (et != null)
				et.rollback();
		} finally {
			entityManager.close();
		}

	}

	@Override
	public List<Disquera> consultar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Disquera buscarDisquera(Long id) {
		// TODO Auto-generated method stub
		EntityManager entityManager = DisqueraDAOImpl.ENTITY_MANAGER_FACTORY.createEntityManager();

		Disquera disqueraOptional = entityManager.find(Disquera.class, id);
		if (disqueraOptional == null) {
			throw new EntityNotFoundException("la disquera con id " + id + " no se encontro");
		}

		return disqueraOptional;
	}

}