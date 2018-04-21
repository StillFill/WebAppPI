/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senac.astec.servlet;

import com.senac.astec.dao.UsuarioDAO;
import com.senac.astec.service.ServicoUsuario;
import com.senac.astec.model.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ConsultaUsuarioServlet", urlPatterns = {"/consultausuario"})
public class ConsultaUsuarioServlet extends HttpServlet {

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String destino;
        
        HttpSession sessao = request.getSession();
        
        if(sessao.getAttribute("usua") != null){
            destino = "menu.jsp";
        }else{
            sessao.removeAttribute("prod");
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Usuario u = new Usuario();
        
        String login = request.getParameter("usuario").toLowerCase();
        String senha = request.getParameter("senha");
        String empresa = request.getParameter("empresa");
     
        
        Usuario usuario = new Usuario();
        usuario.setLogin(login);
        usuario.setSenha(senha);
        usuario.setCodigoEmpresa(Integer.parseInt(empresa));
        
        try {
            ServicoUsuario servicoUsuario = new ServicoUsuario();
            u = servicoUsuario.retornaUsuario(usuario.getCodigo(), Integer.parseInt(empresa));
            
        } catch (Exception e) {
        }
        
        HttpSession sessao = request.getSession();
        sessao.setAttribute("usua", u);
        
        response.sendRedirect(request.getContextPath() + "/consulta-produto");

    }

}
