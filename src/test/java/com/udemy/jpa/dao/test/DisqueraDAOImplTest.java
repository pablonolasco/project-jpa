/**
 * 
 */
package com.udemy.jpa.dao.test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.udemy.jpa.dao.DisqueraDAO;
import com.udemy.jpa.dao.impl.DisqueraDAOImpl;
import com.udemy.jpa.entities.Disquera;

/**
 * @author pnolasco
 *
 */
class DisqueraDAOImplTest {

	// implementacion
	private DisqueraDAO disqueraDAO= new DisqueraDAOImpl();
	/**
	 * Test method for {@link com.udemy.jpa.dao.impl.DisqueraDAOImpl#guardar(com.udemy.jpa.entities.Disquera)}.
	 */
	@Test
	void testGuardar() {
		// entidad
		Disquera disquera= new Disquera();
		disquera.setDescripcion("MegaForce2");
		disquera.setFechaCreacion(LocalDateTime.now());
		disquera.setEstatus(true);
		
		this.disqueraDAO.guardar(disquera);
	}

	/**
	 * Test method for {@link com.udemy.jpa.dao.impl.DisqueraDAOImpl#actualizar(com.udemy.jpa.entities.Disquera)}.
	 */
	@Test
	void testActualizar() {
		Disquera disquera=this.disqueraDAO.buscarDisquera(10L);
		disquera.setEstatus(true);
		this.disqueraDAO.actualizar(disquera);
	}

	/**
	 * Test method for {@link com.udemy.jpa.dao.impl.DisqueraDAOImpl#eliminar(com.udemy.jpa.entities.Disquera)}.
	 */
	@Test
	void testEliminar() {
		this.disqueraDAO.eliminar(10L);
	}

	/**
	 * Test method for {@link com.udemy.jpa.dao.impl.DisqueraDAOImpl#consultar()}.
	 */
	@Test
	void testConsultar() {
		List<Disquera> disquera=this.disqueraDAO.consultar();
		assertTrue(disquera.size()>0);
		
		disquera.forEach(item -> {
			System.out.println(item.getDescripcion());
		});
	}

	/**
	 * Test method for {@link com.udemy.jpa.dao.impl.DisqueraDAOImpl#buscarDisquera(java.lang.Long)}.
	 */
	@Test
	void testBuscarDisquera() {
		
		Disquera disquera=this.disqueraDAO.buscarDisquera(1L);
		System.out.println(disquera.getDescripcion());
		
		
	}


}
