package controller.actions.colaborador;

import java.io.IOException;

import javax.persistence.EntityManager;

import controller.actions.Acao;
import factory.JPAUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Usuario;
import model.dao.UsuarioDao;

public class Login implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String login = request.getParameter("login");
		String senha = request.getParameter("senha");

		System.out.println("Logando... " + login);

		EntityManager entityManager = JPAUtil.getEntityManager();

		// Banco banco = new Banco();
		UsuarioDao usuarioDao = new UsuarioDao(entityManager);
		// Usuario usuario = banco.existeUsuario(login,senha);
		Usuario usuario = usuarioDao.existeUsuario(login, senha);

		if (usuario != null) {
			System.out.println("Usuario existe!");

			// para pegar o objeto que session que contem o número da requisicao que
			// identifica o usuario
			HttpSession sessao = request.getSession();
			// seta o atributo na sessao
			sessao.setAttribute("usuarioLogado", usuario);
			return "redirect:entrada?acao=ListaColaborador";

		} else {
			
			System.out.println("\n Usuario incorreto.");
			return "redirect:entrada?acao=LoginForm";
		}

	}

}
