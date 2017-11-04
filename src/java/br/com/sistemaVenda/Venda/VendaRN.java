package br.com.sistemaVenda.Venda;

import br.com.sistemaVenda.Produto.Produto;
import br.com.sistemaVenda.util.DAOFactory;
import java.util.List;

public class VendaRN {

    private VendaDAO vendaDAO;

    public VendaRN() {
        this.vendaDAO = DAOFactory.criaVendaDAO();
    }

    public void registraVenda(Venda venda) {
        this.vendaDAO.registra(venda);
    }

    public List<Venda> listar() {
        return this.vendaDAO.getLista();
    }

    public void excluir(Venda venda) {
        this.vendaDAO.excluir(venda);

    }

    public Venda pesquisarVenda(Integer codVenda) {
        return this.vendaDAO.pesquisarVenda(codVenda);

    }
    
    public List<Venda>lista(){
        return this.vendaDAO.listar();
    }

}
