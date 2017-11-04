/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistemaVenda.Produto;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;

public class ProdutoDAOHibernate implements ProdutoDAO {

    private Session sessao;

    public Session getSessao() {
        return sessao;
    }

    public void setSessao(Session sessao) {
        this.sessao = sessao;
    }

    @Override
    public void salvar(Produto produto) {
        this.sessao.save(produto);

    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Produto> listar() {
        Criteria lista = sessao.createCriteria(Produto.class);

        return lista.list();
    }

    @Override
    @SuppressWarnings("unchecked")
    public Produto pesquisarPorDescricao(String descricao) {
        String sql = "from produto p where p.descricao like :descricao";
        Query consulta = sessao.createQuery(sql);
        consulta.setString("descricao", "%" + descricao + "%");
        return (Produto) consulta.uniqueResult();
    }

    @Override
    public void excluir(Produto produto) {
        this.sessao.delete(produto);

    }

    @Override
    public void alterar(Produto produtoSelecionado) {
        this.sessao.update(produtoSelecionado);
    }

    @Override
    public Produto pesquisarPorCodigo(Integer codigo) {
        return (Produto) this.sessao.get(Produto.class, codigo);
    }

}
