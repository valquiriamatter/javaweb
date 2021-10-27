package controller.actions.colaborador;

import java.io.IOException;

import javax.persistence.EntityManager;

import controller.actions.Acao;
import factory.JPAUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Colaborador;
import model.dao.ColaboradorDao;

public class RemoveTarefa implements Acao {

	public String executa(HttpServletRequest request, HttpServletResponse response) throws IOException {

		EntityManager entityManager = JPAUtil.getEntityManager();

		System.out.println("Chamou o Servlet Remove Empresa");

		Integer id = Integer.valueOf(request.getParameter("id"));
		System.out.println(id);

		ColaboradorDao colaboradorDao = new ColaboradorDao(entityManager);
		Colaborador colaborador = colaboradorDao.findById(id);

		// inicia a transacao com o BD
		entityManager.getTransaction().begin();
		colaboradorDao.delete(colaborador);

		// comita
		entityManager.getTransaction().commit();

		// mensagem do lado do servidor
		System.out.println("Removendo Colaborador: " + id);
		
		System.out.println("Colaborador Removido");	
		
		//retorna a String de redirecionamento para o Servlet Controller
		return "redirect:entrada?acao=ListaColaborador";
		
		

	}

}
