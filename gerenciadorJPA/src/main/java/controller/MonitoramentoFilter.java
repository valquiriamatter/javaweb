package controller;

import java.io.IOException;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

//@WebFilter("/entrada")
public class MonitoramentoFilter implements Filter{

	//HttpServletRequest � um ServletRequest(interface)
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		System.out.println("Monitoramento Filter");
		
		long antes = System.currentTimeMillis();
		
		//executa a acao
		//segue pra frente, parecido com o forward, v�, continue
		//diferenca do servlet x filter, o filter vc pode parar execu��o
		chain.doFilter(request, response);
		
		String acao = request.getParameter("acao");
		
		long depois = System.currentTimeMillis();
		
		System.out.println("\n Tempo de execu��o: " + acao + " -> " + (depois - antes) + " milisegundos.");
		System.out.println();
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void destroy() {

	}
}
