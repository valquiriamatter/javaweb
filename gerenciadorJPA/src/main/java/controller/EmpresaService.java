package controller;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.persistence.EntityManager;

import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;

import controller.actions.Acao;
import factory.JPAUtil;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Colaborador;
import model.dao.ColaboradorDao;

@WebServlet(urlPatterns = "/empresas")
public class EmpresaService extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		EntityManager entityManager = JPAUtil.getEntityManager();
		
		ColaboradorDao colaboradorDao = new ColaboradorDao(entityManager);
		List<Colaborador> listaColaboradores = colaboradorDao.findAll();
				
		String valor = request.getHeader("accept");
		
		if(valor.endsWith("xml")) {

			//devolvendo a lista em um XML
			XStream xstream = new XStream();
			xstream.alias("colaborador", Colaborador.class);
			String xml = xstream.toXML(listaColaboradores);
			
			response.setContentType("application/json");
			response.getWriter().print(xml);
			
		}else if(valor.endsWith("json")){
			
			//devolvendo a lista em um JSON 
			Gson gson = new Gson();
			String json = gson.toJson(listaColaboradores);
			
			response.setContentType("application/json");
			response.getWriter().print(json);
			
		}else {
			response.setContentType("application/json");
			response.getWriter().print("{'message': 'no content'");
		}
		
		
		

		

	}

}
