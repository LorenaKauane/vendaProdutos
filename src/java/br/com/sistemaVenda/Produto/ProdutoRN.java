package br.com.sistemaVenda.Produto;

import br.com.sistemaVenda.util.DAOFactory;
import java.util.List;

public class ProdutoRN {

    private ProdutoDAO produtoDAO;

    public ProdutoRN() {
        this.produtoDAO = DAOFactory.criaProdutoDAO();
    }

    public void salvar(Produto produto) {
        this.produtoDAO.salvar(produto);

    }

    public List<Produto> listar() {
        return this.produtoDAO.listar();
    }

    public Produto pesquisarPorNome(String descricao) {
        return this.produtoDAO.pesquisarPorDescricao(descricao);
    }

    public void excluir(Produto produto) {
        this.produtoDAO.excluir(produto);

    }

    void alterar(Produto produtoSelecionado) {
        this.produtoDAO.alterar(produtoSelecionado);
    }

    public Produto pesquisarPorCodigo(Integer codigo) {
        return this.produtoDAO.pesquisarPorCodigo(codigo);
    }

}
