package com.sistemaVenda.teste;

import br.com.sistemaVenda.Produto.Produto;
import br.com.sistemaVenda.cliente.Cliente;
import br.com.sistemaVenda.cliente.ClienteRN;
import br.com.sistemaVenda.util.HibernateUtil;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class ClienteTest extends TestHeranca {

    

    @Before
    public void setUp() {
        //Cliente c1 = new Cliente(cpf, email, endereco, nome, dataCadastro, renda);
        Cliente c1 = new Cliente("10658285947", "teste@teste", "Rua teste ok", "Luana", "Hoje", 1234.50);
        Cliente c2 = new Cliente("08379158482", "teste@teste", "Leonor", "João", "Hoje", 4835);
        Cliente c3 = new Cliente("52439519278", "teste@teste", "Julio vernes", "Felipe", "Hoje", 3.200);
        Cliente c4 = new Cliente("38677578609", "teste@teste", "Luiz gonzaga", "Lorena", "Hoje", 3.100);

        ClienteRN clienteRn = new ClienteRN();
        clienteRn.salvar(c1);
        clienteRn.salvar(c2);
        clienteRn.salvar(c3);
        clienteRn.salvar(c4);

    }
    
    @After
    public void limpaBanco() {

        ClienteRN clienteRn = new ClienteRN();

        List<Cliente> lista = clienteRn.listar();

        for (Cliente cliente : lista) {
            clienteRn.excluir(cliente);
        }
    }

    @Test
    public void listarTest() {
        ClienteRN clienteRn = new ClienteRN();

        List<Cliente> lista = clienteRn.listar();

        assertEquals(10, lista.size());
    }

    @Test
    public void excluirTest() {
        ClienteRN clienteRn = new ClienteRN();
        List<Cliente> lista = clienteRn.listar();

        Cliente clienteExcluido = lista.get(0);

        clienteRn.excluir(clienteExcluido);
        //carregar os elementos do banco
        lista = clienteRn.listar();

        assertEquals(3, lista.size());
    }

    @Test
    public void pesquisaTest() {

        ClienteRN clienteRn = new ClienteRN();
        //pesquisar
        Cliente clientePesquisado = clienteRn.pesquisar("rena");
        //compara o endereco
        assertEquals("Luiz gonzaga", clientePesquisado.getEndereco());

    }

    public void alterarTest() {
        ClienteRN clienteRn = new ClienteRN();
        //pesquisar
        Cliente clientePesquisado = clienteRn.pesquisar("rena");
        //compara o endereco
        assertEquals("Luiz gonzaga", clientePesquisado.getEndereco());
        
        clientePesquisado.setCpf("10658285947");
        clienteRn.alterar(clientePesquisado);
        
        Cliente clienteAlterado = clienteRn.pesquisar("rena");
        assertEquals("10658285947", clienteAlterado.getCpf());
    }
}
