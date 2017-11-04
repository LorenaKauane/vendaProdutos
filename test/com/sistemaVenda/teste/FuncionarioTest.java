/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistemaVenda.teste;

import br.com.sistemaVenda.Funcionario.Funcionario;
import br.com.sistemaVenda.Funcionario.FuncionarioRN;
import java.util.List;
import static org.junit.Assert.assertEquals;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author IAGO
 */
public class FuncionarioTest extends TestHeranca {

    @Test
    @Ignore
    public void salvar() {
        //nome, senha, cpf, setor
        Funcionario f1 = new Funcionario("LorenaKauane", "123", "222", "Diretora");
        Funcionario f2 = new Funcionario("Joãozinho", "456", "333", "Zelador");
        Funcionario f3 = new Funcionario("Joaninha", "789", "444", "Administrador");
        Funcionario f4 = new Funcionario("Igorzinho", "1011", "555", "Balconista");

        FuncionarioRN funcionarioRN = new FuncionarioRN();
        funcionarioRN.salvar(f1);
        funcionarioRN.salvar(f2);
        funcionarioRN.salvar(f3);
        funcionarioRN.salvar(f4);

    }

    @Test
    @Ignore
    public void listar() {

        FuncionarioRN funcionarioRN = new FuncionarioRN();
        List<Funcionario> lista = funcionarioRN.lista();

        assertEquals(4, lista.size());
    }

    @Test
    @Ignore
    public void buscarPorNome() {
        FuncionarioRN funcionarioRN = new FuncionarioRN();
        String nome = "Lore";
        Funcionario resultado = funcionarioRN.buscarPorNome(nome);

        if (resultado == null) {
            System.out.println("\nNãoooo foi encontradoo\n");
        } else {

            System.out.println("Nome: " + resultado.getNome());
            System.out.println("Senha: " + resultado.getSenha());
            System.out.println("Setor: " + resultado.getSetor());
        }

    }

    @Test
    @Ignore
    public void deletar() {

        FuncionarioRN funcionarioRN = new FuncionarioRN();
        String nome = "Igor";
        Funcionario resultado = funcionarioRN.buscarPorNome(nome);

        if (resultado == null) {
            System.out.println("\nNãoooo foi encontradoo\n");
        } else {
            funcionarioRN.deletar(resultado);
            System.out.println("DELETADO!!!!!");

        }

    }

    @Test
    @Ignore
    public void autenticacao() {

        String cpf = "222";
        String senha = "123";
        FuncionarioRN funcionarioRN = new FuncionarioRN();
        Funcionario resultado = funcionarioRN.autenticacao(cpf, senha);

        if (resultado == null) {
            System.out.println("\nNãoooo foi encontradoo\n");
        } else {
            System.out.println("Nome: " + resultado.getNome());
            System.out.println("Senha: " + resultado.getSenha());
            System.out.println("Setor: " + resultado.getSetor());
        }

    }
}
