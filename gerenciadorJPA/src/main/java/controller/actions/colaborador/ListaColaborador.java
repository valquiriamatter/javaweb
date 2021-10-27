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
import model.dao.ColaboradorDao;

public class ListaColaborador implements Acao {

	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		EntityManager entityManager = JPAUtil.getEntityManager();
		
		ColaboradorDao colaboradorDao = new ColaboradorDao(entityManager);
		List<Colaborador> listaColaboradores = colaboradorDao.findAll();
		
		// pega o objeto para escrever caracteres do lado do client
		PrintWriter out = response.getWriter();

		//pendura os atributos na requisicao
		request.setAttribute("listaColaboradores", listaColaboradores);
		
		return "forward:listaColaborador.jsp";
	}
	
	
	
	
}
