package br.com.sistemaVenda.Produto;

import br.com.sistemaVenda.cliente.ClienteBean;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "produtoBean")
@RequestScoped
public class ProdutoBean {

    private Produto produtoSelecionado = new Produto();
    private List<Produto> lista = null;

    public void salvar() {
        ProdutoRN produtoRN = new ProdutoRN();
        if (this.produtoSelecionado.getIdProduto() != null
                && this.produtoSelecionado.getIdProduto() != 0) {
            produtoRN.alterar(this.produtoSelecionado);

        } else {

            produtoRN.salvar(produtoSelecionado);

            FacesMessage faces = new FacesMessage(
                    "Produto cadastrado com sucesso!");
            FacesContext contexto = FacesContext.getCurrentInstance();
            contexto.addMessage(null, faces);
        }
        this.lista = null;
        novo();

    }

    public void deletar() {
        ProdutoRN produtoRN = new ProdutoRN();
        produtoRN.excluir(this.produtoSelecionado);
        this.lista = null;
    }

    public void redireciona() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("produto.jsf");
        } catch (IOException ex) {
            Logger.getLogger(ProdutoBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void novo() {
        this.produtoSelecionado = new Produto();
    }

    public Produto getProdutoSelecionado() {
        return produtoSelecionado;
    }

    public void setProdutoSelecionado(Produto produtoSelecionado) {
        this.produtoSelecionado = produtoSelecionado;
    }

    public List<Produto> getLista() {
        ProdutoRN produtoRN = new ProdutoRN();
        if (lista == null) {
            lista = produtoRN.listar();
        }

        return lista;
    }

    public void setLista(List<Produto> lista) {
        this.lista = lista;
    }

}
