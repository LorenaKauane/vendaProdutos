
package com.sistemaVenda.teste;

import br.com.sistemaVenda.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.AfterClass;
import org.junit.BeforeClass;


public abstract class TestHeranca {
    
    private static Session sessao;
    private static Transaction transacao;

    @BeforeClass 
    public static void abreConexao() {
        sessao = HibernateUtil.getSessionFactory().getCurrentSession();
        transacao = sessao.beginTransaction();
    }

    @AfterClass
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
