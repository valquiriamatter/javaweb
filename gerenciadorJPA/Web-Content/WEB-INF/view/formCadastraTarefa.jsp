<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:url value="/entrada" var="linkTarefa" />

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Cadastro de Tarefa</title>
</head>
<body>

<c:import url="logoutParcial.jsp"/>

	<div class="container">
		<form action=${linkTarefa} method="post">
		
			Tarefa <br>
			<br> Colaborador: <input type="text" name="colaborador" /> <br> 
			<br> Descrição: <input type="text" name="descricao" /> <br> 
			<br> Data de Inicio: <input type="text" name="dataInicio" /> <br> 
			<br> Data de Fim: <input type="text" name="dataFim" /> <br>  
			<br> Status: <input type="text" name="status" /> <br> 
			<br> Prioridade: <input type="text" name="prioridade" /> <input type="submit" />
			
			<input type="hidden" name="idColaborador" value= "${colaborador.idColaborador}" />
			
			<br><br>
			
			<a href="/gerenciador"> Voltar </a>
			
		</form>
	</div>

</body>
</html>