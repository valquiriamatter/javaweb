package model.dao;

import java.util.List;

import javax.persistence.EntityManager;

import model.Usuario;

public class UsuarioDao {
	
    private EntityManager entityManager;

    //injeçao de dependencia
    public UsuarioDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Usuario usuario){
        this.entityManager.persist(usuario);
    }

    public void update(Usuario usuario){
        this.entityManager.merge(usuario);
    }

    public void delete(Usuario usuario){
        usuario = entityManager.merge(usuario);
        this.entityManager.remove(usuario);
    }

    public Usuario findById(int id){
        return entityManager.find(Usuario.class, id);
    }

    public List<Usuario> findAll(){
        String jpql = "SELECT u from Usuario u";
        return entityManager.createQuery(jpql, Usuario.class).getResultList();
    }

    
    //aqui?
    //metodo para verificar se existe o usuario
    public Usuario existeUsuario(String login, String senha) {
    	
    	List<Usuario> listaUsuarios = findAll(); 
    	
    	for(Usuario usuario : listaUsuarios) {
    		if(usuario.ehIgual(login, senha)) {
    			return usuario; 
    		}
    	}
    	
    	return null;
    	
    }




}
