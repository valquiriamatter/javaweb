package controller;

import java.io.IOException;
import java.io.PrintWriter;

import controller.actions.Acao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

//@WebServlet(urlPatterns = "/entrada")
public class PrincipalServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		// pega o parametro pra saber qual ação vai chamar
		String acaoParametro = request.getParameter("acao");
		
//		// pega a sessao com o cookie
//		HttpSession sessao = request.getSession();
//
//		//atribui o valor de false se o usuario for null
//		boolean naoLogado = sessao.getAttribute("usuarioLogado") == null;
//		boolean acaoProtegida = !(acaoParametro.equals("Login") || acaoParametro.equals("LoginForm"));
//		
//		
//		if(acaoProtegida && naoLogado) {
//			response.sendRedirect("entrada?acao=LoginForm");
//			//sai
//			return;
//		}

		// pega o nome da classe, pois é o mesmo da acaos
		String nomeClasse = "controller.actions." + acaoParametro;

		String nome;

		try {

			// carrega a classe
			Class classe = Class.forName(nomeClasse);
			// criando o objeto e fazendo o casting
			Acao acao = (Acao) classe.newInstance();
			nome = acao.executa(request, response);

		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | ServletException
				| IOException e) {
			throw new ServletException(e);
		}

		// quebra a String usando como separador o : pra diferenciar se é forward ou
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

//        //variavel que vai guardar qual url deverá redirecionar
//        String nome = null;
//        
//        if(acaoParametro.equals("ListaColaborador")){
//        	
//        	System.out.println("Listando Empresas");
//        	
//        	ListaColaborador acaoLista = new ListaColaborador();
//        	nome = acaoLista.executa(request, response);
//        	
//        }else if(acaoParametro.equals("AlteraColaborador")){
//        	
//        	System.out.println("Alterando Colaborador");
//        	
//        	AlteraColaborador acaoAltera = new AlteraColaborador();
//        	nome = acaoAltera.executa(request, response);
//        	
//        }else if(acaoParametro.equals("RemoveColaborador")){
//        	
//        	System.out.println("Removendo Colaborador");
//        	
//        	RemoveColaborador acaoRemove = new RemoveColaborador();
//        	nome = acaoRemove.executa(request, response);
//        	
//        }else if(acaoParametro.equals("MostraColaborador")){
//        	
//        	System.out.println("Mostrando Colaborador");
//        	
//        	MostraColaborador acaoMostra = new MostraColaborador();
//        	nome = acaoMostra.executa(request, response);	
//        	
//        }else if(acaoParametro.equals("CadastraColaborador")){
//        	
//        	System.out.println("Cadastrando Colaborador");
//        	
//        	CadastraColaborador acaoCadastra = new CadastraColaborador();
//        	nome = acaoCadastra.executa(request, response);	
//        	
//        }else if(acaoParametro.equals("CadastraColaboradorForm")){
//        	
//        	System.out.println("Chamando Formulário de Cadastro");
//        	
//        	CadastraColaboradorForm acaoChamaForm = new CadastraColaboradorForm();
//        	nome = acaoChamaForm.executa(request, response);	
//        }

	}

}
