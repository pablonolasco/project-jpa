package com.udemy.jpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.udemy.jpa.entities.Subgenero;

public class SubGeneroDAOImpl implements SubGeneroDAO {

	// Es el responsable de ADMINISTRAR y mantener las entidades en la unidad de
	// persistencia para realizar
	// las transacciones a la base de datos.
	public static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
			.createEntityManagerFactory("persistenceJPA");

	@Override
	public void guardarSubgenero(Subgenero subgenero) {
		EntityManager em = SubGeneroDAOImpl.ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction et = em.getTransaction();
		try {
			et.begin();
			em.persist(subgenero);
			et.commit();
		} catch (Exception e) {
			if (et != null)
				et.rollback();
		} finally {
			em.close();
		}

	}

	@Override
	public void actualizarSubgenero(Subgenero subgenero) {
		EntityManager em = SubGeneroDAOImpl.ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction et = em.getTransaction();
		try {
			et.begin();
			em.merge(subgenero);
			et.commit();
		} catch (Exception e) {
			if (et != null)
				et.rollback();
		} finally {
			em.close();
		}
	}

	@Override
	public List<Subgenero> consultarSubgenero() {
		EntityManager em = SubGeneroDAOImpl.ENTITY_MANAGER_FACTORY.createEntityManager();
		TypedQuery<Subgenero> querySubgenero = (TypedQuery<Subgenero>) em.createQuery("FROM Subgenero");
		return querySubgenero.getResultList();
	}

	@Override
	public Subgenero buscarByDescripcion(String descripcion) {
		EntityManager em = SubGeneroDAOImpl.ENTITY_MANAGER_FACTORY.createEntityManager();
		TypedQuery<Subgenero> querySubgenero = (TypedQuery<Subgenero>) em
				.createQuery("FROM Subgenero WHERE descripcion = :desc").setParameter("desc", descripcion);
		return querySubgenero.getSingleResult();
	}

	@Override
	public void eliminarSubgenero(Long id) {
		EntityManager em = SubGeneroDAOImpl.ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction et = em.getTransaction();
		try {
			Subgenero subgenero = em.find(Subgenero.class, id);
			et.begin();
			em.remove(subgenero);
			et.commit();

		} catch (Exception e) {
			// TODO: handle exception
		} finally {

		}
	}

	@Override
	public Subgenero buscarById(Long id) {
		EntityManager em = SubGeneroDAOImpl.ENTITY_MANAGER_FACTORY.createEntityManager();
		TypedQuery<Subgenero> querySubgenero = (TypedQuery<Subgenero>) em
				.createQuery("FROM Subgenero WHERE idSubgenero = :id").setParameter("id", id);
		return querySubgenero.getSingleResult();
	}

}
