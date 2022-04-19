package com.udemy.jpa.dao;

import java.util.List;

import com.udemy.jpa.entities.Disquera;

/**
 * 
 * @author pnolasco
 *	Interface que genera el DAO para las transacciones del CRUD a la tabla de disquera.
 */
public interface DisqueraDAO {
	
	void guardar(Disquera disquera);
	
	void actualizar(Disquera disquera);
	
	void eliminar(Long id);
	
	List<Disquera> consultar();
	
	Disquera buscarDisquera(Long id);
	
	/**
	 * Metodo que permite consultar con JQPL la disquera a partir de una descripcion
	 * @param descripcion {@link String} descripcion de la disquera
	 * @return {@link Disquera} la disquera consultada
	 */
	Disquera consultarByDescripcionJPQL(String descripcion);
}
