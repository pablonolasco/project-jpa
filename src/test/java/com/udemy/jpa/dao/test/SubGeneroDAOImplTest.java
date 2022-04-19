package com.udemy.jpa.dao.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.udemy.jpa.dao.SubGeneroDAO;
import com.udemy.jpa.dao.SubGeneroDAOImpl;
import com.udemy.jpa.entities.Subgenero;

class SubGeneroDAOImplTest {

	private SubGeneroDAO subgenero= new SubGeneroDAOImpl();
	
	@Test
	void testGuardarSubgenero() {
		fail("Not yet implemented");
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
