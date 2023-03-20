/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.cdv.model;

import br.com.cdv.dao.ProdutoDAO;
import java.util.List;


public class Produtos {

    // Atributos
    private int id;
    private String descricao;
    private double valor_bruto;
    private double preco;
    private int qtd_estoque;
    private Fornecedores fornecedor;

    public void cadastrar(Produtos obj) {
        new ProdutoDAO().cadastrar(obj);

    }

    // Metodo listar Produtos
    public List<Produtos> listarProdutos() {
       return new ProdutoDAO().listarProdutos();

    }

    // Metodo Alterar Produto 
    public void alterar(Produtos obj) {
        new ProdutoDAO().alterar(obj);

    }

    //metodo excluir Produtos
    public void excluir(Produtos obj) {
        new ProdutoDAO().excluir(obj);

    }

    public List<Produtos> listarProdutosPorNome(String nome) {
        return new ProdutoDAO().listarProdutosPorNome(nome);

    }

    public Produtos consultarProdutosPorNome(String nome) {
        return new ProdutoDAO().consultarProdutosPorNome(nome);
        
    }

    // busca produto por Codigo
    public Produtos buscaPorCodigo(int id) {
        return new ProdutoDAO().buscaPorCodigo(id);

    }
    // Metodo que da baixa no estoque 

    public void baixaEstoque(int id, int qtd_nova) {
        new ProdutoDAO().baixaEstoque(id, qtd_nova);

    }
    // Metodo que retorna o estoque atual de um produto

    public int retornaEstoqueAtual(int id) {
        return new ProdutoDAO().retornaEstoqueAtual(id);
    }

    public void adicionarEstoque(int id, int qtd_nova) {
        new ProdutoDAO().adicionarEstoque(id, qtd_nova);
    }

    public void cadastrarEstoque(ControleEstoque control) {
        new ProdutoDAO().cadastrarEstoque(control);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQtd_estoque() {
        return qtd_estoque;
    }

    public void setQtd_estoque(int qtd_estoque) {
        this.qtd_estoque = qtd_estoque;
    }

    public Fornecedores getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedores fornecedor) {
        this.fornecedor = fornecedor;
    }

    public double getValor_bruto() {
        return valor_bruto;
    }

    public void setValor_bruto(double valor_bruto) {
        this.valor_bruto = valor_bruto;
    }

}
