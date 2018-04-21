package com.senac.astec.dao;

import com.senac.astec.model.Imovel;
import com.senac.astec.utils.ConexaoBanco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ImovelDAO {
        ConexaoBanco conexaoBanco = new ConexaoBanco();    
        Connection conn = conexaoBanco.createConnection();
    //insere produto
    public void inserirProduto(Imovel produto){
        System.out.println("Iniciando processo de inserção de produto...");
        String query = "insert into produtos (codigoempresa, nome, descricao, codigofornecedor, codigocategoria, precocompra, precovenda, estoque) values (?,?,?,?,?,?,?,?)";
        
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            
            preparedStatement.setInt(1, produto.getCodigoempresa());
            preparedStatement.setString(2, produto.getNome());
            preparedStatement.setString(3, produto.getDescricao());
            preparedStatement.setInt(4, produto.getCategoria());
            preparedStatement.setDouble(5, produto.getPrecocompra());
            preparedStatement.setInt(6, produto.getEstoque());
            
            preparedStatement.executeUpdate();
            preparedStatement.close();
            System.out.println("Produto inserido com sucesso.");
            
        } catch (SQLException ex) {
            System.out.println(ex);
            System.out.println("Erro ao salvar produto");
        }
    }
    //atualiza produto
    public Imovel updateProduto(Imovel produto) throws Exception{
        System.out.println("Atualizando produto...");
         String query = "UPDATE produtos SET codigoempresa=?, nome=?, descricao=?, codigofornecedor=?, codigocategoria=?, precocompra=?, precovenda=?, estoque=? WHERE codigo=?";
        
        
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            
            preparedStatement.setInt(1, produto.getCodigoempresa());
            preparedStatement.setString(2, produto.getNome());
            preparedStatement.setString(3, produto.getDescricao());
            preparedStatement.setInt(4, produto.getCategoria());
            preparedStatement.setDouble(5, produto.getPrecocompra());
            preparedStatement.setInt(6, produto.getEstoque());
            preparedStatement.setInt(7, produto.getCodigo());
            
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException ex) {
            System.out.println("Erro ao atualizar produto");
            throw new Exception("Erro ao atualizar produto", ex);
        }

        return produto;
    }
    //atualiza estoque
    public void atualizarEstoque(int codigo, int estoque) throws Exception{
        System.out.println("Atualizando produto...");
         String query = "UPDATE produtos SET estoque=? WHERE codigo=?";
        
        
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
          
            preparedStatement.setInt(1, estoque);
            preparedStatement.setInt(2, codigo);
            System.out.println("Estoque:"+estoque);
            
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException ex) {
            System.out.println("Erro ao atualizar produto");
            throw new Exception("Erro ao atualizar produto", ex);
        }
    }
    
    //lista produtos
    public List<Imovel> listarProduto(String nome, int codigoempresa){ //retorna todos itens
        List<Imovel> lista = new ArrayList<>();
        System.out.println("Buscando produto na base de dados...");
        String query = "";
        
        boolean vazio = true;
        
        if(nome.length() == 0){
            vazio = true;
            query = "SELECT * FROM produtos WHERE codigoempresa = ?";
        }else{
            vazio = false;
            query = "SELECT * FROM produtos WHERE nome LIKE ? and codigoempresa = ?";
        }
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            
            if(vazio != true){
                preparedStatement.setString(1, nome+"%");
                preparedStatement.setInt(2,codigoempresa);
            }else{
                preparedStatement.setInt(1,codigoempresa);
            }
            
            ResultSet rs = preparedStatement.executeQuery();

            
                while (rs.next()){
                    Imovel produto = new Imovel();
                    produto.setCodigo(rs.getInt(1));
                    produto.setCodigoempresa(rs.getInt(2));
                    produto.setNome(rs.getString(3));
                    produto.setDescricao(rs.getString(4));
                    produto.setCategoria(rs.getInt(5));
                    produto.setPrecocompra(rs.getDouble(6));
                    produto.setEstoque(rs.getInt(7));
                    lista.add(produto);
                }

            System.out.println("Busca efetuada com sucesso");
        } catch (SQLException ex) {
            System.out.println("Erro ao buscar produto"+ex);
        }        
        return lista;
    
    }
    //lista produtos
    public List<Imovel> listarProdutos(int codigoempresa){ //retorna todos itens
        List<Imovel> lista = new ArrayList<>();
        System.out.println("Buscando produto na base de dados...");
        String query = "";
        
        query = "SELECT * FROM produtos WHERE codigoempresa = ?";
      
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            
            preparedStatement.setInt(1,codigoempresa);
            
            ResultSet rs = preparedStatement.executeQuery();

            
            while (rs.next()){
                Imovel produto = new Imovel();
                produto.setCodigo(rs.getInt(1));
                produto.setCodigoempresa(rs.getInt(2));
                produto.setNome(rs.getString(3));
                produto.setDescricao(rs.getString(4));
                produto.setCategoria(rs.getInt(5));
                produto.setPrecocompra(rs.getDouble(6));
                produto.setEstoque(rs.getInt(7));
                lista.add(produto);
            }

            System.out.println("Busca efetuada com sucesso");
        } catch (SQLException ex) {
            System.out.println("Erro ao buscar produto"+ex);
        }        
        return lista;
    
    }
    
    //lista produtos
    public List<Imovel> listarProdutostotais(){ //retorna todos itens
        List<Imovel> lista = new ArrayList<>();
        System.out.println("Buscando produto na base de dados...");
        String query = "";
        
        query = "SELECT * FROM produtos";
      
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            
            ResultSet rs = preparedStatement.executeQuery();

            
            while (rs.next()){
                Imovel produto = new Imovel();
                produto.setCodigo(rs.getInt(1));
                produto.setCodigoempresa(rs.getInt(2));
                produto.setNome(rs.getString(3));
                produto.setDescricao(rs.getString(4));
                produto.setCategoria(rs.getInt(5));
                produto.setPrecocompra(rs.getDouble(6));
                produto.setEstoque(rs.getInt(7));
                lista.add(produto);
            }

            System.out.println("Busca efetuada com sucesso");
        } catch (SQLException ex) {
            System.out.println("Erro ao buscar produto"+ex);
        }        
        return lista;
    
    }
    
    
    //encontra produto por nome
    public Imovel encontrarProduto(String nome, int codigoempresa){//retorna um item
        Imovel produto = new Imovel();
        System.out.println("Buscando produto na base de dados...");
        String query = "";
        boolean vazio = false;
        
        if(nome.length() == 0){
            vazio = true;
            query = "SELECT * FROM produtos WHERE codigoempresa=?";//addicionar o % %
        }else{
            query = "SELECT * FROM produtos WHERE nome=? and codigoempresa=?";//addicionar o % %
        }
        
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            
            if(vazio = false){
                preparedStatement.setString(1,nome);
                preparedStatement.setInt(2,codigoempresa);
            }else{
                preparedStatement.setInt(1,codigoempresa);
            }
            
                        
            ResultSet rs = preparedStatement.executeQuery();
            
            while (rs.next()){
                produto.setCodigo(rs.getInt(1));
                produto.setCodigoempresa(rs.getInt(2));
                produto.setNome(rs.getString(3));
                produto.setDescricao(rs.getString(4));
                produto.setCategoria(rs.getInt(5));
                produto.setPrecocompra(rs.getDouble(6));
                produto.setEstoque(rs.getInt(7));
            }
            
            System.out.println("Busca efetuada com sucesso");
        } catch (SQLException ex) {
            System.out.println("Erro ao buscar produto"+ex);
        }        
        return produto;
    
    }
    
    //encontra produto por nome
    public Imovel encontrarProdutoCodigo(int codigo, int codigoempresa){//retorna um item
        Imovel produto = new Imovel();
        System.out.println("Buscando produto na base de dados...");
        String query = "";
        query = "SELECT * FROM produtos WHERE codigo=? and codigoempresa=?";//addicionar o % %

        
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            
            preparedStatement.setInt(1,codigo);
            preparedStatement.setInt(2,codigoempresa);
            
            ResultSet rs = preparedStatement.executeQuery();
            
            while (rs.next()){
                produto.setCodigo(rs.getInt(1));
                produto.setCodigoempresa(rs.getInt(2));
                produto.setNome(rs.getString(3));
                produto.setDescricao(rs.getString(4));
                produto.setCategoria(rs.getInt(5));
                produto.setPrecocompra(rs.getDouble(6));
                produto.setEstoque(rs.getInt(7));
            }
            
            System.out.println("Busca efetuada com sucesso");
        } catch (SQLException ex) {
            System.out.println("Erro ao buscar produto"+ex);
        }        
        return produto;
    
    }
    
    //encontra produto por nome
    public boolean encontrarProdutoCadastro(String nome, int codigoempresa){//retorna um item
        Imovel produto = new Imovel();
        System.out.println("Buscando produto na base de dados...");
        String query = "SELECT * FROM produtos WHERE nome=? and codigoempresa=?";//addicionar o % %
        boolean encontra = false;
        
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            
            preparedStatement.setString(1,nome);
            preparedStatement.setInt(2,codigoempresa);
                        
            ResultSet rs = preparedStatement.executeQuery();
            
            while (rs.next()){
                encontra = true;
                produto.setCodigo(rs.getInt(1));
                produto.setCodigoempresa(rs.getInt(2));
                produto.setNome(rs.getString(3));
                produto.setDescricao(rs.getString(4));
                produto.setCategoria(rs.getInt(5));
                produto.setPrecocompra(rs.getDouble(6));
                produto.setEstoque(rs.getInt(7));
            }
            
            System.out.println("Busca efetuada com sucesso");
        } catch (SQLException ex) {
            System.out.println("Erro ao buscar produto"+ex);
        }        
        return encontra;
    
    }
    //
    public void deletarProduto(int codigo, int codigoempresa) throws Exception{
        System.out.println("Deletando produto de codigo: "+codigo);
        String query = "DELETE FROM produtos WHERE codigo=? and codigoempresa=?";
        
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            
            preparedStatement.setInt(1, codigo);
            preparedStatement.setInt(2, codigoempresa);   
            preparedStatement.execute();
            
            System.out.println("Produto deletado");
        } catch (SQLException ex) {
            throw new Exception("Erro ao deletar produto", ex);
        }
    }
}
