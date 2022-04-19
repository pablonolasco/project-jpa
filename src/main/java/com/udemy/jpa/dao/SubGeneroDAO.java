package com.udemy.jpa.dao;
import java.util.List;

import com.udemy.jpa.entities.Subgenero;
public interface SubGeneroDAO {
	
	void guardarSubgenero(Subgenero subgenero);
	
	void actualizarSubgenero(Subgenero subgenero);
	
	void eliminarSubgenero(Long id);
	
	List<Subgenero>consultarSubgenero();
	
	Subgenero buscarByDescripcion(String descripcion);
}
