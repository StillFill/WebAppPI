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
                    <form action = "CadastroClientes" method = "GET">
			<div class="form-header">CADASTRO DE CLIENTES</div>
			<div class="form-content">
				<div class="form-block-row">
                            <div>
                              <label>Nome:</label>
                              <input type="text" >
                            </div>
                            <div>
                              <label>Telefone principal</label>
                              <input type="text" >
                            </div>
                            <div>
                              <label>Telefone secundário</label>
                              <input type="text" >
                            </div>
  			</div>
  			<div class="form-block-row">
          <div>
            <label>Email:</label>
            <input type="text" >
          </div>
          <div>
            <label>CPF(opcional):</label>
            <input type="text" >
          </div>
          <div>
            <label>Gênero:</label>
            <input type="text" >
          </div>
  			</div>
  			</div>
  			<div class="form-button">
                            <button type="submit">Salvar</button>
  			</div>
                    </form>
		</div>
	</div>
</body>
</html>
