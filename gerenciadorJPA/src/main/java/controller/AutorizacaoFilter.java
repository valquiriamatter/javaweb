package controller;

import java.io.IOException;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebFilter("/entrada")
public class AutorizacaoFilter implements Filter {

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
	
		System.out.println("Autorização Filter");
		
		//casting para a classe mais especifica, HttpServletRequest é um ServetResquest
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		
		// pega o parametro pra saber qual ação vai chamar
		String acaoParametro = request.getParameter("acao");
		
		// pega a sessao com o cookie
		HttpSession sessao = request.getSession();

		//atribui o valor de false se o usuario for null
		boolean naoLogado = sessao.getAttribute("usuarioLogado") == null;
		boolean acaoProtegida = !(acaoParametro.equals("Login") || acaoParametro.equals("LoginForm"));
		
		
		if(acaoProtegida && naoLogado) {
			response.sendRedirect("entrada?acao=LoginForm");
			//sai
			return;
		}
			
		chain.doFilter(request, response);
		
	
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void destroy() {

	}

	
}
