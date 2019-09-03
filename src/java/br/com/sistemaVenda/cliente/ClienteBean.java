package br.com.sistemaVenda.cliente;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "clienteBean")
@SessionScoped
public class ClienteBean {

    private Cliente clienteSelecionado = new Cliente();
    private List<Cliente> lista = null;
    String vazia = " ";

    public void salvar() {
        ClienteRN clienteRN = new ClienteRN();

        if (this.clienteSelecionado.getIdCliente() != null
                && this.clienteSelecionado.getIdCliente() != 0) {
            clienteRN.alterar(this.clienteSelecionado);
            adicionaMensagem("O " + this.clienteSelecionado.getNome() + " Editado com sucesso!", FacesMessage.SEVERITY_INFO);
        } else {
            clienteRN.salvar(clienteSelecionado);
            adicionaMensagem("Cadastrado com sucesso!", FacesMessage.SEVERITY_INFO);
        }
        this.lista = null;
        novo();
    }
    

    public void redireciona() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("cliente.jsf");
        } catch (IOException ex) {
            Logger.getLogger(ClienteBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void adicionaMensagem(String mensagem, FacesMessage.Severity tipoErro) {
        FacesMessage fm = new FacesMessage(tipoErro, mensagem, null);
        FacesContext.getCurrentInstance().addMessage(null, fm);

    }

    public List<Cliente> getLista() {
        ClienteRN clienteRN = new ClienteRN();
        if (lista == null) {
            lista = clienteRN.listar();
        }
        return lista;
    }

    public void excluir() {
        ClienteRN clienteRN = new ClienteRN();
        clienteRN.excluir(this.clienteSelecionado);
        this.lista = null;
    }

    public void novo() {
        this.clienteSelecionado = new Cliente();

    }

    public Cliente getClienteSelecionado() {
        return clienteSelecionado;
    }

    public void setClienteSelecionado(Cliente clienteSelecionado) {
        this.clienteSelecionado = clienteSelecionado;
    }

}
