<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:url value="/entrada" var= "linkColaborador"/>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Cadastro de Colaborador</title>
</head>
<body>


	<div class="container">

		<form action=${linkColaborador} method="post">

			Usuário <br><br>
			
			Login: <input type="text" name="login" /> <br>
			Senha: <input type="password" name="senha" /> <input type="submit" />
			
			<input type="hidden" name="acao" value= "Login"/>
			
			<br><br>
			<a href="/entrada"> Voltar </a>

		</form>
	</div>

</body>
</html>