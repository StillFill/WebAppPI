/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senac.astec.service;
import com.senac.astec.dao.ImovelDAO;
import com.senac.astec.model.Imovel;
import java.io.IOException;
import java.util.List;
//Classe de Servico de Produto
public class ServicoProduto {
    ImovelDAO produtoDAO = new ImovelDAO();
    
    public void cadastrarProduto(Imovel produto) throws IOException {
        
        

        try {
            //Realiza a chamada de inserção na fonte de dados
            produtoDAO.inserirProduto(produto);
        } catch (Exception e) {
            //Imprime qualquer erro técnico no console e devolve
            //uma exceção e uma mensagem amigável a camada de visão
            e.printStackTrace();
        }
    }

    //Atualiza um produto na fonte de dados
    public void atualizarProduto(Imovel produto) throws IOException {
        

        try {
            produtoDAO.updateProduto(produto);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public  List<Imovel> procurarProduto(String nome, int codigoempresa) throws IOException {
        try {
        return produtoDAO.listarProduto(nome, codigoempresa);
          
        } catch (Exception e) {
            //Imprime qualquer erro técnico no console e devolve
            //uma exceção e uma mensagem amigável a camada de visão
            e.printStackTrace();
            return null;
        }
    }

    public Imovel encontrarProdutoPorNome(String nome, int codigoempresa) throws IOException {
        try {
            return produtoDAO.encontrarProduto(nome, codigoempresa);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public Imovel encontrarProdutoPorCodigo(int codigo, int codigoempresa) throws IOException {
        try {
            return produtoDAO.encontrarProdutoCodigo(codigo, codigoempresa);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public boolean encontrarProdutoCadastro(String nome, int codigoempresa) throws IOException {
        try {
            return produtoDAO.encontrarProdutoCadastro(nome, codigoempresa);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void excluirProduto(Integer codigo, int codigoempresa) throws IOException {
        try {
            produtoDAO.deletarProduto(codigo, codigoempresa);
        } catch (Exception e) {
            System.out.println("Erro");
        }
    }
    
    public void atualizaEstoque(int codigo, int estoque) throws IOException {
        try {
            produtoDAO.atualizarEstoque(codigo, estoque);
        } catch (Exception e) {
            System.out.println("Erro");
        }
    }
    
    //Lista produtos de determinada empresa
    public List<Imovel> listarProdutos(int codigoempresa) throws IOException, Exception {
        try {
            return produtoDAO.listarProdutos(codigoempresa);
            
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    //Lista produtos Totais
    public List<Imovel> listarProdutostotais() throws IOException, Exception {
        try {
            return produtoDAO.listarProdutostotais();
            
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
