/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistemaVenda.teste;

import br.com.sistemaVenda.Produto.Produto;
import br.com.sistemaVenda.Produto.ProdutoRN;
import br.com.sistemaVenda.Venda.Venda;
import br.com.sistemaVenda.Venda.VendaRN;
import br.com.sistemaVenda.cliente.Cliente;
import br.com.sistemaVenda.cliente.ClienteRN;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author IAGO
 */
public class VendaTest extends TestHeranca {

    Cliente c1;
    Cliente c2;
    Cliente c3;
    
    Produto p1;
    Produto p2;
    Produto p3;
            
    //@After
    @Ignore
    public void limpaBanco() {

        VendaRN vendaRn = new VendaRN();

        List<Venda> lista = vendaRn.listar();

        for (Venda venda : lista) {
            vendaRn.excluir(venda);
        }
    }
    
    //@Test
    @Ignore
    public void registroTest() {
        VendaRN vendaRN = new VendaRN();
        Venda v1 = new Venda();
        v1.setCliente(c1);
        v1.setProduto(p1);
        v1.setDataVenda("17/04/1997");
        
        Venda v2 = new Venda();
        v2.setCliente(c2);
        v2.setProduto(p2);
        v2.setDataVenda("2005");
        
        Venda v3 = new Venda();
        v3.setCliente(c3);
        v3.setProduto(p3);
        v3.setDataVenda("2015");
        
        vendaRN.registraVenda(v1);
        vendaRN.registraVenda(v2);
        vendaRN.registraVenda(v3);
        
        List<Venda> vendas = vendaRN.listar();
        
        assertEquals(3, vendas.size());
    }
    
    //@Before
    @Ignore
    public void setUp() {
        //Cliente c1 = new Cliente(cpf, email, endereco, nome, dataCadastro, renda);
        c1 = new Cliente("10658285947", "teste@teste", "Rua teste ok", "Luana", "Hoje", 1234.50);
        c2 = new Cliente("08379158482", "teste@teste", "Leonor", "João", "Hoje", 4835);
        c3 = new Cliente("52439519278", "teste@teste", "Julio vernes", "Felipe", "Hoje", 3.200);

        ClienteRN clienteRn = new ClienteRN();
        clienteRn.salvar(c1);
        clienteRn.salvar(c2);
        clienteRn.salvar(c3);

        p1 = new Produto("Regua", "19/12/2016", 30.00, "Lote", 5);
        p2 = new Produto("Papel", "20/05/2016", 50.00, "Fardo", 10);
        p3 = new Produto("Livro", "09/12/2016", 90.00, "Edicao", 10);

        ProdutoRN produtoRn = new ProdutoRN();
        produtoRn.salvar(p1);
        produtoRn.salvar(p2);
        produtoRn.salvar(p3);

    }

    
    @Test
    //Nao funciona
    public void deletar(){
        
        VendaRN vendaRn = new VendaRN();
        Integer num = 3;
        Venda resultado = vendaRn.pesquisarVenda(num);
        
        System.out.println("RESULTADO DA VENDA:::::: "+resultado.getIdVenda());
        
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
