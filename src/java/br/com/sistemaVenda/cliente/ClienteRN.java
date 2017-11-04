/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistemaVenda.cliente;

import br.com.sistemaVenda.util.DAOFactory;
import java.util.List;

public class ClienteRN {

    private ClienteDao clienteDAO;

    public ClienteRN() {
        this.clienteDAO = DAOFactory.criaClienteDAO();
    }

    public void salvar(Cliente c1) {
        this.clienteDAO.salvar(c1);
    }

    public List<Cliente> listar() {
        return this.clienteDAO.listar();
    }

    public void excluir(Cliente cliente) {
        this.clienteDAO.excluir(cliente);

    }

    public Cliente pesquisar(String string) {
        return this.clienteDAO.pesquisar(string);
    }

    public void alterar(Cliente cliente) {
        this.clienteDAO.alterar(cliente);

    }

    public Cliente pesquisarPorCodigo(Integer codigoString) {

        return this.clienteDAO.pesquisarPorCodigo(codigoString);
    }



}
