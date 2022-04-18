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
	
	void eliminar(Disquera disquera);
	
	List<Disquera> consultar();
	
	Disquera buscarDisquera(Long id);
}
