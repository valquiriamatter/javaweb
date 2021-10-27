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

public class CadastraTarefaForm implements Acao{

	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// efetua o redirecionamento
		return "forward:formCadastraTarefa.jsp";

		

	}

}
