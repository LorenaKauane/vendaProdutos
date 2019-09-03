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
      
        ProdutoRN produtoRn = new ProdutoRN();
        List<Produto> produtos = produtoRn.listar();

        for (Produto produto : produtos) {
            produtoRn.excluir(produto);
        }

    }

    @Before 
    public void setup() {
        Produto prod1 = new Produto("Regua", "19/12/2016", 30.00, "Lote", 5);
        Produto prod2 = new Produto("Papel", "20/05/2016", 50.00, "Fardo", 10);
        Produto prod3 = new Produto("Livro", "09/12/2016", 90.00, "Edicao", 10);
        Produto prod4 = new Produto("Caneta", "07/02/2016", 75.00, "Caixa", 15);
      
        ProdutoRN produtoRn = new ProdutoRN();
        produtoRn.salvar(prod1);
        produtoRn.salvar(prod2);
        produtoRn.salvar(prod3);
        produtoRn.salvar(prod4);

    }

    @Test
    public void salvarProdutoTest() {

        ProdutoRN produtoRn = new ProdutoRN();
        Produto produtoSalvo = new Produto("Apontador", "19/12/2016", 70.00, "Lote33", 110);

        produtoRn.salvar(produtoSalvo);

        Produto produtoPesquisado = produtoRn.pesquisarPorNome("Apon");

        assertEquals("Lote33", produtoPesquisado.getUnidade());

    }

    @Test
    public void listaProdutoTest() {

        ProdutoRN produtoRn = new ProdutoRN();
        List<Produto> produtos = produtoRn.listar();

        assertEquals(4, produtos.size());

    }
}
