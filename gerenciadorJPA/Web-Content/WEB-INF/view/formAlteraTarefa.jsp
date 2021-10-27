<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix = "fmt"%>

<c:url value="/alteraTarefa" var= "linkTarefa"/>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Cadastro de Tarefa</title>

</head>
<body>

	<form action=${linkTarefa} method="post">

		Tarefa
		<br><br>
		Colaborador: <input type="text" name="nome" value= "${colaborador.nomeColaborador}" />
		<br>
		Descrição: <input type="text" name="descricao" value= "${tarefa.descricao}" />
		<br>
		Data Inicio: <input type="text" name="dataInicio" value= "<fmt:formatDate value="${tarefa.dataInicio}" pattern="dd/MM/yyyy"/>"/>
		<br>
		Data Fim: <input type="text" name="dataFim" value= "<fmt:formatDate value="${tarefa.dataFim}" pattern="dd/MM/yyyy"/>"/>
		<br>
		Status: <input type="text" name="status" value= "${tarefa.status}" />
		<br>
		Prioridade: <input type="text" name="prioridade" value= "${tarefa.prioridade}" />
		<input type="hidden" name="id" value= "${tarefa.idColaborador}" />
		<input type="submit" />


		<br><br>
		<a href="/gerenciador"> Voltar </a>


	</form>


</body>
</html>