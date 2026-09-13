package basico;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import calculadora.Calculadora;

public class CalculadoraBasicaTest {

	private Calculadora calc;

	@Before
	public void setUp() {
		calc = new Calculadora();
	}

	@Test
	public void testSomaBasica() {
		assertEquals(5, calc.soma(2, 3));
	}

	@Test
	public void testSubtracaoBasica() {
		assertEquals(2, calc.subtracao(5, 3));
	}

	@Test
	public void testMultiplicacaoBasica() {
		assertEquals(15, calc.multiplicacao(3, 5));
	}

	@Test
	public void testDivisaoBasica() {
		assertEquals(2, calc.divisao(6, 3));
	}
}
