package controller.actions.colaborador;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.EntityManager;

import controller.actions.Acao;
import factory.JPAUtil;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Colaborador;
import model.dao.ColaboradorDao;

public class MostraColaborador implements Acao {

	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("Chamou o Mostra Colaborador");

		EntityManager entityManager = JPAUtil.getEntityManager();

		Integer id = Integer.valueOf(request.getParameter("id"));
		System.out.println(id);

		ColaboradorDao colaboradorDao = new ColaboradorDao(entityManager);
		Colaborador colaborador = colaboradorDao.findById(id);

		System.out.println(colaborador);

		// pendura o colaborador na requisao
		request.setAttribute("colaborador", colaborador);

		// mensagem do lado do servidor
		System.out.println("Mostrando Colaborador: " + colaborador);

		//retorna a String com nova url
		return "forward:formAlteraColaborador.jsp";
	}

}
