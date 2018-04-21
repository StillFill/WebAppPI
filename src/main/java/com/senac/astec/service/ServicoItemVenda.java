/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senac.astec.service;
import com.senac.astec.dao.ItemVendaDAO;
import com.senac.astec.model.ItemVenda;
import java.io.IOException;
import java.util.List;
public class ServicoItemVenda {
        ItemVendaDAO itemvendadao = new ItemVendaDAO();
    
       //Insere um Produto na fonte de dados Carrinho
    public void cadastraritemVenda(int codigovenda, int codigoproduto, int quantidade) throws IOException, Exception{

        try {
            itemvendadao.cadastrarItemVenda(codigovenda, codigoproduto, quantidade);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    //Realiza a pesquisa e retorna todos os produtos da fonte de dados
    public List<ItemVenda> listarItensVenda(int codigovenda) throws IOException, Exception {
        try {
            return itemvendadao.listarItemVenda(codigovenda);
            
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
