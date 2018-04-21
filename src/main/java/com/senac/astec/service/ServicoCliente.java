    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senac.astec.service;
import com.senac.astec.dao.ClienteDAO;
import com.senac.astec.model.Cliente;
import java.io.IOException;
import java.util.List;
//Classe de servico do cliente
public class ServicoCliente {
     ClienteDAO clienteDAO = new ClienteDAO();
     

    public void cadastrarCliente(Cliente cliente) throws IOException, Exception {

        try {
            clienteDAO.inserirCliente(cliente);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Atualiza um cliente na fonte de dados
    public void atualizarCliente(Cliente cliente) throws IOException, Exception {
        
        //ValidadorCliente.validar(cliente);

        try {
            clienteDAO.updateCliente(cliente);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Realiza a pesquisa de um cliente por nome na fonte de dados
    public List<Cliente> procurarCliente(String nome, int codigoempresa) throws IOException, Exception {
        try {
            return clienteDAO.listarCliente(nome, codigoempresa);
            
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    //Realiza a pesquisa de um cliente por nome na fonte de dados
    public Cliente obterClientePorCpf(String cpf, int codigoempresa) throws IOException, Exception {
        try {
            if (cpf.length() == 0) {
                throw new Exception("Campo cpf vazio!");
            } else {
                return clienteDAO.encontrarClientePorCpf(cpf, codigoempresa);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    //Realiza a pesquisa de um cliente por nome na fonte de dados
    public Cliente obterClientePorCodigo(int codigo, int codigoempresa) throws IOException, Exception {
        try {
          
                return clienteDAO.encontrarClientePorIdCarrinho(codigo, codigoempresa);
         
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    //Exclui o cliente com ID informado do mock
    public void excluirCliente(String cpf, int codigoempresa) throws IOException, Exception {
        try {
            //Solicita ao DAO a exclusão do cliente informado
            clienteDAO.deletarCliente(cpf, codigoempresa);
        } catch (Exception e) {
            //Imprime qualquer erro técnico no console e devolve
            //uma exceção e uma mensagem amigável a camada de visão
            e.printStackTrace();
            
        }
    }
    
    //Lista produtos de determinada empresa
    public List<Cliente> listarClientes(int codigoempresa) throws IOException, Exception {
        try {
            return clienteDAO.listarClientes(codigoempresa);
            
        } catch (Exception e) {
            e.printStackTrace();
            
            return null;
        }
    }
    
        //Lista produtos de determinada empresa
    public List<Cliente> listarclientestotais() throws IOException, Exception {
        try {
            return clienteDAO.listarClientestotais();
            
        } catch (Exception e) {
            e.printStackTrace();
            
            return null;
        }
    }
}
