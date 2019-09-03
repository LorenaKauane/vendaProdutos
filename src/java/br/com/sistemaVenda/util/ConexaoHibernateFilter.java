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
        this.sf = HibernateUtil.getSessionFactory();
    }

    @Override
    public void doFilter(ServletRequest serveletFilter, ServletResponse serveletResponse,
            FilterChain chain) throws IOException, ServletException {
        try {
            this.sf.getCurrentSession().beginTransaction(); 
            chain.doFilter(serveletFilter, serveletResponse); 
            this.sf.getCurrentSession().getTransaction().commit();
            this.sf.getCurrentSession().close();
        } catch (Throwable ex) {
            try {
                if(this.sf.getCurrentSession().getTransaction().isActive()){ 
                    this.sf.getCurrentSession().getTransaction().rollback(); 
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

}
