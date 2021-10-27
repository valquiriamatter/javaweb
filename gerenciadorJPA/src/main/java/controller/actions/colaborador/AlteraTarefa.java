package controller.actions.colaborador;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.EntityManager;

import controller.actions.Acao;
import factory.JPAUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Colaborador;
import model.dao.ColaboradorDao;

public class AlteraTarefa implements Acao {

	public String executa(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		EntityManager entityManager = JPAUtil.getEntityManager();

		System.out.println("Alterando Colaborador");

		String nome = request.getParameter("nome");
		String data = request.getParameter("data");

		Integer id = Integer.valueOf(request.getParameter("id"));

		Date dataFormatada = null;

		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			dataFormatada = sdf.parse(data);
		} catch (ParseException e) {
			throw new ServletException(e);
		}

		ColaboradorDao colaboradorDao = new ColaboradorDao(entityManager);
		Colaborador colaborador = colaboradorDao.findById(id);
		colaborador.setNomeColaborador(nome);
		colaborador.setDataNascimento(dataFormatada);

		// inicia a transacao com o BD
		entityManager.getTransaction().begin();

		colaboradorDao.update(colaborador);

		// comita
		entityManager.getTransaction().commit();

		// mensagem do lado do servidor
		System.out.println("Alterando Colaborador: " + nome);

		System.out.println(colaboradorDao.findAll());
		System.out.println("Colaborador Alterado!");
		
		return "redirect:entrada?acao=ListaColaborador";

	}

}
