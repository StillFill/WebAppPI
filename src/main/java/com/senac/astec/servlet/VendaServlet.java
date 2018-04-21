/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senac.astec.servlet;

import com.senac.astec.model.Cliente;
import com.senac.astec.model.ItemVenda;
import com.senac.astec.model.Imovel;
import com.senac.astec.model.Venda;
import com.senac.astec.service.ServicoCliente;
import com.senac.astec.service.ServicoItemVenda;
import com.senac.astec.service.ServicoProduto;
import com.senac.astec.service.ServicoVenda;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "VendaServlet", urlPatterns = {"/finalizarvenda"})
public class VendaServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        HttpSession sessao = request.getSession();
        ServicoVenda sv = new ServicoVenda();
        ServicoItemVenda siv = new ServicoItemVenda();
        ServicoProduto sp = new ServicoProduto();
        ServicoCliente scli = new ServicoCliente();
        
        String codigocarrinho = request.getParameter("codigocarrinho");
        String codigoempresa = (String) sessao.getAttribute("Empresa");
        
        ItemVenda itemvenda = new ItemVenda();
        Venda venda = new Venda();
        Cliente cliente = new Cliente();
        
        List<Imovel> listaprodutos = new ArrayList<Imovel>();
        List<Cliente> listaclientes = new ArrayList<Cliente>();
        
        try {

            
            //Lista todos os produtos da empresa
            listaprodutos = sp.listarProdutos(Integer.parseInt(codigoempresa));
            
            Date data = new Date();
            java.sql.Date datasql = new java.sql.Date(data.getTime());
            
            //Atribuindo valores do carrinho para a venda
            venda.setData(datasql);
            venda.setEmpresa(Integer.parseInt(codigoempresa));
            
            //Cadastro de Cabeçario de Venda
            int codigovenda = sv.cadastrarVenda(venda);
            venda.setCodigo(codigovenda);
            
            //Retorna Cliente da Venda
            cliente = scli.obterClientePorCodigo(venda.getCliente(), Integer.parseInt(codigoempresa));
            
        } catch (Exception e) {
        }
        
        sessao.setAttribute("venda", venda);
        sessao.setAttribute("clientevenda", cliente);
        sessao.removeAttribute("codigocarrinho");
        
        response.sendRedirect(request.getContextPath() + "/finalizarVenda.jsp");
    }

}
