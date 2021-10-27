<%@ page import = "java.util.List, model.Tarefa" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix = "fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista de Tarefas</title>
</head>
<body>

		<c:if test= "${not empty descricao}">
			Tarefa ${ descricao } Cadastrada com Sucesso!
		</c:if> 
		
		<br><br>


		Lista de Tarefas: <br/>
	
	<!-- JSTL -->	
		<ul>
		<c:forEach items="${listaTarefas}" var="listaTarefas">
			<li>${tarefa.descricao} - <fmt:formatDate value="${tarefa.dataInicio}" pattern="dd/MM/yyyy" /> 
			<a href = "/gerenciador/mostraTarefa?id=${tarefa.idColaborador}"> Alterar </a>
			<a href = "/gerenciador/removeTarefa?id=${tarefa.idColaborador}"> Remover </a>
			</li>
		</c:forEach>
		</ul>
		
		<br><br>
		<a href="/gerenciador"> Voltar </a>
		
	<!-- JSP com Scriplets -->		
	<!-- <ul> -->
	<%-- List<Colaborador> listaColaboradores = (List<Colaborador>) request.getAttribute("listaColaboradores");
	<%-- for (Colaborador colaborador : listaColaboradores) --%>
	<%-- <li><%= colaborador.getNomeColaborador() %></li> --%>
	<%-- <% } %> --%>
		

</body>
</html>