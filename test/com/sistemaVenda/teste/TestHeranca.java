
package com.sistemaVenda.teste;

import br.com.sistemaVenda.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.AfterClass;
import org.junit.BeforeClass;


public abstract class TestHeranca {
    
     //implementar as interfaces 
    private static Session sessao;
    private static Transaction transacao;

    @BeforeClass //Vai ser executado antes de outros test que eu tiver nessa classe 
    public static void abreConexao() {
        sessao = HibernateUtil.getSessionFactory().getCurrentSession(); // abre a sessão 
        transacao = sessao.beginTransaction(); // começa a transação, comit do banco para salvar
    }

    @AfterClass //Esse metodo só vai rodado por ultimo 
    public static void fechaConexao() {

        try {
            transacao.commit();
        } catch (Throwable e) {
            System.out.println("Deu problema no comit: " + e.getMessage());
        } finally {
            try {
                if (sessao.isOpen()) {
                    sessao.close();
                }
            } catch (Exception e2) {
                System.out.println("Deu erro na hora de fechar: " + e2.getMessage());
            }
        }
    }
    
}
