package br.com.sistemaVenda.Venda;

import br.com.sistemaVenda.Produto.Produto;
import br.com.sistemaVenda.Produto.ProdutoRN;
import br.com.sistemaVenda.cliente.Cliente;
import br.com.sistemaVenda.cliente.ClienteRN;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

@ManagedBean(name = "registroVendas")
@ViewScoped
public class RegistroVendaBean {

    private Cliente clienteSelecionado;
    private Venda venda= new Venda();
    private List<Venda> vendaSelecionado;
    private Produto produtoSelecionado = new Produto();
    private List<Produto> carrinhoCompras = new ArrayList<Produto>();
    private List<SelectItem> clienteSelect;
    private List<SelectItem> produtoSelect;
    private float valorTotal;

    public String buscarProduto() {

        ProdutoRN produtoRN = new ProdutoRN();
        Produto produtoPesquisado = new Produto();
     
           if (this.produtoSelecionado.getIdProduto() != null ) {

            produtoPesquisado = produtoRN.pesquisarPorCodigo(this.produtoSelecionado.getIdProduto());

            if (produtoPesquisado != null) {
                this.carrinhoCompras.add(produtoPesquisado);
                calculaTotal();
            }

            } 
    
        return null;
    }

    private void calculaTotal() {

        this.valorTotal = 0;
        if (!this.carrinhoCompras.isEmpty()) {
            for (Produto p : this.carrinhoCompras) {
                valorTotal += p.getValor();
            }
        }
    }

    public String finalizarVenda() {

        if (!this.carrinhoCompras.isEmpty()) {
            ArrayList<Venda> vendas = new ArrayList<Venda>();
            VendaRN vendaRN = new VendaRN();

            for (Produto produto : this.carrinhoCompras) {

                if (this.clienteSelecionado != null) {
                    vendas.add(new Venda(produto, this.clienteSelecionado));
                }
            }
            for (Venda venda : vendas) {
                vendaRN.registraVenda(venda);
            }
        }
        return null;
    }

    public String excluirProdutoCarrinho() {

        if (this.carrinhoCompras != null && !this.carrinhoCompras.isEmpty()) {
            if (this.produtoSelecionado != null) {
                this.carrinhoCompras.remove(this.produtoSelecionado);
                calculaTotal();
            }
        }
        return null;
    }

    public List<SelectItem> getClienteSelect() {

        if (clienteSelect == null) {
            clienteSelect = new ArrayList<SelectItem>();
            ClienteRN clienteRN = new ClienteRN();
            List<Cliente> listaClientes = clienteRN.listar();

            if (listaClientes != null && !listaClientes.isEmpty()) {
                SelectItem item;
                for (Cliente clienteLista : listaClientes) {
                    item = new SelectItem(clienteLista, clienteLista.getNome());
                    clienteSelect.add(item);
                }
            }
        }
        return clienteSelect;
    }

    public List<SelectItem> getProdutoSelect() {
        if (produtoSelect == null) {
            produtoSelect = new ArrayList<SelectItem>();
            ProdutoRN produtoRN = new ProdutoRN();
            List<Produto> listaProdutos = produtoRN.listar();

            if (listaProdutos != null && !listaProdutos.isEmpty()) {
                SelectItem item;

                for (Produto produtoLista : listaProdutos) {
                    item = new SelectItem(produtoLista, produtoLista.getDescricao());
                    produtoSelect.add(item);
                }
            }
        }
        return produtoSelect;
    }

    
    public void deletar(){
        
        VendaRN vendaRn = new VendaRN();
        vendaRn.excluir(this.venda);
        
    }

    public Cliente getClienteSelecionado() {
        return clienteSelecionado;
    }

    public void setClienteSelecionado(Cliente clienteSelecionado) {
        this.clienteSelecionado = clienteSelecionado;
    }

    public Produto getProdutoSelecionado() {
        return produtoSelecionado;
    }

    public void setProdutoSelecionado(Produto produtoSelecionado) {
        this.produtoSelecionado = produtoSelecionado;
    }

    public List<Produto> getCarrinhoCompras() {
        return carrinhoCompras;
    }

    public void setCarrinhoCompras(List<Produto> carrinhoCompras) {
        this.carrinhoCompras = carrinhoCompras;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }

    public void setClienteSelect(List<SelectItem> clienteSelect) {
        this.clienteSelect = clienteSelect;
    }

    public void setProdutoSelect(List<SelectItem> produtoSelect) {
        this.produtoSelect = produtoSelect;
    }

    public List<Venda> getVendaSelecionado() {
        
        VendaRN vendaRN = new VendaRN();
        if (vendaSelecionado == null) {
            vendaSelecionado = vendaRN.listar();
        }

        return vendaSelecionado;
    }

    public void setVendaSelecionado(List<Venda> vendaSelecionado) {
        this.vendaSelecionado = vendaSelecionado;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

}
