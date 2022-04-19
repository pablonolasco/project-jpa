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
		fail("Not yet implemented");
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
		fail("Not yet implemented");
	}

}
