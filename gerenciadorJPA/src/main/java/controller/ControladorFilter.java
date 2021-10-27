package controller;

import java.io.IOException;

import controller.actions.Acao;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

//@WebFilter("/entrada")
public class ControladorFilter implements Filter {

	//SpringMVC, VRaptor tbm usam filtros, mas chamam de interceptadores, por isso esse conceito щ fundamental
	
	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException {

		System.out.println("Controlador Filter");

		// casting para a classe mais especifica, HttpServletRequest щ um ServetResquest
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;

		// pega o parametro pra saber qual aчуo vai chamar
		String acaoParametro = request.getParameter("acao");
		System.out.println(acaoParametro);

		// pega o nome da classe, pois щ o mesmo da acao
		String nomeClasse = "controller.actions.colaborador." + acaoParametro;
		System.out.println(nomeClasse);
		String nome;

		try {

			// carrega a classe
			Class classe = Class.forName(nomeClasse);
			// criando o objeto e fazendo o casting
			Acao acao = (Acao) classe.newInstance();
			nome = acao.executa(request, response);

			System.out.println(nome);

		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | ServletException
				| IOException e) {
			throw new ServletException(e);
		}

		// quebra a String usando como separador o : pra diferenciar se щ forward ou
		// send redirect
		String[] tipoEndereco = nome.split(":");

		if (tipoEndereco[0].equals("forward")) {

			// redireciona dentro da mesma requisicao
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/view/" + tipoEndereco[1]);
			requestDispatcher.forward(request, response);
		} else {
			// redireciona
			response.sendRedirect(tipoEndereco[1]);
		}

	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void destroy() {

	}

}
