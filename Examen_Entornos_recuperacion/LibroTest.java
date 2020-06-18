import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class LibroTest {
	private static Libro x;

	@BeforeAll
	static void inicio() {
		x = new Libro();
	}
	
	@Test
	void testincrementarNumEjemplares() {
		String resultado = x.incrementarNumEjemplares();
		assertEquals("", resultado);
		assertNotNull(resultado);
		assertThrows(IllegalArgumentException.class, () -> {new incrementarNumEjemplares(null);});
	}
	
	@Test
	void testdecrementarNumEjemplares() {
		String resultado = x.decrementarNumEjemplares();
		assertNotNull(resultado);
		assertThrows(IllegalArgumentException.class, () -> {new decrementarNumEjemplares(null);});
	}
	
	@Test
	void testrecuperarCantidadEjemplares() {
		String resultado = x.recuperarCantidadEjemplares();
		assertEquals("", resultado);
		assertNotNull(resultado);
		assertThrows(Exception.class, () -> {new recuperarCantidadEjemplares(null);});
	}

}
