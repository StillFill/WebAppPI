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
            Função
          </div>
          <div class="table-header-cell">
            Comissão
          </div>
        </div>
        <div class="table-body">
          <div class="table-row">
            <div class="row-cell">Mauricio Gregorio</div>
            <div class="row-cell">Vendedor</div>
            <div class="row-cell">12%</div>
          </div>
          <div class="table-row">
            <div class="row-cell">Mauricio Gregorio</div>
            <div class="row-cell">Vendedor</div>
            <div class="row-cell">12%</div>
          </div>
          <div class="table-row">
            <div class="row-cell">Mauricio Gregorio</div>
            <div class="row-cell">Vendedor</div>
            <div class="row-cell">12%</div>
          </div>
          <div class="table-row">
            <div class="row-cell">Mauricio Gregorio</div>
            <div class="row-cell">Vendedor</div>
            <div class="row-cell">12%</div>
          </div>
        </div>
      </div>
    </div>
  </div>
</body>
</html>
