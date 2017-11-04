/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistemaVenda.Funcionario;

import java.util.List;
import static jdk.nashorn.internal.runtime.Context.printStackTrace;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author IAGO
 */
public class FuncionarioDAOHibernate implements FuncionarioDAO {

    private Session sessao;

    public Session getSessao() {
        return sessao;
    }

    public void setSessao(Session sessao) {
        this.sessao = sessao;
    }

    @Override
    public void salvar(Funcionario funcionario) {
        try {
            this.sessao.save(funcionario);
        } catch (Throwable e) {
            printStackTrace(e);
        }
    }

    @Override
    public void deletar(Funcionario funcionario) {
        try {
            this.sessao.delete(funcionario);
        } catch (Throwable e) {
            printStackTrace(e);
        } finally {
            this.sessao.close();
        }
    }

    @Override
    public List<Funcionario> listar() {

        Criteria criteria = this.sessao.createCriteria(Funcionario.class);

        return criteria.list();
    }

    @Override
    public Funcionario buscarPorNome(String nome) {
        Query query = this.sessao.createQuery("from funcionario f where f.nome like :nome");
        try {
            query.setString("nome", "%" + nome + "%");
        } catch (Throwable e) {
            printStackTrace(e);
        }
        return (Funcionario) query.uniqueResult();
    }

    @Override
    public Funcionario autenticacao(String cpf, String senha) {
        Query consulta = this.sessao.createQuery("from funcionario f where f.cpf = :cpf AND f.senha = :senha");
        
        consulta.setString("cpf", cpf);
        consulta.setString("senha", senha);
        
        return (Funcionario) consulta.uniqueResult();
    }

}
