<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix = "fmt"%>

<c:url value="/entrada" var= "linkEntradaServlet"/>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Title</title>



</head>
<body>

<c:import url="logoutParcial.jsp"/>


	<form action=${linkEntradaServlet} method="post">

		Colaborador 
		<br><br>
		Nome: <input type="text" name="nome" value= "${colaborador.nomeColaborador}" />
		<br>
		Data Nascimento: <input type="text" name="data" value= "<fmt:formatDate value="${colaborador.dataNascimento}" pattern="dd/MM/yyyy"/>"/>
		<input type="hidden" name="id" value= "${colaborador.idColaborador}" />
		<input type="hidden" name="acao" value= "AlteraColaborador"/>
		
		<input type="submit" />

		<br><br>
		<a href="/gerenciador"> Voltar </a>


	</form>


</body>
</html>