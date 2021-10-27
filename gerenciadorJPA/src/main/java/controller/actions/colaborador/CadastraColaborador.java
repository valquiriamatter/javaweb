package controller.actions.colaborador;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import controller.actions.Acao;
import factory.JPAUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Colaborador;
import model.dao.ColaboradorDao;

public class CadastraColaborador implements Acao {

	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		EntityManager entityManager = JPAUtil.getEntityManager();

		System.out.println("Chamou o servlet Colaborador");

		String nome = request.getParameter("nome");
		String data = request.getParameter("data");

		Colaborador colaborador = new Colaborador();
		colaborador.setNomeColaborador(nome);

		Date dataFormatada = null;

		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			dataFormatada = sdf.parse(data);
		} catch (ParseException e) {
			throw new ServletException(e);
		}

		colaborador.setDataNascimento(dataFormatada);

		ColaboradorDao colaboradorDao = new ColaboradorDao(entityManager);

		// inicia a transacao com o BD
		entityManager.getTransaction().begin();
		colaboradorDao.save(colaborador);

		// comita
		entityManager.getTransaction().commit();

		// recebe a lista do colaboradores cadastrados
		List<Colaborador> listaColaboradores = colaboradorDao.findAll();
		listaColaboradores.forEach(c -> System.out.println(c));

		// imprime a lista do lado do servidor
		System.out.println(listaColaboradores);

		// mensagem do lado do servidor
		System.out.println("Cadastrando novo Colaborador: " + nome);

		// pega o objeto para escrever caracteres do lado do client
		PrintWriter out = response.getWriter();

		System.out.println("Colaborador Cadastrado! ");
		
		// efetua o redirecionamento
		return "redirect:entrada?acao=ListaColaborador";

		

	}

}
