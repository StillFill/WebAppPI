
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senac.astec.servlet;

import com.senac.astec.model.Imovel;
import com.senac.astec.service.ServicoProduto;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ConsultaProdutoServlet", urlPatterns = {"/consultaprodutos"})
public class ConsultaProdutoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
          HttpSession sessao = request.getSession();
          ArrayList<Imovel> Lista = new ArrayList();
          ServicoProduto sp = new ServicoProduto();
          String codigoempresa = (String) sessao.getAttribute("Empresa");
          
          try {
            Lista = (ArrayList<Imovel>) sp.procurarProduto("", Integer.parseInt(codigoempresa));
        } catch (Exception e) {
        }   
          sessao.setAttribute("ListaProdutos", Lista);
          
          RequestDispatcher dispatcher
	    = request.getRequestDispatcher("/consultarProduto.jsp");
    dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Instância Objeto Fornecedor
        Imovel c = new Imovel();
        
        //Instância de ArrayList para acumular fornecedores
        ArrayList<Imovel> Lista = new ArrayList();
        
        //Instância serviço de servidor para efetuar consulta e ligação com FornecedorDAO
        ServicoProduto sp = new ServicoProduto();
        
        //Criação se sessão para retorno em tela
        HttpSession sessao = request.getSession();
        
        //Atribuição de valores digitados na tela de fornecedor e código da empresa
        String produto = request.getParameter("produto").toLowerCase();
        String codigoempresa = (String) sessao.getAttribute("Empresa");
        
        try {
            Lista = (ArrayList<Imovel>) sp.procurarProduto(produto, Integer.parseInt(codigoempresa));
        } catch (Exception e) {
        }
        sessao.setAttribute("ListaProdutos", Lista);
        response.sendRedirect(request.getContextPath() + "/consultarProduto.jsp");   
        
    }

}
