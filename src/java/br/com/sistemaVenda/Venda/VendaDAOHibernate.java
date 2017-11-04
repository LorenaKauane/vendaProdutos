/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistemaVenda.Venda;

import br.com.sistemaVenda.Produto.Produto;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class VendaDAOHibernate implements VendaDAO {

    private Session sessao;

    public Session getSessao() {
        return sessao;
    }

    public void setSessao(Session sessao) {
        this.sessao = sessao;
    }

    @Override
    public void registra(Venda venda) {
        this.sessao.save(venda);

    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Venda> getLista() {
        Criteria lista = sessao.createCriteria(Venda.class);
        return lista.list();
    }

    @Override
    public void excluir(Venda venda) {
        this.sessao.delete(venda);
    }

    @Override
    public Venda pesquisarVenda(Integer codVenda) {
        Criteria busca = this.sessao.createCriteria(Venda.class);
        busca.add(Restrictions.idEq(codVenda));

        return (Venda) busca.uniqueResult();
    }

    @Override
    public List<Venda> listar() {
        String sql = "";
       Query consulta = sessao.createQuery(sql);
       return consulta.list();
    }

}
