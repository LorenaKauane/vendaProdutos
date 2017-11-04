package br.com.sistemaVenda.validador;

import java.util.ResourceBundle;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

public class CPFValidador implements Validator {

    @Override
    public void validate(FacesContext contex, UIComponent component, Object value) throws ValidatorException {
        if (value == null) {
            return;
        }

        String cpf = (String) value;

        if (cpf.length() != 11
                || !calcDigVerif(cpf.substring(0, 9)).equals(cpf.substring(9, 11)) || cpf == null || cpf == "") {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "CPF invalido.", "Favor me informar um cpf valido, sem pontos ou traços"));
        }
    }

    private String calcDigVerif(String num) {
        Integer primDig, segDig;
        int soma = 0, peso = 10;
        for (int i = 0; i < num.length(); i++) {
            soma += Integer.parseInt(num.substring(i, i + 1)) * peso--;
        }

        if (soma % 11 == 0 | soma % 11 == 1) {
            primDig = new Integer(0);
        } else {
            primDig = new Integer(11 - (soma % 11));
        }

        soma = 0;
        peso = 11;
        for (int i = 0; i < num.length(); i++) {
            soma += Integer.parseInt(num.substring(i, i + 1)) * peso--;
        }

        soma += primDig.intValue() * 2;
        if (soma % 11 == 0 | soma % 11 == 1) {
            segDig = new Integer(0);
        } else {
            segDig = new Integer(11 - (soma % 11));
        }

        return primDig.toString() + segDig.toString();
    }
}
