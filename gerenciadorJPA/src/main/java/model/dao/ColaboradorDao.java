package model.dao;

import javax.persistence.EntityManager;

import model.Colaborador;

import java.util.List;

public class ColaboradorDao {
	
    private EntityManager entityManager;

    //inje�ao de dependencia
    public ColaboradorDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Colaborador colaborador){
        this.entityManager.persist(colaborador);
    }

    public void update(Colaborador colaborador){
        this.entityManager.merge(colaborador);
    }

    public void delete(Colaborador colaborador){
        colaborador = entityManager.merge(colaborador);
        this.entityManager.remove(colaborador);
    }

    public Colaborador findById(int id){
        return entityManager.find(Colaborador.class, id);
    }

    public List<Colaborador> findAll(){
        String jpql = "SELECT c from Colaborador c";
        return entityManager.createQuery(jpql, Colaborador.class).getResultList();
    }





}
