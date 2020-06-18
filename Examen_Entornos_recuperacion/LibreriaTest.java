import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class LibreriaTest {
	
	private static Libreria libreriaa;
	
	@BeforeAll
	static void inicio() {
		libreriaa = new Libreria();
	}

	@Test
	void testNuevoLibro() throws Exception{
		String resultado = libreriaa.nuevoLibro();
		assertNull(resultado);
		
	}
	
	@Test
	void testdescatalogarLibro()throws Exception {
		String resultado = libreriaa.descatalogarLibro();
		assertNotNull(resultado);
	}
	
	@Test
	void testeliminarEjemplarLibro() throws Exception{
		String resultado = libreriia.eliminarEjemplarLibro();
		assertEquals("0", resultado);
		assertNull(resultado);
		assertThrows(IllegalArgumentException.class, () -> {new eliminarEjemplarLibro(null);});
	}
	
	@Test
	void testrecuperarInfoLibro() throws Exception{
		String resultado = libreriia.recuperarInfoLibro();
		
	}
	

}
