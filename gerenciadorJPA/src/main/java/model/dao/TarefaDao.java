package model.dao;

import javax.persistence.EntityManager;

import model.Tarefa;

import java.util.List;

public class TarefaDao {
	
    private EntityManager entityManager;

    //injeçao de dependencia
    public TarefaDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Tarefa tarefa){
        this.entityManager.persist(tarefa);
    }

    public void update(Tarefa tarefa){
        this.entityManager.merge(tarefa);
    }

    public void delete(Tarefa tarefa){
        tarefa = entityManager.merge(tarefa);
        this.entityManager.remove(tarefa);
    }

    public Tarefa findById(int id){
        return entityManager.find(Tarefa.class, id);
    }

    public List<Tarefa> findAll(){
        String jpql = "SELECT t from Tarefa t";
        return entityManager.createQuery(jpql, Tarefa.class).getResultList();
    }





}
