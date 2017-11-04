/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistemaVenda.Funcionario;

import br.com.sistemaVenda.util.DAOFactory;
import java.util.List;

/**
 *
 * @author IAGO
 */
public class FuncionarioRN {
    
    private FuncionarioDAO funcionarioDAO;

    public FuncionarioRN() { 
        this.funcionarioDAO = DAOFactory.criarFuncionarioDAO();
    }
    
    
    public void salvar(Funcionario funcionario){
        this.funcionarioDAO.salvar(funcionario);
    }
    
    public void deletar(Funcionario funcionario){
        this.funcionarioDAO.deletar(funcionario);
    }
    
    public List<Funcionario> lista(){
        return this.funcionarioDAO.listar();
    }
    
    public Funcionario buscarPorNome(String nome){
        return this.funcionarioDAO.buscarPorNome(nome);
    }
    
    public Funcionario autenticacao(String cpf,String senha){
        return this.funcionarioDAO.autenticacao(cpf,senha);
        
    }
    
}
