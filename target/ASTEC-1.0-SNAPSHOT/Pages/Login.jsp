<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<link rel="stylesheet" type="text/css" href="../Styles/Login.css">
	<title>Login</title>
</head>
<body>
	<div class="application-container">
		<div class="login-block">
			<div class="login-title">IMOBILIÁRIA AQUAMARINE</div>
			<div class="inputs-container">
				<div class="form-box-container">
					<label>Login:</label>
					<input type="text" name="username">
				</div>
				<div class="form-box-container">
					<label>Senha:</label>
					<input type="text" name="senha">
				</div>
				<div class="form-button">
					<button type="submit">Entrar</button>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
