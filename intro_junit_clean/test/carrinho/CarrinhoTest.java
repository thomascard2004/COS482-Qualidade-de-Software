package carrinho;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import produto.Produto;
import produto.ProdutoNaoEncontradoException;

public class CarrinhoTest {

	private Carrinho carrinho;
	private Produto livro;
	private Produto caderno;
	private Produto caneta;

	@Before
	public void setUp() {
		carrinho = new Carrinho();
		livro = new Produto("Java como Programar", 150.0);
		caderno = new Produto("Caderno Universitario", 25.5);
		caneta = new Produto("Caneta Esferografica", 3.5);
	}

	// ==================== TESTES: Estado Inicial ====================

	@Test
	public void deveInicializarCarrinhoComQuantidadeZero() {
		assertEquals(0, carrinho.getQtdeItems());
	}

	@Test
	public void deveInicializarCarrinhoComValorTotalZero() {
		assertEquals(0.0, carrinho.getValorTotal(), 0.0001);
	}

	// ==================== TESTES: Adicionar Itens ====================

	@Test
	public void deveAdicionarUmItemComSucesso() {
		carrinho.addItem(livro);
		assertEquals(1, carrinho.getQtdeItems());
		assertEquals(150.0, carrinho.getValorTotal(), 0.0001);
	}

	@Test
	public void deveAdicionarMultiplosItensComSucesso() {
		carrinho.addItem(livro);
		carrinho.addItem(caderno);
		carrinho.addItem(caneta);

		assertEquals(3, carrinho.getQtdeItems());
		// 150.0 + 25.5 + 3.5 = 179.0
		assertEquals(179.0, carrinho.getValorTotal(), 0.0001);
	}

	@Test
	public void devePermitirAdicionarItensRepetidos() {
		carrinho.addItem(livro);
		carrinho.addItem(livro);

		assertEquals(2, carrinho.getQtdeItems());
		assertEquals(300.0, carrinho.getValorTotal(), 0.0001);
	}

	@Test
	public void deveAdicionarProdutoComPrecoZero() {
		Produto brinde = new Produto("Adesivo Brinde", 0.0);
		carrinho.addItem(brinde);

		assertEquals(1, carrinho.getQtdeItems());
		assertEquals(0.0, carrinho.getValorTotal(), 0.0001);
	}

	// ==================== TESTES: Remover Itens ====================

	@Test
	public void deveRemoverItemExistenteComSucesso() throws ProdutoNaoEncontradoException {
		carrinho.addItem(livro);
		carrinho.addItem(caderno);

		carrinho.removeItem(livro);

		assertEquals(1, carrinho.getQtdeItems());
		assertEquals(25.5, carrinho.getValorTotal(), 0.0001);
	}

	@Test
	public void deveRemoverUltimoItemDeixandoCarrinhoVazio() throws ProdutoNaoEncontradoException {
		carrinho.addItem(livro);
		carrinho.removeItem(livro);

		assertEquals(0, carrinho.getQtdeItems());
		assertEquals(0.0, carrinho.getValorTotal(), 0.0001);
	}

	@Test
	public void deveRemoverItemIntermediarioMantendoOutrosItens() throws ProdutoNaoEncontradoException {
		carrinho.addItem(livro);   // 150.0
		carrinho.addItem(caderno); // 25.5
		carrinho.addItem(caneta);  // 3.5

		carrinho.removeItem(caderno); // Remove o item do meio

		assertEquals(2, carrinho.getQtdeItems());
		assertEquals(153.5, carrinho.getValorTotal(), 0.0001); // 150.0 + 3.5
	}

	@Test
	public void deveRemoverApenasUmaOcorrenciaDeItemDuplicado() throws ProdutoNaoEncontradoException {
		carrinho.addItem(livro);
		carrinho.addItem(livro);

		carrinho.removeItem(livro);

		// O segundo livro deve continuar no carrinho
		assertEquals(1, carrinho.getQtdeItems());
		assertEquals(150.0, carrinho.getValorTotal(), 0.0001);
	}

	@Test
	public void deveRemoverItemBaseadoNaIgualdadeDeNome() throws ProdutoNaoEncontradoException {
		carrinho.addItem(livro);
		// Cria nova instancia com mesmo nome, mas preco diferente
		Produto livroCopia = new Produto("Java como Programar", 200.0);

		carrinho.removeItem(livroCopia);

		assertEquals(0, carrinho.getQtdeItems());
		assertEquals(0.0, carrinho.getValorTotal(), 0.0001);
	}

	@Test(expected = ProdutoNaoEncontradoException.class)
	public void deveLancarExcecaoAoTentarRemoverItemInexistente() throws ProdutoNaoEncontradoException {
		carrinho.addItem(livro);
		carrinho.removeItem(caneta); // Caneta nao esta no carrinho
	}

	@Test(expected = ProdutoNaoEncontradoException.class)
	public void deveLancarExcecaoAoTentarRemoverDeCarrinhoVazio() throws ProdutoNaoEncontradoException {
		carrinho.removeItem(livro);
	}

	@Test
	public void deveManterEstadoInalteradoAposTentativaDeRemoverItemInexistente() {
		carrinho.addItem(livro);
		carrinho.addItem(caderno);

		try {
			carrinho.removeItem(caneta);
			fail("Deveria ter lançado ProdutoNaoEncontradoException");
		} catch (ProdutoNaoEncontradoException e) {
			// Invariancia: o carrinho deve manter exatamente os itens anteriores intactos
			assertEquals(2, carrinho.getQtdeItems());
			assertEquals(175.5, carrinho.getValorTotal(), 0.0001);
		}
	}

	// ==================== TESTES: Esvaziar Carrinho ====================

	@Test
	public void deveEsvaziarCarrinhoComItens() {
		carrinho.addItem(livro);
		carrinho.addItem(caderno);
		carrinho.addItem(caneta);

		carrinho.esvazia();

		assertEquals(0, carrinho.getQtdeItems());
		assertEquals(0.0, carrinho.getValorTotal(), 0.0001);
	}

	@Test
	public void devePermitirEsvaziarCarrinhoJaVazioSemErros() {
		carrinho.esvazia();

		assertEquals(0, carrinho.getQtdeItems());
		assertEquals(0.0, carrinho.getValorTotal(), 0.0001);
	}

	@Test
	public void devePermitirAdicionarItensAposEsvaziarCarrinho() {
		carrinho.addItem(livro);
		carrinho.esvazia();

		carrinho.addItem(caneta);

		assertEquals(1, carrinho.getQtdeItems());
		assertEquals(3.5, carrinho.getValorTotal(), 0.0001);
	}
}
