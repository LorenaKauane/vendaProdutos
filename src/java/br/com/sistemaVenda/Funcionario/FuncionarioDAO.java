/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistemaVenda.Funcionario;

import java.util.List;

/**
 *
 * @author IAGO
 */
public interface FuncionarioDAO {

    public void salvar(Funcionario funcionario);

    public void deletar(Funcionario funcionario);

    public List<Funcionario> listar();

    public Funcionario buscarPorNome(String nome);

    public Funcionario autenticacao(String cpf, String senha);
    
}
