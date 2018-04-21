<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="../Styles/Consultas.css">
	<meta charset="utf-8">
	<title>Consultar Imóveis</title>
</head>
<body>
  <div class="app-container">
    <div style="width: 75%;">
      <div class="filter-container">
        <input placeholder="Pesquisar imóveis" type="text">
      </div>
      <div class="table-container">
        <div class="table-row header">
          <div class="table-header-cell">
            Nome
          </div>
          <div class="table-header-cell">
            Endereço
          </div>
          <div class="table-header-cell">
            Vendedor
          </div>
          <div class="table-header-cell">
            Cliente
          </div>
          <div class="table-header-cell">
            Preço
          </div>
          <div class="table-header-cell">
            Data
          </div>
        </div>
        <div class="table-body">
          <div class="table-row">
            <div class="row-cell">Apartamento 1</div>
            <div class="row-cell">Rua Gameleira, 128</div>
            <div class="row-cell">Franciele</div>
            <div class="row-cell">Rogério</div>
            <div class="row-cell">R$ 3000,00</div>
            <div class="row-cell">12/08</div>
          </div>
          <div class="table-row">
            <div class="row-cell">Apartamento 2</div>
            <div class="row-cell">Rua Alameda, 562</div>
            <div class="row-cell">Franciele</div>
            <div class="row-cell">Rogério</div>
            <div class="row-cell">R$ 3000,00</div>
            <div class="row-cell">12/08</div>
          </div>
          <div class="table-row">
            <div class="row-cell">Apartamento 3</div>
            <div class="row-cell">Rua Peregrino, 227</div>
            <div class="row-cell">Franciele</div>
            <div class="row-cell">Rogério</div>
            <div class="row-cell">R$ 3000,00</div>
            <div class="row-cell">12/08</div>
          </div>
          <div class="table-row">
            <div class="row-cell">Apartamento 4</div>
            <div class="row-cell">Rua Fernandes, 1032</div>
            <div class="row-cell">Franciele</div>
            <div class="row-cell">Rogério</div>
            <div class="row-cell">R$ 3000,00</div>
            <div class="row-cell">12/08</div>
          </div>
        </div>
      </div>
    </div>
  </div>
</body>
</html>
