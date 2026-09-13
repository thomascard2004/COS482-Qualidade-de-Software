package calculadora;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class CalculadoraTest {

	private Calculadora calc;

	@Before
	public void setUp() {
		calc = new Calculadora();
	}

	// ==================== TESTES: soma ====================

	@Test
	public void deveSomarDoisNumerosPositivos() {
		int resultado = calc.soma(3, 2);
		assertEquals(5, resultado);
	}

	@Test
	public void deveSomarDoisNumerosNegativos() {
		int resultado = calc.soma(-3, -2);
		assertEquals(-5, resultado);
	}

	@Test
	public void deveSomarNumeroPositivoENegativo() {
		int resultado = calc.soma(5, -3);
		assertEquals(2, resultado);
	}

	@Test
	public void deveSomarComZeroElementoNeutro() {
		int resultado = calc.soma(10, 0);
		assertEquals(10, resultado);
	}

	// ==================== TESTES: subtracao ====================

	@Test
	public void deveSubtrairDoisNumerosPositivosResultandoEmPositivo() {
		int resultado = calc.subtracao(5, 3);
		assertEquals(2, resultado);
	}

	@Test
	public void deveSubtrairDoisNumerosPositivosResultandoEmNegativo() {
		int resultado = calc.subtracao(3, 5);
		assertEquals(-2, resultado);
	}

	@Test
	public void deveSubtrairNumerosNegativos() {
		int resultado = calc.subtracao(-5, -2);
		assertEquals(-3, resultado);
	}

	@Test
	public void deveSubtrairZeroElementoNeutro() {
		int resultado = calc.subtracao(8, 0);
		assertEquals(8, resultado);
	}

	// ==================== TESTES: multiplicacao ====================

	@Test
	public void deveMultiplicarDoisNumerosPositivos() {
		int resultado = calc.multiplicacao(4, 3);
		assertEquals(12, resultado);
	}

	@Test
	public void deveMultiplicarPositivoPorNegativo() {
		int resultado = calc.multiplicacao(4, -3);
		assertEquals(-12, resultado);
	}

	@Test
	public void deveMultiplicarDoisNumerosNegativos() {
		int resultado = calc.multiplicacao(-4, -3);
		assertEquals(12, resultado);
	}

	@Test
	public void deveMultiplicarPorZeroElementoAbsorvente() {
		int resultado = calc.multiplicacao(7, 0);
		assertEquals(0, resultado);
	}

	@Test
	public void deveMultiplicarPorUmElementoNeutro() {
		int resultado = calc.multiplicacao(9, 1);
		assertEquals(9, resultado);
	}

	// ==================== TESTES: divisao ====================

	@Test
	public void deveDividirDoisInteirosComResultadoExato() {
		int resultado = calc.divisao(6, 2);
		assertEquals(3, resultado);
	}

	@Test
	public void deveDividirTruncandoResultadoInteiro() {
		int resultado = calc.divisao(7, 2);
		assertEquals(3, resultado);
	}

	@Test
	public void deveDividirNumeroNegativoPorPositivo() {
		int resultado = calc.divisao(-6, 2);
		assertEquals(-3, resultado);
	}

	@Test
	public void deveDividirNumeroPositivoPorNegativo() {
		int resultado = calc.divisao(6, -2);
		assertEquals(-3, resultado);
	}

	@Test
	public void deveDividirDoisNumerosNegativos() {
		int resultado = calc.divisao(-6, -2);
		assertEquals(3, resultado);
	}

	@Test
	public void deveDividirPorUmElementoNeutro() {
		int resultado = calc.divisao(8, 1);
		assertEquals(8, resultado);
	}

	@Test
	public void deveDividirZeroPorNumeroNaoNulo() {
		int resultado = calc.divisao(0, 5);
		assertEquals(0, resultado);
	}

	@Test
	public void deveDividirNumeroPorSiMesmo() {
		int resultado = calc.divisao(7, 7);
		assertEquals(1, resultado);
	}

	@Test(expected = ArithmeticException.class)
	public void deveLancarExcecaoAoDividirPorZero() {
		calc.divisao(10, 0);
	}

	// ==================== TESTES: somatoria ====================

	@Test
	public void deveCalcularSomatoriaDeNumeroPositivo() {
		// 5 + 4 + 3 + 2 + 1 + 0 = 15
		int resultado = calc.somatoria(5);
		assertEquals(15, resultado);
	}

	@Test
	public void deveCalcularSomatoriaDeUmLimiteImediato() {
		// 1 + 0 = 1
		int resultado = calc.somatoria(1);
		assertEquals(1, resultado);
	}

	@Test
	public void deveCalcularSomatoriaDeZero() {
		int resultado = calc.somatoria(0);
		assertEquals(0, resultado);
	}

	@Test
	public void deveRetornarZeroParaSomatoriaDeMenosUmLimiteImediato() {
		int resultado = calc.somatoria(-1);
		assertEquals(0, resultado);
	}

	@Test
	public void deveRetornarZeroParaSomatoriaDeNumeroNegativo() {
		int resultado = calc.somatoria(-5);
		assertEquals(0, resultado);
	}

	// ==================== TESTES: ehPositivo ====================

	@Test
	public void deveRetornarTrueQuandoNumeroEhPositivo() {
		assertTrue(calc.ehPositivo(10));
	}

	@Test
	public void deveRetornarTrueQuandoNumeroEhUmLimiteSuperior() {
		assertTrue(calc.ehPositivo(1));
	}

	@Test
	public void deveRetornarTrueQuandoNumeroEhZeroLimite() {
		assertTrue(calc.ehPositivo(0));
	}

	@Test
	public void deveRetornarFalseQuandoNumeroEhMenosUmLimiteInferior() {
		assertFalse(calc.ehPositivo(-1));
	}

	@Test
	public void deveRetornarFalseQuandoNumeroEhNegativo() {
		assertFalse(calc.ehPositivo(-10));
	}

	// ==================== TESTES: compara ====================

	@Test
	public void deveRetornarZeroQuandoNumerosForemIguais() {
		int resultado = calc.compara(5, 5);
		assertEquals(0, resultado);
	}

	@Test
	public void deveRetornarZeroQuandoAmbosForemZero() {
		int resultado = calc.compara(0, 0);
		assertEquals(0, resultado);
	}

	@Test
	public void deveRetornarZeroQuandoAmbosForemNegativosIguais() {
		int resultado = calc.compara(-4, -4);
		assertEquals(0, resultado);
	}

	@Test
	public void deveRetornarUmQuandoPrimeiroNumeroForMaior() {
		int resultado = calc.compara(10, 3);
		assertEquals(1, resultado);
	}

	@Test
	public void deveRetornarUmQuandoPrimeiroNumeroNegativoForMaior() {
		// -2 é maior que -5
		int resultado = calc.compara(-2, -5);
		assertEquals(1, resultado);
	}

	@Test
	public void deveRetornarUmQuandoPrimeiroForPositivoESegundoNegativo() {
		int resultado = calc.compara(1, -1);
		assertEquals(1, resultado);
	}

	@Test
	public void deveRetornarMenosUmQuandoPrimeiroNumeroForMenor() {
		int resultado = calc.compara(3, 10);
		assertEquals(-1, resultado);
	}

	@Test
	public void deveRetornarMenosUmQuandoPrimeiroNumeroNegativoForMenor() {
		// -5 é menor que -2
		int resultado = calc.compara(-5, -2);
		assertEquals(-1, resultado);
	}

	@Test
	public void deveRetornarMenosUmQuandoPrimeiroForNegativoESegundoPositivo() {
		int resultado = calc.compara(-1, 1);
		assertEquals(-1, resultado);
	}
}
