/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.cdv.model;

import br.com.cdv.dao.FornecedorDAO;
import java.util.List;


public class Fornecedores extends Pessoas {

// atributos   
    private String cnpj;

    public Fornecedores() {

    }

    public Fornecedores(String cnpj) {
        this.cnpj = cnpj;
    }

    public Fornecedores(String cnpj, String nome, String email, String telefone, String celular, String cep, String endereco, int numero, String complemento, String bairro, String cidade, String uf) {
        super(nome, email, telefone, celular, cep, endereco, numero, complemento, bairro, cidade, uf);
        this.cnpj = cnpj;
    }

    public void cadastrar(Fornecedores obj) {
        new FornecedorDAO().cadastrarFornecedores(obj);
    }
    // metodo excluir fornecedor 
    @Override
    public void excluir(int id) {
        new FornecedorDAO().excluirForncedores(id);
    }

    // metodo alterar Fornecedor
    public void alterar(Fornecedores obj) {
        new FornecedorDAO().alterarForncedores(obj);
    }

    // Metodo listar Fornecedores
    public List<Fornecedores> listarFornecedores() {
        return new FornecedorDAO().listarFornecedores();
    }

    // Metodo listar Fornecedores por nome
    public List<Fornecedores> listarFornecedoresPorNome(String nome) {
        return new FornecedorDAO().listarFornecedoresPorNome(nome);
    }

    //Consulta Fornecedores por cnpj
    public Fornecedores consultaPorCnpj(String cnpj) {
        return new FornecedorDAO().consultaPorCnpj(cnpj);

    }

    public Fornecedores consultaPorNome(String nome) {
        return new FornecedorDAO().consultaPorNome(nome);
    }

//Getters e Setters

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    @Override
    public String toString() {

        return this.getNome();

    }

}
