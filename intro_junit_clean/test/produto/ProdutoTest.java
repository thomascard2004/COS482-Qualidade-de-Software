package produto;

import static org.junit.Assert.*;
import org.junit.Test;

public class ProdutoTest {

	@Test
	public void deveCriarProdutoComNomeEPrecoCorretos() {
		Produto p = new Produto("Mochila", 120.0);
		assertEquals("Mochila", p.getNome());
		assertEquals(120.0, p.getPreco(), 0.0001);
	}

	@Test
	public void devePermitirAlterarNomeComSetter() {
		Produto p = new Produto("Mochila", 120.0);
		p.setNome("Mochila Escolar");
		assertEquals("Mochila Escolar", p.getNome());
	}

	@Test
	public void devePermitirAlterarPrecoComSetter() {
		Produto p = new Produto("Mochila", 120.0);
		p.setPreco(99.90);
		assertEquals(99.90, p.getPreco(), 0.0001);
	}

	@Test
	public void deveRetornarTrueParaProdutosComMesmoNomeEPrecosIguais() {
		Produto p1 = new Produto("Teclado", 150.0);
		Produto p2 = new Produto("Teclado", 150.0);
		assertTrue(p1.equals(p2));
	}

	@Test
	public void deveRetornarTrueParaProdutosComMesmoNomeMesmoComPrecosDiferentes() {
		// O equals da classe Produto compara apenas pelo nome
		Produto p1 = new Produto("Mouse", 80.0);
		Produto p2 = new Produto("Mouse", 120.0);
		assertTrue(p1.equals(p2));
	}

	@Test
	public void deveRetornarFalseParaProdutosComNomesDiferentes() {
		Produto p1 = new Produto("Monitor", 900.0);
		Produto p2 = new Produto("Teclado", 900.0);
		assertFalse(p1.equals(p2));
	}
}
