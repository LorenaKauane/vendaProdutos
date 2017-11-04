/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistemaVenda.Produto;

import java.util.List;

public interface ProdutoDAO {

    public void salvar(Produto produto);

    public List<Produto> listar();

    public Produto pesquisarPorDescricao(String descricao);

    public void excluir(Produto produto);

    public void alterar(Produto produtoSelecionado);

    public Produto pesquisarPorCodigo(Integer codigo);

}
