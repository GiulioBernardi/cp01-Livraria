package br.com.fiap.cp.dao;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.List;

public interface GenericDAO <T extends Serializable, PK extends Serializable> {
    void salvar(T entidade, EntityManager entityManager);
    void atualizar(T entidade, EntityManager entityManager);
    void remover(PK id, EntityManager entityManager);
    T obterPorId(PK id, EntityManager entityManager);
    List<T> listar(EntityManager entityManager);
}
