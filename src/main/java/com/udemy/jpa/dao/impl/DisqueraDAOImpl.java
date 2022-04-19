package com.udemy.jpa.dao.impl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

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
		EntityManager entityManager=DisqueraDAOImpl.ENTITY_MANAGER_FACTORY.createEntityManager();
		// crea query con jpl entre entidades de jpa y no entre las tablas de la base de datos
		TypedQuery<Disquera> queryDisquera= (TypedQuery<Disquera>) entityManager.createQuery("FROM Disquera ORDER BY descripcion");
		return queryDisquera.getResultList();
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

	@Override
	public Disquera consultarByDescripcionJPQL(String descripcion) {
		EntityManager em= DisqueraDAOImpl.ENTITY_MANAGER_FACTORY.createEntityManager();
		TypedQuery<Disquera>queryDisquera=(TypedQuery<Disquera>) em.createQuery("FROM Disquera WHERE descripcion = :desc")
					.setParameter("desc", descripcion);
		return queryDisquera.getSingleResult();
	}

}
