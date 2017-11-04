
package br.com.sistemaVenda.Venda;

import br.com.sistemaVenda.Produto.Produto;
import java.util.List;


public interface VendaDAO {

	public void registra(Venda venda);

	public List<Venda> getLista();

	public void excluir(Venda venda);

    public Venda pesquisarVenda(Integer codVenda);

    public List<Venda> listar();


}
