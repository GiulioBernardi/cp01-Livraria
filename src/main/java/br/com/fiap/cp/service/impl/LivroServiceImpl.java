package br.com.fiap.cp.service.impl;

import br.com.fiap.cp.dao.impl.LivroDAOImpl;
import br.com.fiap.cp.entity.Livro;
import br.com.fiap.cp.service.GenericService;

import java.util.List;

public class LivroServiceImpl extends GenericService<Livro, Long> {
    private static LivroServiceImpl instance = null;
    private LivroDAOImpl LivroDAO;

    private LivroServiceImpl(){
        this.LivroDAO = LivroDAOImpl.getInstance();
    }

    public static LivroServiceImpl getInstance(){
        if(instance == null){
            instance = new LivroServiceImpl();
        }
        return instance;
    }


    @Override
    public void cadastrar(Livro entidade) {
        try{
            LivroDAO.salvar(entidade, getEntityManager());
        }catch (Exception e){
            getEntityManager().getTransaction().rollback();
            System.out.println("Problema em salvar livro");
        }finally {
            closeEntityManager();
        }
    }

    @Override
    public void atualizar(Livro entidade) {
        try{
            LivroDAO.atualizar(entidade, getEntityManager());
        }catch (Exception e){
            getEntityManager().getTransaction().rollback();
            System.out.println("Problema em atualizar livro");
        }finally {
            closeEntityManager();
        }
    }

    @Override
    public void remover(Long id) {
        try{
            LivroDAO.remover(id, getEntityManager());
        }catch (Exception e){
            getEntityManager().getTransaction().rollback();
            System.out.println("Problema em remover livro");
        }finally {
            closeEntityManager();
        }
    }

    @Override
    public Livro obter(Long id) {
        Livro livro = null;
        try{
            LivroDAO.obterPorId(id, getEntityManager());
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            closeEntityManager();
        }
        return livro;
    }

    @Override
    public List<Livro> listar() {
        List<Livro> livros = null;
        try{
            livros = LivroDAO.listar(getEntityManager());
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            closeEntityManager();
        }
        return livros;
    }
}


