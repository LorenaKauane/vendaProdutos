
package br.com.sistemaVenda.Produto;


import br.com.sistemaVenda.cliente.ClienteRN;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass = Produto.class)
public class Conversor implements Converter {

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String codigoString) {
		if(codigoString != null && codigoString.trim().length() > 0){
			Integer codigo =  Integer.valueOf(codigoString);
			ProdutoRN produtoRn = new ProdutoRN();
			
		    return produtoRn.pesquisarPorCodigo(codigo);
			
			
		}
		
		
		return null;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object produtoObjeto) {
		if(produtoObjeto != null){
			 Produto cliente = (Produto) produtoObjeto;
			 return cliente.getIdProduto().toString();
		}
		return null;
	}

}