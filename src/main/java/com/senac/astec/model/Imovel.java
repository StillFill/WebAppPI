package com.senac.astec.model;

public class Imovel {
    
    private Integer codigo;
    private Integer codigoempresa; //crud >> insert getCodigo();
    private String nome;
    private String descricao;
    private Integer categoria; 
    private Double precocompra;
    private Double precoaluguel;
    private Integer estoque;

    public Double getPrecoaluguel() {
        return precoaluguel;
    }

    public void setPrecoaluguel(Double precoaluguel) {
        this.precoaluguel = precoaluguel;
    }
    
    
    
    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getCodigoempresa() {
        return codigoempresa;
    }

    public void setCodigoempresa(Integer codigoempresa) {
        this.codigoempresa = codigoempresa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getCategoria() {
        return categoria;
    }

    public void setCategoria(Integer categoria) {
        this.categoria = categoria;
    }

    public Double getPrecocompra() {
        return precocompra;
    }

    public void setPrecocompra(Double precocompra) {
        this.precocompra = precocompra;
    }

    public Integer getEstoque() {
        return estoque;
    }

    public void setEstoque(Integer estoque) {
        this.estoque = estoque;
    }
    
    
}
