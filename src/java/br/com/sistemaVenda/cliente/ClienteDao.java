/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistemaVenda.cliente;

import java.util.List;

public interface ClienteDao {

	public void salvar(Cliente cliente);

	public List<Cliente> listar();

	public void excluir(Cliente cliente);

	public Cliente pesquisar(String string);

	public void alterar(Cliente cliente);

	public Cliente pesquisarPorCodigo(Integer codigoString);

}
