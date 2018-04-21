<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="../Styles/Login.css">
	<link rel="stylesheet" type="text/css" href="../Styles/Cadastros.css">
	<meta charset="utf-8">
	<title>Cadastro de Imóveis</title>
</head>
<body>
	<div class="application-container">
		<div class="form-container">
			<div class="form-header">CADASTRO DE IMÓVEIS</div>
			<div class="form-content">
				<div class="form-block">
				<label>Nome:</label>
				<input type="text" >
				<label>Endereço:</label>
				<input type="text" >
				<label>Descrição:</label>
				<input type="text" >
			</div>
			<div class="form-block-row">
				<div>
					<p>Nº Dorm:</p>
					<input class="spinner" type="number" >
				</div>
				<div>
					<p>Tamanho:</p>
					<input type="text" >
				</div>
				<div>
					<p>Vagas:</p>
					<input class="spinner" type="number" >
				</div>
			</div>
			<div class="form-block">
				<label>Andar:</label>
				<input type="text" >
				<label>Mobiliado:</label>
				<input type="text" >
				<label>Aceita pets:</label>
				<input type="text" >
			</div>
			<div class="form-block">
				<label>Aluguel/Compra:</label>
				<input type="text" >
				<label>Condominio:</label>
				<input type="text" >
				<label>IPTU:</label>
				<input type="text" >
				<label>Seguro:</label>
				<input type="text" >
			</div>
			</div>
			<div class="form-button">
				<button>Salvar</button>
			</div>
		</div>
	</div>
</body>
</html>
