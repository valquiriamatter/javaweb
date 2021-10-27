package controller.actions.colaborador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.persistence.EntityManager;

import controller.actions.Acao;
import factory.JPAUtil;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Colaborador;
import model.Tarefa;
import model.dao.ColaboradorDao;
import model.dao.TarefaDao;

public class ListaTarefa implements Acao {

	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		EntityManager entityManager = JPAUtil.getEntityManager();
		
		TarefaDao tarefaDao = new TarefaDao(entityManager);
		List<Tarefa> listaTarefas = tarefaDao.findAll();
		
		// pega o objeto para escrever caracteres do lado do client
		PrintWriter out = response.getWriter();

		//pendura os atributos na requisicao
		request.setAttribute("listaTarefas", listaTarefas);
		
		return "forward:listaTarefa.jsp";
	}
	
	
	
	
}
