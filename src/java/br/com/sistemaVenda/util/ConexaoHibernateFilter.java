package br.com.sistemaVenda.util;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class ConexaoHibernateFilter implements Filter {

    private SessionFactory sf;

    @Override
    public void init(FilterConfig config) throws ServletException {
        //Executado inicialmente 
        this.sf = HibernateUtil.getSessionFactory(); // atribuir o get session
    }

    @Override
    public void doFilter(ServletRequest serveletFilter, ServletResponse serveletResponse,
            FilterChain chain) throws IOException, ServletException {
        try {
            this.sf.getCurrentSession().beginTransaction(); // Pego a conexao eComeçou a transação
            chain.doFilter(serveletFilter, serveletResponse); // processo interno
            this.sf.getCurrentSession().getTransaction().commit();// comitou a transação para funcionar no banco
            this.sf.getCurrentSession().close();
        } catch (Throwable ex) {
            try {
                if(this.sf.getCurrentSession().getTransaction().isActive()){ 
                    /*Se caso der erro na linha 29 onde comita, cai no cath, onde cai no Try novamente
                    Para verficar, se estiver já ativo ele da um roolback como se desligasse e começasse dnv e joga
                    a exessão no Servelet expetion*/
                    this.sf.getCurrentSession().getTransaction().rollback(); // Voltar a atras 
                }
            } catch (Throwable e) {
                e.printStackTrace();
            }
            throw  new ServletException(ex.getMessage());
        }

    }

    @Override
    public void destroy() {
        
    }
    //Filtro implementa um

}
