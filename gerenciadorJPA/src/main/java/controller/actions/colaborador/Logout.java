package controller.actions.colaborador;

import java.io.IOException;

import controller.actions.Acao;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class Logout implements Acao{

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession sessao = request.getSession();
		
		//só remove o atributo, o objeto e cookie continuam em memoria
		//sessao.removeAttribute("usuarioLogado"); 
		
		//remove objeto e cookie
		sessao.invalidate();
		
		return "redirect:entrada?acao=LoginForm";
		
	}

	
	
}
