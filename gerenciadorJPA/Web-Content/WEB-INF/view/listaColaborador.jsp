<%@ page import="java.util.List, src.java.model.Colaborador"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Java Standard Taglib</title>
</head>
<body>

	<c:import url="logoutParcial.jsp" />


	Usuário Logado: ${usuarioLogado.login}

	<br>


	<c:if test="${not empty nomeColaborador}">
			Colaborador ${ nomeColaborador } Cadastrado com Sucesso!
		</c:if>

	<br>
	<br> Lista de Colaboradores:
	<br />

	<!-- JSTL -->
	<ul>
		<c:forEach items="${listaColaboradores}" var="colaborador">
			<li>${colaborador.nomeColaborador}-<fmt:formatDate
					value="${colaborador.dataNascimento}" pattern="dd/MM/yyyy" /> <a
				href="/gerenciador/entrada?acao=MostraColaborador&id=${colaborador.idColaborador}">
					Alterar </a> <a
				href="/gerenciador/entrada?acao=RemoveColaborador&id=${colaborador.idColaborador}">
					Remover </a>
			</li>
		</c:forEach>
	</ul>
	<br>
	<br>

	<br>
	<br> Lista de Tarefas:
	<br />

	<ul>
		<c:forEach items="${listaTarefas}" var="tarefa">
			<li>${tarefa.descricao}
			<li>${tarefa.status}
			<li>${tarefa.prioridade}
			
			<fmt:formatDate
					value="${tarefa.dataInicio}" pattern="dd/MM/yyyy" /> 
				
				<fmt:formatDate
					value="${tarefa.dataFim}" pattern="dd/MM/yyyy" /> 	
					
					<a
				href="/gerenciador/entrada?acao=MostraTarefa&id=${tarefa.id}">
					Alterar </a> <a
				href="/gerenciador/entrada?acao=RemoveTarefa&id=${tarefa.id}">
					Remover </a>
			</li>
		</c:forEach>
	</ul>



	<!-- JSP com Scriplets -->
	<!-- <ul> -->
	<%-- List<Colaborador> listaColaboradores = (List<Colaborador>) request.getAttribute("listaColaboradores");
	<%-- for (Colaborador colaborador : listaColaboradores) --%>
	<%-- <li><%= colaborador.getNomeColaborador() %></li> --%>
	<%-- <% } %> --%>


</body>
</html>