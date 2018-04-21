    /*
    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senac.astec.service;
import com.senac.astec.dao.UsuarioDAO;
import com.senac.astec.model.Cliente;
import com.senac.astec.model.Usuario;
import java.io.IOException;
import java.util.List;
//Classe de servico do cliente
public class ServicoUsuario {
     UsuarioDAO usuarioDAO = new UsuarioDAO();
     

    public void cadastrarUsuario(Usuario usuario) throws IOException, Exception {


        try {
            usuarioDAO.inserirUsuario(usuario);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Atualiza um cliente na fonte de dados
    public void atualizarUsuario(int codigo, int codigoempresa, int codigoperfil, String nome, String login, String senha) throws IOException, Exception {
        
        //ValidadorCliente.validar(cliente);

        try {
            usuarioDAO.updateUsuario(codigo, codigoempresa, codigoperfil, nome, login, senha);
        } catch (Exception e) {
            //Imprime qualquer erro técnico no console e devolve
            //uma exceção e uma mensagem amigável a camada de visão
            e.printStackTrace();
        }
    }

    //Realiza a pesquisa de um cliente por nome na fonte de dados
    public List<Usuario> listarUsuarios(String nome, int empresa) throws IOException, Exception {
        try {
            return usuarioDAO.listarUsuario(nome, empresa);
            
        } catch (Exception e) {
            e.printStackTrace();
            return null;
            
        }
    }
    
    //Pesquisa usuario especificado 
    public Usuario retornaUsuario(int codigousuario, int empresa) throws IOException{
        try {
            return usuarioDAO.encontrarUmUsuario(codigousuario, empresa);
            
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    //Pesquisa usuario especificado por login para saber se já existe
    public boolean retornaUsuario(String login, int empresa) throws IOException{
        try {
            return usuarioDAO.encontrarUsuarioNome(login, empresa);
            
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    //Pesquisa usuario por login e senha 
    public Usuario retornaUsuarioLogin(String login, String senha, int empresa) throws IOException{
        try {
            return usuarioDAO.encontrarUsuario(login, senha, empresa);
            
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //Exclui o cliente com ID informado do mock
    public void excluirUsuario(int codigo, int  codigoempresa) throws IOException, Exception {
        try {
            //Solicita ao DAO a exclusão do cliente informado
            usuarioDAO.deletarUsuario(codigo, codigoempresa);
        } catch (Exception e) {
            //Imprime qualquer erro técnico no console e devolve
            //uma exceção e uma mensagem amigável a camada de visão
            e.printStackTrace();
        }
    }
}
