package br.com.fiap.cp.dao.impl;

import br.com.fiap.cp.dao.HibernateGenericDAO;
import br.com.fiap.cp.dao.PersistenceManager;
import br.com.fiap.cp.entity.Livro;

public class LivroDAOImpl extends HibernateGenericDAO<Livro, Long> {
    private static LivroDAOImpl instance = null;

    private LivroDAOImpl(){
        super(Livro.class);
    }

    public static LivroDAOImpl getInstance(){
        if(instance==null){
            instance = new LivroDAOImpl();
        }
        return instance;
    }
}
