/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistemaVenda.util;

import br.com.sistemaVenda.Funcionario.FuncionarioDAO;
import br.com.sistemaVenda.Funcionario.FuncionarioDAOHibernate;
import br.com.sistemaVenda.Produto.ProdutoDAO;
import br.com.sistemaVenda.Produto.ProdutoDAOHibernate;
import br.com.sistemaVenda.Venda.VendaDAO;
import br.com.sistemaVenda.Venda.VendaDAOHibernate;
import br.com.sistemaVenda.cliente.ClienteDAOHibernate;
import br.com.sistemaVenda.cliente.ClienteDao;

/**
 *
 * @author IAGO
 */
public class DAOFactory {

    //Atribuir a nossa sessão ao objeto clienteDAO
    public static ClienteDao criaClienteDAO() {
        ClienteDAOHibernate clienteDAOHibernate = new ClienteDAOHibernate();
        //Setando a sessão 
        clienteDAOHibernate.setSessao(HibernateUtil.getSessionFactory().getCurrentSession());
        return clienteDAOHibernate;
    }

    public static ProdutoDAO criaProdutoDAO() {
        ProdutoDAOHibernate produtoHibernat = new ProdutoDAOHibernate();
        produtoHibernat.setSessao(HibernateUtil.getSessionFactory().getCurrentSession());
        return produtoHibernat;
    }
    
    public static VendaDAO criaVendaDAO() {
        VendaDAOHibernate vendaHibernate = new VendaDAOHibernate();
        vendaHibernate.setSessao(HibernateUtil.getSessionFactory().getCurrentSession());
        return vendaHibernate;
    }

    public static FuncionarioDAO criarFuncionarioDAO() {
        FuncionarioDAOHibernate funcionarioHibernate = new FuncionarioDAOHibernate();
        funcionarioHibernate.setSessao(HibernateUtil.getSessionFactory().getCurrentSession());
        return funcionarioHibernate;
    }

}
