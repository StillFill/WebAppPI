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
			<div class="form-header">CADASTRO DE FUNCIONÁRIOS</div>
			<div class="form-content">
				<div class="form-block-row">
          <div>
            <label>Nome:</label>
            <input type="text"  >
          </div>
          <div>
            <label>Função</label>
            <select>
              <option value="volvo">Vendedor</option>
              <option value="saab">Gerente</option>
            </select>
          </div>
					<div>
						<label>Comissão:</label>
						<input type="text" >
					</div>
  			</div>
  			<div class="form-block-row">
          <div>
            <label>Login:</label>
            <input type="text" >
          </div>
          <div>
            <label>Senha:</label>
            <input type="text" >
          </div>
  			</div>
  			</div>
  			<div class="form-button">
  				<button>Salvar</button>
  			</div>
		</div>
	</div>
</body>
</html>
