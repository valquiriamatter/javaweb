<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:url value="/entrada" var= "linkColaborador"/>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Cadastro de Colaborador</title>
</head>
<body>

<c:import url="logoutParcial.jsp"/>


	<div class="container">
		<form action=${linkColaborador} method="post">

			Colaborador <br>
			<br> Nome: <input type="text" name="nome" /> <br> Data
			Nascimento: <input type="text" name="data" /> <input type="submit" />
			<input type="hidden" name="acao" value= "CadastraColaborador"/>
			
			<br><br>
			<a href="/entrada"> Voltar </a>

		</form>
	</div>

</body>
</html>