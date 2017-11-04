package com.sistemaVenda.teste;

import br.com.sistemaVenda.Produto.Produto;
import br.com.sistemaVenda.Produto.ProdutoRN;
import java.util.List;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class ProdutoTest extends TestHeranca {

    @After
    public void limpaBanco() {
        //Criteria lista = sessao.createCriteria(Produto.class);
        ProdutoRN produtoRn = new ProdutoRN();
        List<Produto> produtos = produtoRn.listar();

        for (Produto produto : produtos) {
            produtoRn.excluir(produto);
        }

    }

    @Before
    //Prepara a base para realizar os testes e inserção 
    public void setup() {
        Produto prod1 = new Produto("Regua", "19/12/2016", 30.00, "Lote", 5);
        Produto prod2 = new Produto("Papel", "20/05/2016", 50.00, "Fardo", 10);
        Produto prod3 = new Produto("Livro", "09/12/2016", 90.00, "Edicao", 10);
        Produto prod4 = new Produto("Caneta", "07/02/2016", 75.00, "Caixa", 15);
        //Prodturo prod0 = new Produto(descricao, dataCadastro, valor, unidade, estoque)

        ProdutoRN produtoRn = new ProdutoRN();
        produtoRn.salvar(prod1);
        produtoRn.salvar(prod2);
        produtoRn.salvar(prod3);
        produtoRn.salvar(prod4);

    }

    @Test
    public void salvarProdutoTest() {

        //A descricao e o parametro que eu vou utilizar no banco para realizar a consulta
        //       Query consulta = pesquisar("Re");
        //       Produto produtoPesquisado = (Produto) consulta.uniqueResult(); 
        // Busca e traz um unico resultado
        ProdutoRN produtoRn = new ProdutoRN();
        Produto produtoSalvo = new Produto("Apontador", "19/12/2016", 70.00, "Lote33", 110);

        produtoRn.salvar(produtoSalvo);

        Produto produtoPesquisado = produtoRn.pesquisarPorNome("Apon");

        assertEquals("Lote33", produtoPesquisado.getUnidade());

    }

    @Test
    public void listaProdutoTest() {
        //Traz uma lista de produto no banco
//        Criteria lista = sessao.createCriteria(Produto.class);
//       @SuppressWarnings("unchecked")
//       List<Produto> produtos = lista.list();//chama todos os objetos

        ProdutoRN produtoRn = new ProdutoRN();
        List<Produto> produtos = produtoRn.listar();

        assertEquals(4, produtos.size());

    }

    /*   @Test
    public void excluirProdutoTest() {
        Query consulta = pesquisar("Papel");
        Produto produtoDeletado = (Produto) consulta.uniqueResult(); // Busca e traz um unico resultado
        sessao.delete(produtoDeletado);

        produtoDeletado = (Produto) consulta.uniqueResult();

        assertNull(produtoDeletado);

    }

    @Test*/
 /*   public void alteracaoProdutoTest() {
        Query consulta = pesquisar("Livro");
        Produto produtoAlterado = (Produto) consulta.uniqueResult(); // Busca e traz um unico resultado
        produtoAlterado.setEstoque(100);
        sessao.update(produtoAlterado);

        produtoAlterado = (Produto) consulta.uniqueResult(); // Busca e traz um unico resultado

        assertEquals(100, produtoAlterado.getEstoque());

    }
     */

 /*   private Query pesquisar(String parametro) {
        String sql = "from produto p where p.descricao like :descricao";
        Query consulta = sessao.createQuery(sql);
        consulta.setString("descricao", "%" + parametro + "%");
        return consulta;
    }
     */
}
