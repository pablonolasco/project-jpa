package com.udemy.jpa.dao.test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.udemy.jpa.dao.SubGeneroDAO;
import com.udemy.jpa.dao.SubGeneroDAOImpl;
import com.udemy.jpa.entities.Genero;
import com.udemy.jpa.entities.Subgenero;

class SubGeneroDAOImplTest {

	private SubGeneroDAO subgenero= new SubGeneroDAOImpl();
	
	@Test
	void testGuardarSubgenero() {
		Subgenero subgenero= new Subgenero();
		
		subgenero.setDescripcion("rock nuevo");
		subgenero.setFechaCreacion(LocalDateTime.now());
		subgenero.setEstatus(true);
		
		Genero genero= new Genero();
		genero.setDescripcion("Hard Core");
		genero.setFechaCreacion(LocalDateTime.now());
		genero.setEstatus(true);
		
		subgenero.setGenero(genero);
		
		this.subgenero.guardarSubgenero(subgenero);
	}

	@Test
	void testActualizarSubgenero() {
		Subgenero subgenero=this.subgenero.buscarById(2L);
		
		subgenero.setDescripcion("hard core nuevo");
		subgenero.setFechaModificacion(LocalDateTime.now());
		subgenero.setEstatus(true);
		
		subgenero.getGenero().setDescripcion("hard core");
		
		this.subgenero.actualizarSubgenero(subgenero);
	}

	@Test
	void testConsultarSubgenero() {
		List<Subgenero>listaSubgenero=subgenero.consultarSubgenero();
		assertNotNull(listaSubgenero);
		
		listaSubgenero.forEach(subgenero->{
			System.out.println(subgenero.getDescripcion());
			System.out.println(subgenero.getGenero().getDescripcion());
		});
	}

	@Test
	void testBuscarByDescripcion() {
		Subgenero subgenero=this.subgenero.buscarByDescripcion("rock nuevo");
		assertNotNull(subgenero);
		System.out.println(subgenero.getDescripcion());
	}
	
	@Test
	void testBuscarById() {
		Subgenero subgenero=this.subgenero.buscarById(2L);
		assertNotNull(subgenero);
		System.out.println(subgenero.getDescripcion());
	}

}
