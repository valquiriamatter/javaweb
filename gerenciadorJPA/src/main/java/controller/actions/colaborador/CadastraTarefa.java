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
import model.Tarefa;
import model.dao.ColaboradorDao;
import model.dao.TarefaDao;

public class CadastraTarefa implements Acao {

	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		EntityManager entityManager = JPAUtil.getEntityManager();

		System.out.println("Chamou o CadastraTarefa");

		String descricao = request.getParameter("descricao");
		String dataInicio = request.getParameter("dataInicio");
		String dataFim = request.getParameter("dataFim");
		String status = request.getParameter("status");
		String prioridade = request.getParameter("prioridade");
		String nomeColaborador = request.getParameter("colaborador");
		
		Integer idColaborador = Integer.valueOf(request.getParameter("idColaborador"));

		Tarefa tarefa = new Tarefa();
		tarefa.setDescricao(descricao);
		tarefa.setStatus(status);
		tarefa.setPrioridade(prioridade);

		Date dataFormatadaInicio, dataFormatadaFim = null;

		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			dataFormatadaInicio = sdf.parse(dataInicio);
			dataFormatadaFim = sdf.parse(dataFim);
			
		} catch (ParseException e) {
			throw new ServletException(e);
		}

		tarefa.setDataInicio(dataFormatadaInicio);
		tarefa.setDataFim(dataFormatadaFim);
		
		ColaboradorDao colaboradorDao = new ColaboradorDao(entityManager);
		
		Colaborador colaborador = colaboradorDao.findById(idColaborador);
		tarefa.setColaborador(colaborador);

		TarefaDao tarefaDao = new TarefaDao(entityManager);
		
		// inicia a transacao com o BD
		entityManager.getTransaction().begin();
		tarefaDao.save(tarefa);

		// comita
		entityManager.getTransaction().commit();

		//recebe a lista das tarefas cadastradas
        List<Tarefa> listaTarefas = tarefaDao.findAll();
        listaTarefas.forEach(t -> System.out.println(t));
        
        //imprime a lista do lado do servidor
        System.out.println(listaTarefas);

        //mensagem do lado do servidor
        System.out.println("Cadastrando nova Tarefa: " + tarefa);

        //pega o objeto para escrever caracteres do lado do client
        PrintWriter out = response.getWriter();

        //efetua o redirecionamento
        response.sendRedirect("listaTarefa");
        
        System.out.println("Tarefa Cadastrada! ");
        
		// efetua o redirecionamento
		return "redirect:entrada?acao=ListaTarefa";

	}

}
