package controller.actions;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;



public interface Acao {
	

	String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
	
	
	
}
